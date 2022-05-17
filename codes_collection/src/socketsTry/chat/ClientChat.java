package socketsTry.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientChat {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean nameIsWritted = false;

    public ClientChat(String address, int port) {
        try {
            socket = new Socket(address, port);
            in = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line = "";
        while (!line.equalsIgnoreCase("exit")) {
            try {
                if (nameIsWritted) {
                    System.out.print("Write message: ");
                } else {
                    System.out.print("Write your name: ");
                    nameIsWritted = true;
                }
                line = in.readLine();
                out.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClientChat client = new ClientChat("127.0.0.1", 5000);
    }
}
