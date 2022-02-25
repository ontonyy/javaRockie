package kryonet;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.util.Date;

public class ServerKry extends Listener {
    static Server server;
    static int udpPort = 27960, tcpPort = 27960;

    public static void main(String[] args) throws IOException {
        System.out.println("Creating the server....");

        server = new Server();

        server.getKryo().register(PacketMessage.class);

        server.bind(tcpPort, udpPort);
        server.start();

        server.addListener(new ServerKry());

        System.out.println("Server is operational!");
    }

    @Override
    public void connected(Connection connection) {
        System.out.println("Received a connection from " + connection.getRemoteAddressTCP().getHostString());
        PacketMessage message = new PacketMessage();
        message.message = "Hello friend! The time is" + new Date().toString();

        connection.sendTCP(message);
    }

    @Override
    public void received(Connection connection, Object o) {
        // When receive something.
    }

    @Override
    public void disconnected(Connection connection) {
        System.out.println("A client is disconnected!");
    }
}
