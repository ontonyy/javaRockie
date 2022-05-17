package socketsTry.multipleClientsChat;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ClientHandler implements Runnable {
    public static List<ClientHandler> clientHandlers = new LinkedList<>();
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientName = reader.readLine();
            clientHandlers.add(this);
            broadcastMessage("SERVER: " + clientName + " has entered chat!");
        } catch (IOException e) {
            closeEverything(socket, writer, reader);
        }
    }

    @Override
    public void run() {
        String clientMessage;

        while (socket.isConnected()) {
            try {
                clientMessage = reader.readLine();
                broadcastMessage(clientMessage);
            } catch (IOException e) {
                closeEverything(socket, writer, reader);
                break; 
            }
        }
    }

    public void closeEverything(Socket socket, BufferedWriter writer, BufferedReader reader) {
        removeClientHandler();
        try {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                if (!clientHandler.clientName.equalsIgnoreCase(clientName)) {
                    clientHandler.writer.write(message);
                    clientHandler.writer.newLine();
                    clientHandler.writer.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, writer, reader);
            }
        }
    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientName + " has left the chat!");
    }
}
