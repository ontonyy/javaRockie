package kryonet.echoServer;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class ClientEcho {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
        try {
            client.connect(5000, "localhost", 54555, 54777);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Server is not started. Cannot connect");
        }

        client.getKryo().register(Packet.class);
        client.getKryo().register(PacketConnect.class);
        client.getKryo().register(PacketLine.class);

        client.addListener(new Listener() {
            @Override
            public void received(Connection connection, Object o) {
                if (o instanceof Packet) {
                    if (o instanceof PacketLine) {
                        PacketLine packetLine = (PacketLine) o;
                        System.out.println(packetLine.message);
                    }
                }
            }
        });

        PacketConnect p1 = new PacketConnect();
        p1.name = "mazafaka";
        client.sendTCP(p1);

        while (client.isConnected()) {
            String line = scanner.nextLine();
            PacketLine p2 = new PacketLine();
            p2.message = line;
            if (line.equalsIgnoreCase("exit")) break;
            client.sendTCP(p2);
        }
    }
}
