package src.main.java.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;



class sendThread extends Thread{
    private PrintWriter pr;
    
    private Scanner scanner;
    public Socket csocket;


    //constructor
    public sendThread(Socket socket){
        
        try {
            
            OutputStream outstream = socket.getOutputStream();
            
            pr = new PrintWriter(outstream, true);
            csocket = socket;
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    @Override
    public void run() {

        
        while(true){
            System.out.println(csocket.isConnected());
            System.out.println(csocket.isBound());
            

        scanner= new Scanner(System.in);
        String messageToServer = scanner.nextLine();
        pr.println(messageToServer);
        if(messageToServer.equals("bye")){
           
            
            break;

        }
        

        }
        
    }

}

// class readThread extends Thread{
//     private BufferedReader br;
//     private InputStream instream;
//     private String fromServer;
//     private Scanner scanner;
//     private Socket cSocket;
//     public boolean connectionEnd = false;

//     //constructor
//     public readThread(Socket socket) {
//         try {
//             instream= socket.getInputStream();
//             br = new BufferedReader(new InputStreamReader(instream));
//             cSocket = socket;
            
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
        

//     }


//     @Override
//     public void run() {
//         System.out.println("Enter username:");
//         while(true){
//             try {
//                 System.out.println(instream.available());
                
//                 fromServer = br.readLine();
//                 System.out.println("fromserver" + fromServer);

               



//                 if(fromServer==null){
//                      System.out.println("enter null");
//                      connectionEnd = true;
                     


//                     //br.close();
//                     cSocket.close();
//                     break;
//                 }
                
//                 System.out.println(fromServer);
//             } catch (IOException e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//             }

           

            
//         }
//     }
// }


class readThread extends Thread{
    private BufferedReader br;
    private InputStream instream;
    private String fromServer;
    private Scanner scanner;
    private Socket cSocket;
    public boolean connectionEnd = false;

    //constructor
    public readThread(BufferedReader bufferedReader, Socket socket) {
        br=bufferedReader;
cSocket = socket;
    }


    @Override
    public void run() {
        System.out.println("Enter username:");
        while(true){
            try {
               
                
                fromServer = br.readLine();
                //System.out.println("fromserver" + fromServer);

               



                if(fromServer==null){
                     //System.out.println("enter null");
                     connectionEnd = true;
                     


                    br.close();
                    cSocket.close();
                    System.exit(1);
                    //cSocket.close();
                    break;
                }
                
                System.out.println(fromServer);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

           

            
        }

    }
}
