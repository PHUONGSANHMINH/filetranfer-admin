/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.corundumstudio.socketio.SocketIOClient;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author LENOVO
 */
public class DataClient {

    /**
     * @return the socketIOClient
     */
    public SocketIOClient getSocketIOClient() {
        return socketIOClient;
    }

    /**
     * @param socketIOClient the socketIOClient to set
     */
    public void setSocketIOClient(SocketIOClient socketIOClient) {
        this.socketIOClient = socketIOClient;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public DataClient(SocketIOClient socketIOClient, String name) {
        this.socketIOClient = socketIOClient;
        this.name = name;
    }

    public DataClient() {
    }
    
    private SocketIOClient socketIOClient;
    private String name;
    private HashMap<Integer, DataWriter> list = new HashMap<>();
    
    public void addWriter (DataWriter data, int fileID){
        list.put(fileID, data);
    }
    public void writeFile(byte[] data, int fileID) throws IOException{
        list.get(fileID).writeFile(data);
    }
    public void closeWriter(int fileID) throws IOException{
        list.get(fileID).close();
    }
    public Object[] toRowTable (int row){
        return new Object[] {this,row,name};
    }
}
