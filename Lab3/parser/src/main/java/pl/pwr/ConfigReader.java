package pl.pwr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Alek on 12/13/2015.
 */
public class ConfigReader {
    String result = "";
    InputStream inputStream;

    public ConfigModel readProperties() throws IOException {
        ConfigModel config = new ConfigModel();
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            config.setFileName(prop.getProperty("fileName"));
            config.setOutputFileName(prop.getProperty("outputFileName"));
            config.setErrorsFileName(prop.getProperty("errorsFileName"));
            config.setRowsPerFile(Integer.parseInt(prop.getProperty("rowsPerFile")));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return config;
    }
}
