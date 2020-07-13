//编写一个Udp客户端，从键盘接收目标ip地址，端口号和发送的消息，将消息发送到指定位置

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
            String s;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            s = scanner.nextLine();
            String[] strings = s.split(" ");
            if (strings.length == 1 && strings[0].equals("quit")) {
                System.out.println("程序退出");
                return;
            } else if (strings.length == 3) {
                InetAddress address = InetAddress.getByName(strings[0]);
                byte[] bytes = strings[2].getBytes();
                DatagramSocket socket = new DatagramSocket();
                DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, Integer.parseInt(strings[1]));
                socket.send(packet);
                socket.close();
            } else {
                System.out.println("输入不合法");
            }
        }

//
    }
}
