import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.CharsetUtil;
import javafx.scene.control.ListView;

import java.awt.*;
import java.io.*;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientHandler extends ChannelHandlerAdapter {



    public ClientHandler(Path dir, String userName) {
    }

  /*  @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("We connected to server Localhost");

    }*/

   @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
     if(msg instanceof FilesListResponse){
         handlerFilesList(ctx, (FilesListResponse) msg);
     }
    }

    public void handlerFilesList (ChannelHandlerContext ctx, FilesListResponse msg) {
        ArrayList<String> filesList = (ArrayList<String>) msg.getFilesList();
        for (int i = 0; i < filesList.size(); i++) {
            String filename = filesList.get(i);
            System.out.println(filename);
          //  Controller.listView1.getItems().add("Hiel");
            ctx.close();
        }
    }
}

