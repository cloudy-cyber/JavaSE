import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",10000);
        InputStream in=socket.getInputStream();
        int data=in.read();
        in.close();
        socket.close();
    }
}
