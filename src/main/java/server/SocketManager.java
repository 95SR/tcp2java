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
        
        sendMessagetoAll(thread.userName + " has left the chat");
        
        clientSockets.remove(thread);
    }

    public  void sendMessage(ServerThread thread, String message){
       
        for (ServerThread item : clientSockets) {
            if(!item.equals(thread)){
                
               
                    item.pw.println(thread.userName+ ": " + message);
                    
                
            }
        }

    }

      public  void sendMessagetoAll( String message){
       
        for (ServerThread item : clientSockets) {
        
                
               
                    item.pw.println( "SERVER: " + message);
                    
                
        
        }

    }

    public void closeSocket(){
        System.out.println("trying to close client socket");
        for (ServerThread item : clientSockets) {
            try {
                 
                item.pw.close();
                item.br.close();
                
                
            
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
    }


}
