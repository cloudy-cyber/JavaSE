package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MbmRequest {
    private String method;
    private String path;
    private String host;
    private int contentLength;
    private String payload;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    static MbmRequest parse(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        if (line == null) {
            return null;

        }
        MbmRequest mbmRequest = new MbmRequest();
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        mbmRequest.setMethod(stringTokenizer.nextToken());//ip
        mbmRequest.setPath(stringTokenizer.nextToken());//login.html


        //截取Content-Length:内的长度值以及host地址
        while (line != null && line.length() != 0) {
            if (line.startsWith("Content-Length")) {
                int i = Integer.parseInt(line.replace("Content-Length: ", ""));
                mbmRequest.setContentLength(i);
            } else if (line.startsWith("Host:")) {
                mbmRequest.setHost(line.replace("Host: ", ""));
            }
            line = bufferedReader.readLine();
        }
        //截取form表单里的内容,放入到payload中
        if (mbmRequest.getContentLength() > 0) {
            char[] chars = new char[mbmRequest.getContentLength()];
            bufferedReader.read(chars, 0, chars.length);
            mbmRequest.setPayload(new String(chars));
        }
        return mbmRequest;
    }

    //解析账号密码的内容
    public Map<String, String> getFormData() {
        Map<String, String> data = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(payload, "&|=");
        while (stringTokenizer.hasMoreTokens()) {
            data.put(stringTokenizer.nextToken(),stringTokenizer.nextToken());
        }
        return data;
    }
}
