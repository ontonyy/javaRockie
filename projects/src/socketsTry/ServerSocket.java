package socketsTry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerSocket {
    public static void main(String[] args) throws IOException {
        java.net.ServerSocket ss = new java.net.ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("Client is connected");
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String message = bf.readLine();
        System.out.println("client write - " + message);


        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("of course");
        pr.flush();

    }
}
