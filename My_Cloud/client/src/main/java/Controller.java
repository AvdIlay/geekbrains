import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

public class Controller  implements Initializable {
    String server = "localhost";
    int port = 8080;
    public ListView<String> listView;
    public ListView<String> listView1;
    public TextField text;
    public TextField log;
    @FXML
    private TextField username;
    public Button upload;
    public Button download;
    private Socket socket;
    private static ObjectDecoderInputStream is;
    private static ObjectEncoderOutputStream os;
    private String clientPath = "client/ClientStorage/";
    private File dir = new File(clientPath);
    private byte[] buffer;


    public void downloadFile(ActionEvent actionEvent) {
       /* String name = listView1.getSelectionModel().getSelectedItem();
        String[] names = name.split(" ");
        for (String finalName : names) {

        }*/
    }

    public void uploadFile(ActionEvent actionEvent) {
        String name = listView.getSelectionModel().getSelectedItem();
        String[] names = name.split(" ");
        for (String finalName : names) {
            name = finalName;
            File file = new File(clientPath + name);
            try {
                FileInputStream is = new FileInputStream(file);
                buffer = new byte[is.available()];
                is.read(buffer, 0, buffer.length);
                ObjectEncoderOutputStream os = new ObjectEncoderOutputStream(socket.getOutputStream());
                os.writeObject(FileMessage.builder()
                        .name(name)
                        .data(buffer)
                        .build());
                os.flush();
                os.close();
                is.close();

                break;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        for (File file : dir.listFiles())
            listView.getItems().add(file.getName() + "   |  " + file.length() + "bytes");

    }


    public void login(ActionEvent actionEvent) {
            String userName = username.getText();
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap().
                        group(group)
                        .channel(NioSocketChannel.class)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel socketChannel) throws Exception {
                                socketChannel.pipeline()
                                        .addLast(new ObjectEncoder(),
                                                new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
                                                new ClientHandler(Paths.get(clientPath), userName) {
                                                    @Override
                                                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                                        ctx.writeAndFlush(new FilesListRequest(userName));
                                                        System.out.println(userName + " is your login");
                                                    }

                                                }
                                        );
                            }
                        });
                ChannelFuture f = bootstrap.connect(server, port).sync();
                f.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }
        }
        }


