package pl.pwr;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alek on 12/13/2015.
 */
public class CsvConverter {

    public static final String CSV_SEPARATOR = ",";

    public static String createFilePath(String fileName, int fileNo) {
        return String.format("%s_%d.csv", fileName, fileNo);
    }

    public static void Serialize(Set<Model> model, ConfigModel config, boolean valid) {
        try {
            String outputFileName = valid ? config.getOutputFileName() : config.getErrorsFileName();
            int fileNo = 1;
            int rowNo = 0;
            BufferedWriter bw = getBufferedReader(fileNo, outputFileName);
            for(Model item : model) {
                rowNo++;
                String line = convertModelItemToString(item);
                bw.write(line);
                bw.newLine();
                if(rowNo == config.getRowsPerFile()) {
                    fileNo++;
                    rowNo = 0;
                    bw.flush();
                    bw.close();
                    bw = getBufferedReader(fileNo, outputFileName);
                }
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedWriter getBufferedReader(int fileNo, String outputFileName) throws UnsupportedEncodingException, FileNotFoundException {
        String fileName = outputFileName.substring(0, outputFileName.lastIndexOf('.'))+"_{0}.csv";
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName.replace("{0}", String.valueOf(fileNo))), "UTF-8"));
    }

    private static String convertModelItemToString(Model item) {
        StringBuffer sb = new StringBuffer();
        sb.append(item.getId());
        sb.append(CSV_SEPARATOR);
        sb.append(item.getFirstName());
        sb.append(CSV_SEPARATOR);
        sb.append(item.getLastName());
        sb.append(CSV_SEPARATOR);
        sb.append(item.getEmail());
        sb.append(CSV_SEPARATOR);
        sb.append(item.getCcNumber());
        sb.append(CSV_SEPARATOR);
        sb.append(item.getPhone());
        sb.append(CSV_SEPARATOR);
        sb.append(item.getDollars());
        return sb.toString();
    }

    public static Set<Model> Deserialize(FileReader csvFileReader) {
        Set<Model> model = new HashSet<Model>();
        try {
            BufferedReader br = new BufferedReader(csvFileReader);
            String line;
            while((line = br.readLine()) != null) {
                String[] lineArray = line.split(CSV_SEPARATOR);
                Model modelItem = new Model();
                modelItem.setId(Integer.parseInt(lineArray[0]));
                modelItem.setFirstName(lineArray[1]);
                modelItem.setLastName(lineArray[2]);
                modelItem.setEmail(lineArray[3]);
                modelItem.setCcNumber(Double.parseDouble(lineArray[4]));
                modelItem.setPhone(lineArray[5]);
                modelItem.setDollars(lineArray[6]);
                model.add(modelItem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }


}
