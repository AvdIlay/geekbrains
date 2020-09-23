public class UploadRequest implements Request {

    private String userName;
    private String fileName;
    private long fileSize;


    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName) {this.userName = userName;}

    public String getFileName(){
        return fileName;
    }
    public void setFileName(String fileName) {this.fileName = fileName; }

    public long getFileSize(){
        return fileSize;
    }
    public void setFileSize(long fileSize) {this.fileSize = fileSize; }

    public UploadRequest(String userName, String fileName, long fileSize){
        this.userName = userName;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
}