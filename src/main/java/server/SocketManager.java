package src.main.java.server;

import java.io.IOException;
import java.util.ArrayList;

public class SocketManager {
    //fields
    private ArrayList<ServerThread> clientSockets = new ArrayList<ServerThread>();

    //constructor

    //method
    public void addSocket(ServerThread thread){
        clientSockets.add(thread);
        System.out.println(clientSockets);
    }

    public void removeSocket(ServerThread thread){

    }

    public  void sendMessage(ServerThread thread, String message){
        for (ServerThread item : clientSockets) {
            if(!item.equals(thread)){
                try {
                    item.bw.write(message);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }


}
