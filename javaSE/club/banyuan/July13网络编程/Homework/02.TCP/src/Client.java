import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner1=new Scanner(System.in);
        Socket socket=new Socket("127.0.0.1",10000);
        OutputStream out=socket.getOutputStream();
        out.write("加密".getBytes());
        out.flush();
        out.close();

    }
}
