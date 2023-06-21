package src.main.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    //methods
    public void startServer(int port){
       try {
        ServerSocket sSocket = new ServerSocket(port);
        SocketManager sm = new SocketManager();
            
        while(true){
            Socket socket = sSocket.accept();
            ServerThread st = new ServerThread(socket,sm);
            st.start();
            sm.addSocket(st);
                        

        }

        
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    

    public static void main(String[] args) {
        MainServer ms = new MainServer();
        ms.startServer(3434);
        System.out.println("end start server");
        // ms.exit();
    }
}
