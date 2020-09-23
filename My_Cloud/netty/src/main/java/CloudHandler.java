import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.SocketChannel;

import java.util.concurrent.ConcurrentLinkedQueue;

public class CloudHandler extends SimpleChannelInboundHandler<String> {
    private static final ConcurrentLinkedQueue<SocketChannel> channels = new ConcurrentLinkedQueue<SocketChannel>();
private static int cnt = 0;
private String userName = "user#";

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, final String s) throws Exception {
        System.out.printf("Received message from %s: %s\n", userName, s);
        channels.stream()
                .filter(channel -> !channel.equals(ctx.channel()))
                .forEach(channel -> channel.writeAndFlush(String.format("[%s]: %s", userName, s)));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        cnt++;
        userName += cnt;
        System.out.printf("Client %s connected\n", userName);
        channels.add((SocketChannel) ctx.channel());

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.printf("Client %s disconnected\n", userName);
        channels.remove((SocketChannel) ctx.channel());
    }
}
