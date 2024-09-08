/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author LENOVO
 */
public class DataInitFile {

    /**
     * @return the fileName
     */
    public int getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(int fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileSize
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public DataInitFile(int fileName, long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
    
    private int fileName;
    private long fileSize;
    
}
