

public class FileMessage extends AbstractMessage {

    private String userName;
    private String name;
    private byte [] data;

    public FileMessage() {}

    private FileMessage(FileMessageBuilder builder) {
        userName = builder.userNameB;
        name = builder.nameB;
        data = builder.dataB;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }

    public String getUserName() { return  userName;}

    public static class FileMessageBuilder {

        private String userNameB;
        private String nameB;
        private byte [] dataB;

        public FileMessageBuilder name(String name) {
            nameB = name;
            return this;
        }

        public FileMessageBuilder userName (String userName) {
            userNameB = userName;
            return this;
        }

        public FileMessageBuilder data(byte[] data) {
            dataB = data;
            return this;
        }

        public FileMessage build() {
            return new FileMessage(this);
        }
    }

    public static FileMessageBuilder builder() {
        return new FileMessageBuilder();
    }

}