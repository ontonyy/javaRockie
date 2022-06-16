package kryonet;


import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ClientKry  extends Listener {
    static Client client;

    static String ip = "localhost";
    static int udpPort = 27960, tcpPort = 27960;

    static boolean messageReceived = false;

    public static void main(String[] args) throws Exception {
        System.out.println("Connection to the server...");

        client = new Client();

        client.getKryo().register(PacketMessage.class);

        client.start();

        client.connect(5000, ip, tcpPort, udpPort);

        client.addListener(new ClientKry());
        System.out.println("Connected! The client is now waiting for a packet...\n");

        while (!messageReceived) {
            Thread.sleep(1000);
        }

        System.out.println("Client will now exit");
        System.exit(0);
    }

    @Override
    public void received(Connection connection, Object o) {
        if (o instanceof PacketMessage) {
            PacketMessage packet = (PacketMessage) o;
            System.out.println("Received a message from the host: " + packet.message);

            messageReceived = true;
        }
    }
}
