import com.dropbox.core.*;

import java.io.*;

/**
 * Application is listening to folder and automatically sending files created/putted there to you dropbox
 */
public class Main {

    public static void main(String[] args) throws IOException, DbxException, InterruptedException {

        //Creating connection
        DropboxConnection conn = new DropboxConnection();
        if(!conn.dbxAuth()) System.exit(-1);

        System.out.print("Enter path to the folder you want to listen: ");
        final String path = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

        //Creating folder listener
        FolderListener folderListener = new FolderListener(path,conn);
        folderListener.start();

        System.out.println("Listening to folder: " + path);
        System.out.println("Type exit to close the program");
        while(true) {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().trim().equals("exit")) {
                folderListener.exit();
                break;
            }
        }
    }
}
