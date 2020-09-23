import java.util.List;

public class FilesListRequest implements Request {

    private String userName;


   public String getUserName() {
        return userName;
    }


    public FilesListRequest(String userName) {
        this.userName = userName;
    }
}
