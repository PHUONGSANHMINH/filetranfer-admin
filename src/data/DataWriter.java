/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;

/**
 *
 * @author LENOVO
 */
public class DataWriter {

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
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

    /**
     * @return the accessFile
     */
    public RandomAccessFile getAccessFile() {
        return accessFile;
    }

    /**
     * @param accessFile the accessFile to set
     */
    public void setAccessFile(RandomAccessFile accessFile) {
        this.accessFile = accessFile;
    }

    public DataWriter(File file, long fileSize) throws IOException{
        this.file = file;
        this.fileSize = fileSize;
        accessFile = new RandomAccessFile(file, "rw");
    }
    
    private File file ;
    private long fileSize;
    private RandomAccessFile accessFile;
    
    public synchronized long writeFile (byte[] data) throws IOException{
        accessFile.seek(accessFile.length());
        accessFile.write(data);
        return accessFile.length();
    }
    public void close()throws IOException{
        accessFile.close();
    }
    public String getMaxSize(){
        return convertFile(fileSize);
    }
    public String getCurrentFileSize() throws IOException{
        return convertFile(accessFile.length());
    }
    public double getPercentage() throws IOException{
        double percentage;
        long filePointer = accessFile.length();
        percentage = filePointer * 100 / fileSize;
        return percentage;
    }
    
    private String convertFile(double bytes){
        String[] fileSizeUnits = {"bytes", "KB", "MB", "GB", "TB", "FB", "EB", "ZB", "YB"};
        String sizeToReturn;
        DecimalFormat df = new DecimalFormat("0.#");
        int index;
        for (index = 0; index < fileSizeUnits.length; index++){
            if(bytes < 1024){
                break;
            }
            bytes = bytes/1024;
        }
        System.out.println("Systematic file size : "+ bytes + " "+ fileSizeUnits[index]);
        sizeToReturn = df.format(bytes) + " " + fileSizeUnits[index];
        return sizeToReturn;
    }
}
