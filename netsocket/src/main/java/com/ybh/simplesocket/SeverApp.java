package com.ybh.simplesocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverApp {
    private final static int port = 33333;
    // 0~9999 까지는 대부분 프로그램이 사용
    // 0~65500 까지 포트 사용가능

    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {

        // 서버 소켓을 만든다. (listenSocket)
        // 포트를 지정하고 bind, listen 으로 클라이언트 접속 할 때 까지 대기한다.(블로킹 상태) 동기상태
        // 클라이언트로부터 접속이 되면 클라이언트와 통신할 소켓을 리턴한다. (acceptSocket)
        // 클라이언트와 연결된 소켓으로 읽거나 쓴다. 읽을때는 동기상태 (블로킹)

        try {
            Socket acceptSocket = init();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(acceptSocket.getInputStream())
            );
            String msg = reader.readLine();
            System.out.printf("%s%n", msg);
            reader.close();
            acceptSocket.close();
        } catch (IOException ioE) {
            System.out.println("IOException");
            System.out.println(ioE.toString());
        } catch (Exception ex) {
            System.out.println("Exception");
            System.out.println(ex.toString());
        }
    }

    public static Socket init() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("서버소켓으로 클라이언트 접속 대기 중");
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트 연결 됨");
        return socket;
    }
}
