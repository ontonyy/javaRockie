package socketsTry.chat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServerChat {
    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;
    private Map<String, Socket> clients = new LinkedHashMap<>();

    public ServerChat(int port) {
        try {
            server = new ServerSocket(port);

            System.out.println("Server started");
            System.out.println("Waiting a client...");

            socket = server.accept();

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";

            while (!line.equalsIgnoreCase("exit")) {
                line = in.readUTF();
                if (!clients.containsValue(socket)) {
                    System.out.println("Client enter with name: " + line);
                    clients.put(line, socket);
                } else {
                    System.out.println(getName(socket) + " wrote: " + line);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName(Socket socket) {
        for (String s : clients.keySet()) {
            if (clients.get(s) == socket) {
                return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        ServerChat server = new ServerChat(5000);
    }
}
