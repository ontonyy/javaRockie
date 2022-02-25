package socketsTry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("is it working?");
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String message = bf.readLine();
        System.out.println("server message - " + message);

    }
}
