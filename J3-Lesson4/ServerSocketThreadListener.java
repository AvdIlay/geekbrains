package ru.gb.jtwo.network;

import java.net.ServerSocket;
import java.net.Socket;

public interface ServerSocketThreadListener {

    void onServerStarted(ServerSocketThread thread);
    void onServerCreated(ServerSocketThread thread, ServerSocket server);
    void onServerTimeout(ServerSocketThread thread, ServerSocket server);
    void onSocketAccepted(ServerSocketThread thread, ServerSocket server, Socket socket);
    void onServerException(ServerSocketThread thread, Throwable throwable);
    void onServerStop(ServerSocketThread thread);

    void onSocketStart(SocketThread thread, Socket socket);

    void onSocketStop(SocketThread thread);

    void onSocketReady(SocketThread thread, Socket socket);

    void onReceiveString(SocketThread thread, Socket socket, String msg);

    void onSocketException(SocketThread thread, Throwable throwable);
}
