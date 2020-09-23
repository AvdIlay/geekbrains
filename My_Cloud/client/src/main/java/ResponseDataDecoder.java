import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class ResponseDataDecoder extends ReplayingDecoder<Response> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        out.add(String.valueOf(in.readBytes(in.readableBytes())));
        System.out.println(out);
    }
}
