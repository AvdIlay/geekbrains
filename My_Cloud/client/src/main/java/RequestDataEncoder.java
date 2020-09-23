import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.ReplayingDecoder;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RequestDataEncoder extends MessageToByteEncoder<Request> {

    private final Charset charset = StandardCharsets.UTF_8;

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Request msg, ByteBuf out) throws Exception {
        if (msg instanceof FilesListRequest) {
            out.writeInt(Integer.parseInt(((FilesListRequest) msg).getUserName()));
        }
        if (msg instanceof DownloadRequest) {
            out.writeByte(Integer.parseInt(((DownloadRequest) msg).getUserName()));
            String s = ((DownloadRequest) msg).getUserName();
            System.out.println(s);
            out.writeInt(Integer.parseInt(((DownloadRequest) msg).getFileName()));
            System.out.println(out);
        }
        if (msg instanceof UploadRequest) {
            out.writeInt(Integer.parseInt(((UploadRequest) msg).getUserName()));
            out.writeInt(Integer.parseInt(String.valueOf(((UploadRequest) msg).getFileSize())));
            out.writeInt(Integer.parseInt(((UploadRequest) msg).getFileName()));
        }
    }
}


