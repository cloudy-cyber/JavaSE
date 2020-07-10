import java.io.*;

public class Main {

    public static void spilt(File sourceFile, int size, File targetFolder) throws IOException {
        FileInputStream fis = new FileInputStream(sourceFile);
       if(!targetFolder.exists()){
           targetFolder.mkdirs();
       }else {
           byte[]bytes=new byte[10240];
           int count=0;
           int i=1;
           while ((count=fis.read(bytes,0,bytes.length))!=-1){
               File file=new File("/Users/edz/daiyuxiang/javaSE/club/banyuan/July9 IO/Homework/01.SplitFile/newMP3","WIN.mp3."+i);
               OutputStream os=new FileOutputStream(file);
               os.write(bytes,0,count);
               i++;
           }
       }
    }
    public static void combine(File sourceFolder, File targetFolder) throws IOException {
        File[] files=sourceFolder.listFiles();
        OutputStream os=new FileOutputStream(targetFolder);
        byte[] buf=new byte[102400];
        for (File file : files) {
            InputStream is=new FileInputStream(file);
            int count=0;
            while ((count=is.read(buf)) >0){
                os.write(buf,0,count);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        File file=new File("/Users/edz/daiyuxiang/javaSE/club/banyuan/July9 IO/doc/WIN.mp3");
        File file1=new File("/Users/edz/daiyuxiang/javaSE/club/banyuan/July9 IO/Homework/01.SplitFile","newMP3");
        File file2=new File("/Users/edz/daiyuxiang/javaSE/club/banyuan/July9 IO/Homework/01.SplitFile/finalMP3","WIN.mp3");
        spilt(file,10,file1);
        combine(file1,file2);
    }

}

