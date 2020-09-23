import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class FileHandler  extends ChannelHandlerAdapter {

    private static final ConcurrentLinkedQueue<SocketChannel> channels = new ConcurrentLinkedQueue<SocketChannel>();
   // private static int cnt = 0;
   // private String userName = "user#";
    private Path servdir;

    public FileHandler(Path servdir) {
        this.servdir = servdir;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof FilesListRequest) {
            String userName = ((FilesListRequest) msg).getUserName();
            System.out.printf("%s connected", userName);
            sendFilesList(ctx, userName);
        }
        if (msg instanceof DownloadRequest) {
            handlerDownloadResponse();
        }
        if (msg instanceof UploadRequest) {
            handlerUploadResponse();
        }
    }

   /* private void handlerFilesList(ChannelHandlerContext ctx, FilesListRequest msg){
        String username = msg.getUserName();
        sendFilesList(ctx, username);

    }*/

    private void sendFilesList(ChannelHandlerContext ctx, String username) {
        try {
            Path clientsDir = servdir.resolve(username);
            if (!Files.exists(clientsDir)) {
                Files.createDirectory(clientsDir);
            }
            List<String> listFiles = Files
                    .list(clientsDir)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toList());
            FilesListResponse flr = new FilesListResponse(listFiles);
            ctx.writeAndFlush(flr)
                    .addListener(ChannelFutureListener.CLOSE);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void handlerDownloadResponse(){

    }
    private void handlerUploadResponse(){

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {


        channels.add((SocketChannel) ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //System.out.printf("Client %s disconnected\n", userName);
        channels.remove((SocketChannel) ctx.channel());
    }
}
