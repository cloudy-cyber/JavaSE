package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpServer extends Thread {
    private Socket socket;

    public HttpServer(Socket socket) {
        this.socket = socket;
    }

    static Map<String, String> formData;

    @Override
    public void run() {
        try {
            InputStream inputStream=socket.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());
            MbmRequest mbmRequest=MbmRequest.parse(reader);
            String path=mbmRequest.getPath();

            if("/".contains(path)){
            responseHtml("login.html",outputStream);
            }else if(path.contains("welcome.html")){
                System.out.println(path);
                responseWelcome(path,outputStream);
            }else if("/serve/login".equals(path)){
                formData=mbmRequest.getFormData();
                responseRedirect(outputStream,mbmRequest,"welcome.html");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void responseWelcome(String path, DataOutputStream outputStream) {
        InputStream resourAsStream = null;
        resourAsStream = HttpServer.class.getClassLoader().getResourceAsStream("pages" + path);
        assert resourAsStream != null;//断言
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourAsStream));
        try {
            int i = resourAsStream.available() - "${name}".length() - "&{pwd}".length() + URLDecoder.decode(formData.get("name"), "utf-8").length() + (formData.get("pwd").length());
            String contentLength = "Content-Length" + i;
            outputStream.writeBytes("HTTP/1.1 200 OK\r\n");
            outputStream.writeBytes("Content-Type: text/html; charset=utf-8\r\n");
            outputStream.writeBytes(contentLength);
            outputStream.writeBytes("\r\n");
            outputStream.writeBytes("\r\n");

            String line = reader.readLine();
            while (line != null){
                if(line.contains("$")){
                    String name = URLDecoder.decode(formData.get("name"), StandardCharsets.UTF_8);
                    line=line.replace("${name}",name);
                    line=line.replace("${pwd}",formData.get("pwd"));
                    System.out.println(line);
                }
                outputStream.write(line.getBytes());
                outputStream.write(System.lineSeparator().getBytes());
                line=reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void responseHtml(String path,DataOutputStream outputStream) throws IOException {
        InputStream resourceAsStream = null;
        resourceAsStream = HttpServer.class.getClassLoader().getResourceAsStream("pages" + path);
        try {
            String contentLength="Content-Length"+resourceAsStream.available();
            outputStream.writeBytes("HTTP/1.1 200 OK\r\n");
            outputStream.writeBytes("Content-Type: text/html; charset=utf-8\r\n");
            outputStream.writeBytes(contentLength);
            outputStream.writeBytes("\r\n");
            outputStream.writeBytes("\r\n");
            outputStream.write(resourceAsStream.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            resourceAsStream.close();
        }

    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(5000);
        while (true){
            Socket accept=serverSocket.accept();
            HttpServer httpServer=new HttpServer(accept);
            httpServer.start();
        }
    }


    private void responseRedirect(DataOutputStream outputStream,MbmRequest mbmRequest,String path) throws IOException {
        outputStream.writeBytes("HTTP/1.1 302 Found");
        outputStream.writeBytes("\r\n");
        outputStream.writeBytes("Location:"+"http//"+mbmRequest.getHost()+path);
        outputStream.writeBytes("\r\n");
    }
}