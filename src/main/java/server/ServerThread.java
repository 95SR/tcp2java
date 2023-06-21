package src.main.java.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    //fields
    private InputStream instream;
    private OutputStream outstream;
    private BufferedReader br;
    public BufferedWriter bw;
    private String message;
    private SocketManager sm;
    


    //constructor
    public ServerThread(Socket socket,SocketManager sm){
        try {
            instream = socket.getInputStream();
            br= new BufferedReader(new InputStreamReader(instream));

            outstream = socket.getOutputStream();
            bw = new BufferedWriter(new PrintWriter(outstream, true));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }


    //run
    @Override
    public void run() {
        
           //read from client
           //send to others
           try {

            while(true){
                message = br.readLine();
                sm.sendMessage(this, message);

            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


       
    }


    //methods 있으면
}
