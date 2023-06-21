package src.main.java.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainClient {
    int port;
    InetAddress ia;

    //methods
    public void startClient(int port, InetAddress ia){
        System.out.println(port);
        try {
            Socket socket = new Socket(ia, port);
            
            new Thread1().start();
            new Thread2().start();;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        MainClient mc = new MainClient();
        
        
        
        try {
            mc.port =3434;
            mc.ia = InetAddress.getLocalHost();
             mc.startClient(mc.port, mc.ia);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       

    }
}
