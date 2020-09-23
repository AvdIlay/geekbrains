import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ResponseDataEncoder extends MessageToByteEncoder<Response> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Response msg, ByteBuf out) throws Exception {
        if (msg instanceof FilesListResponse) {
            out.writeInt(Integer.parseInt(String.valueOf(((FilesListResponse) msg).getFilesList())));
        }
        if (msg instanceof DownloadResponse) {
            out.writeByte(Integer.parseInt(String.valueOf(((DownloadResponse) msg).getFileSize())));
            System.out.println(out);
            out.writeInt(Integer.parseInt(((DownloadResponse) msg).getFileName()));
            System.out.println(out);
        }
    }
}