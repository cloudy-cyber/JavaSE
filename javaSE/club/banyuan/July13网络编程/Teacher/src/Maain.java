import java.io.IOException;
import java.net.*;

public class Maain {
    public static void main(String[] args) throws IOException {
        byte[] buffer = "戴宇翔".getBytes();
        InetAddress address = InetAddress.getByName("192.168.9.27");
        DatagramPacket packet = new DatagramPacket(
                buffer, buffer.length, address, 5000);
        DatagramSocket datagramSocket = new DatagramSocket();
        datagramSocket.send(packet);
    }
}
