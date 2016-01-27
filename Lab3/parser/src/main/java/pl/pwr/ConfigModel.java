package pl.pwr;

/**
 * Created by Alek on 12/13/2015.
 */
public class ConfigModel {
    private String fileName;
    private String outputFileName;
    private String errorsFileName;
    private int rowsPerFile;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public String getErrorsFileName() {
        return errorsFileName;
    }

    public void setErrorsFileName(String errorsFileName) {
        this.errorsFileName = errorsFileName;
    }

    public int getRowsPerFile() {
        return rowsPerFile;
    }

    public void setRowsPerFile(int rowsPerFile) {
        this.rowsPerFile = rowsPerFile;
    }
}
