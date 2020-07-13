import java.io.IOException;
import java.net.*;

public class Receive {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        DatagramSocket socket = new DatagramSocket(5000);
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
    }
}
