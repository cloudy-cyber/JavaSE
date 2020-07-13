//编写一个Udp服务器，服务器接收Udp客户端发送的消息，另外服务器也会接收键盘输入，当键盘输入quit，则服务器程序退出

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new DatagramSocket(3000);

        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));

            if (scanner.nextLine().equals("quit")) {
                return;
            }
        }
    }

}

