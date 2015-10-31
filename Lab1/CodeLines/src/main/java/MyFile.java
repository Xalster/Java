import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Alek on 14.10.2015.
 */
public class MyFile {

    private Integer all = 0, brackets = 0, emptyLines = 0, comments = 0;
    private Boolean insideComment = false;

    public void Load(){

        try{
            //wczytywanie pliku
            File file = new File("src/main/java/MyFile.java");
            FileReader read = new FileReader(file);
            BufferedReader readFile = new BufferedReader(read);
            String line;
            while ((line = readFile.readLine()) != null){

                all++;
                if(line.startsWith("//"))
                    if(!insideComment)
                        comments++;

                if(line.startsWith("*/")) {
                    insideComment = true;
                }

                if(line.contains("*/")){
                    comments++;
                    insideComment=false;
                }

                if(insideComment)
                    comments++;

                if(line.startsWith("{"))
                    if(!insideComment)
                        brackets++;

                if(line.endsWith("}"))
                    if(!insideComment)
                        brackets++;

                if(line.isEmpty())
                    if(!insideComment)
                        emptyLines++;
            }
        /* Mleko(){
            Mleko;
         }
        */
            read.close();
        }catch (Exception e){

            e.printStackTrace();
        }
    }
    public void all(){

        System.out.println("Wszystkich linii: "+all);
    }

    public void withoutComments(){

        System.out.println("Wszystkich linii bez komentarzy: "+ (all-comments));
    }
    public void withoutBrackets(){

        System.out.println("Wszystkich linii bez komentarzy i nawiasow: "+(all-(comments+brackets)));
    }

    public void withoutEmpty()
    {
        System.out.println("Wszystkich linii bez komentarzy, nawiasow i pustych: "+(all-(comments+brackets+emptyLines)));
    }
}
