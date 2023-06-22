package src.main.java.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainClient {
    int port;
    InetAddress ia;
    private PrintWriter pr;
    private Scanner scanner;

    private BufferedReader br;

    // methods
    public void startClient(int port, InetAddress ia) {

        try {
            Socket socket = new Socket(ia, port);
            pr = new PrintWriter(socket.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            readThread rt = new readThread(br, socket);
            rt.start();

            while (true) {

                scanner = new Scanner(System.in);
                String messageToServer = scanner.nextLine();
                pr.println(messageToServer);
                if (messageToServer.equals("bye")) {

                    break;

                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MainClient mc = new MainClient();

        try {
            mc.port = 3434;
            mc.ia = InetAddress.getLocalHost();
            mc.startClient(mc.port, mc.ia);

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
