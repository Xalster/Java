import com.dropbox.core.*;

import java.io.*;
import java.util.Locale;

/**
 *Creating dropbox connection.
 *
 */
public class DropboxConnection {

    private final String APP_KEY = "3i9nq0hf22irysa";
    private final String APP_SECRET = "9y6cld5rwu17r2v";
    private DbxClient client;

    /**
     * Authorizing connection with dropbox
     *
     * @return true if authorization was successful
     */
    public Boolean dbxAuth(){

        //Creating confing
        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY,APP_SECRET);
        DbxRequestConfig config = new DbxRequestConfig("DropboxApp", Locale.getDefault().toString());
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config,appInfo);
        String authorizeUrl = webAuth.start();

        System.out.println("1. Go to : " + authorizeUrl + "\n"
                + "2. Click \' Allow \'" + "\n"
                + "3. Copy the authorization code and paste it here: ");

        //Authorization
        String code;
        try {
            code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();
            DbxAuthFinish authFinish = webAuth.finish(code);
            String accessToken = authFinish.accessToken;

            client = new DbxClient(config, accessToken);
            System.out.println("Logged as: " + client.getAccountInfo().displayName);
        } catch (IOException | DbxException e) {
            System.err.println("Wrong authorization code / couldn't connect to servers");
            return false;
        }

        return true;
    }

    /**
     *
     * @param path to file
     * @return true if sending was successful
     * @throws IOException
     */
    public Boolean sendFile(String path) throws IOException {

        File inputFile = new File(path);
        FileInputStream inputStream = new FileInputStream(inputFile);

        try {

            DbxEntry.File uploadedFile = client.uploadFile("/" + path.substring(path.lastIndexOf("\\")+1), DbxWriteMode.add(),inputFile.length(),inputStream);
            System.out.println("File has been sent successfully");
        } catch (DbxException e) {
            return false;
        }

        return true;
    }
}
