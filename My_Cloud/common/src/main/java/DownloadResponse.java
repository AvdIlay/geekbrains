public class DownloadResponse implements Response {

    private String fileName;
    private long fileSize;

    public String getFileName(){
        return fileName;
    }
    public long getFileSize(){
        return fileSize;
    }
}
