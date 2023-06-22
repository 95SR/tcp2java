package src.main.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServer {

    //methods
    public void startServer(int port){
       try {
        ServerSocket sSocket = new ServerSocket(port);
        SocketManager sm = new SocketManager();
        serverCmd serverCmd = new serverCmd(sm);
        serverCmd.start();


        while(true){
            
            if(sSocket.isClosed()){
                break;
            } else{
                System.out.println("Accepting client...");
                Socket socket = sSocket.accept();
            System.out.println("New client joined");
            ServerThread st = new ServerThread(socket,sm);
            st.start();
            sm.addSocket(st);

            }
            
           
                        

        }



        
    } catch (IOException e) {
        // TODO Auto-generated catch block
        System.out.println(e);
        System.exit(0);
    }
    }
//thread
    class serverCmd extends Thread{
        //want to read console input from server admin
        private Scanner scanner;
        private SocketManager socketManager;
        private String cmd;
        

        //constructor
        public serverCmd(SocketManager sm){
socketManager = sm;


        }
        @Override
        public void run() {
            System.out.println("enter run");
            scanner = new Scanner(System.in);
            cmd = scanner.nextLine();
            if(cmd.equals("turn off")){
                socketManager.sendMessagetoAll("exit");
                System.exit(1);

                // try {
                //     ssc.close();
                //     socketManager.closeSocket();
                
                // } catch (IOException e) {
                //     // TODO Auto-generated catch block
                //     e.printStackTrace();
                // }
                
            }
        

        }


    }
    

    public static void main(String[] args) {
        MainServer ms = new MainServer();
        ms.startServer(3434);
        
    }
}
