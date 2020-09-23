import java.io.*;

public class FileReadWrite {
    // File
    // InputStream -> потоки данных
    // OutputStream -> потоки данных
    // Reader, Writer
    // буферизация

    public static void copyFrom(File src, File dst) throws IOException {
        System.out.println("copy " + src.length() + " bytes");
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dst);
        byte [] buffer = new byte[8192]; // 8Kb
        int count = 0;
        while ((count = is.read(buffer)) != -1) {
            os.write(buffer, 0, count);
            //System.out.println("read " + count + " bytes");
        }
        os.close();
        is.close();
    }
}