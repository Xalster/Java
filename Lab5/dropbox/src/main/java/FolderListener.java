import java.io.IOException;
import java.nio.file.*;

/**
 * New thread that listens a folder for changes
 */
public class FolderListener extends Thread{

    /**
     *
     * @param path - Path to folder
     * @param conn - Connection with dropbox
     */
    FolderListener(String path, DropboxConnection conn){
        this.path = path;
        this.conn = conn;
    }

    private String path;
    private DropboxConnection conn;
    private Boolean exit = false;


    @Override
    public void run(){

        //Creating Watchservice
        WatchService watchService;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get(path);
            dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        } catch (IOException e) {
            System.err.println("Error in creating or registering watcher");
            return;
        }

        //Creating Watchkey
        WatchKey key;
        try {
            key = watchService.take();
        } catch (InterruptedException e) {
            System.err.println("Error in taking watcher");
            return;
        }

        while(!exit) {

            for (WatchEvent<?> event : key.pollEvents()){
                WatchEvent.Kind<?> kind = event.kind();

                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path filename = ev.context();

                if(kind.name().equals("ENTRY_CREATE")){

                    try {
                        String newPath = path + "\\" + filename;
                        Thread.sleep(1000);
                        conn.sendFile(newPath);
                    } catch (IOException e) {
                        System.err.println("Error in sending a file");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        key.reset();
                    }
                }
            }
        }
    }

    /**
     * Use to end thread
     */
    public void exit(){
        exit = true;
    }

}
