package ru.gb.jtwo.network;

import java.net.Socket;

public interface SocketThreadListener {

    void onSocketStart(Runnable thread, Socket socket);
    void onSocketStop(Runnable thread);
    void onSocketReady(Runnable thread, Socket socket);
    void onReceiveString(Runnable thread, Socket socket, String msg);
    void onSocketException(Runnable thread, Throwable throwable);

}
