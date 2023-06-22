package src.main.java.server;

import java.io.BufferedReader;

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
    public BufferedReader br;
    public PrintWriter pw;
    private String message;
     SocketManager scManager;
     public String userName;
     
    


    //constructor
    public ServerThread(Socket socket,SocketManager sm){
        try {
            
            instream = socket.getInputStream();
            br= new BufferedReader(new InputStreamReader(instream));

            outstream = socket.getOutputStream();
            pw = new PrintWriter(outstream, true);

            scManager = sm;
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
            this.userName = br.readLine();

            while(true){
                
                
                message = br.readLine();
                if (message.equals("bye")){
                    pw.close();
                    scManager.removeSocket(this);
                    
                    break;
                }
                
                
                scManager.sendMessage(this, message);

            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


       
    }


    //methods 있으면
}
