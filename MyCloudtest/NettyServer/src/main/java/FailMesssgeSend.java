class FileMessageSend extends AbstractMessage {
    private String name;
    private byte [] data;

    public FileMessageSend() {}

    private FileMessageSend(FileMessageSendBuilder builder) {
        name = builder.nameB;
        data = builder.dataB;
    }

    public String getName() {
        return name;
    }

    public byte[] getData() {
        return data;
    }

    public static class FileMessageSendBuilder {

        private String nameB;
        private byte [] dataB;

        public FileMessageSendBuilder name(String name) {
            nameB = name;
            return this;
        }

        public FileMessageSendBuilder data(byte [] data) {
            dataB = data;
            return this;
        }

        public FileMessageSend build() {
            return new FileMessageSend(this);
        }
    }

    public static FileMessageSendBuilder builder() {
        return new FileMessageSendBuilder();
    }

}