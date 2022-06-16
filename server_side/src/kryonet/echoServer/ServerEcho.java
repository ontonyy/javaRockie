package kryonet.echoServer;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

public class ServerEcho {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
        server.bind(54555, 54777);

        server.getKryo().register(Packet.class);
        server.getKryo().register(PacketConnect.class);
        server.getKryo().register(PacketLine.class);

        server.addListener(new Listener() {
            @Override
            public void received(Connection connection, Object o) {
                if (o instanceof Packet) {
                    if (o instanceof PacketConnect) {
                        PacketConnect p1 = (PacketConnect) o;
                        System.out.println(p1.name + " connected!");
                    } else if (o instanceof PacketLine) {
                        PacketLine line = (PacketLine) o;
                        System.out.println("Client send: " + line.message);

                        PacketLine resend = new PacketLine();
                        resend.message = "You send: " + line.message;
                        connection.sendTCP(resend);
                    }
                }
            }
        });
    }
}
