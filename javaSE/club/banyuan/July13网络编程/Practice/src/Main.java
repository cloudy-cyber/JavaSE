import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 65536; i++) {
            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket(i);
                socket.close();
            } catch (SocketException e) {
                list.add(i);
            }
        }
        System.out.println(list);
    }
}
