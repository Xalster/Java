package pl.pwr;

import sun.security.ssl.Debug;

import java.io.*;
import java.net.URI;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Alek on 12/13/2015.
 */
public class Main {


    public static void main(String[] args) {
        String path = String.valueOf(Main.class.getResource("/data.csv").getPath());
        try {
            ConfigModel config = new ConfigReader().readProperties();
            FileReader fr = new FileReader(path);
            Set<Model> items = CsvConverter.Deserialize(fr);
            Set<Model> invalidItems = new HashSet<Model>();
            for(Model item : items) {
                if(!item.hasValidEmail())
                    invalidItems.add(item);
            }
            items.removeAll(invalidItems);
            CsvConverter.Serialize(items, config, true);
            CsvConverter.Serialize(invalidItems, config, false);
            Debug.println("Size", String.valueOf(items.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
