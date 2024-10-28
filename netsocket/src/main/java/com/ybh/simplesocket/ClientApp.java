package com.ybh.simplesocket;

import java.io.*;
import java.net.Socket;

public class ClientApp {
    private final static int port = 33333;
    private final static String serverIp = "192.168.0.19";

    public static void main(String[] args) {
        // 클라이언트 소켓을 만든다. (IP주소, 포트번호) (clientSocket)
        // 클라이언트 소켓으로 서버에 접속 시도 한다.
        // 서버와 연결된 클라이언트 소켓으로 읽거나 쓴다.
        // 읽을때는 동기상태 (블로킹)

        try {
            Socket clientSocket = init();
            BufferedWriter socketWriter = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream())
            );
            BufferedReader socketReader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            BufferedReader keyboardReader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            socketWriter.write(String.format("클라이언트[%s] 에서 문자열 전송 함", serverIp));
            socketWriter.newLine();
            socketWriter.flush();

            while (true) {
                String readMsg = socketReader.readLine(); // 블로킹 상태
                System.out.printf("서버 에서 받은 문자열 : %s%n", readMsg);
                if( "exit".equalsIgnoreCase(readMsg) ) {
                    break;
                }

                System.out.print("클라이언트에서 문자열 입력 : ");
                String keyboardMsg = keyboardReader.readLine(); // 블로킹 상태
                socketWriter.write(keyboardMsg);
                socketWriter.newLine();
                socketWriter.flush();
                if( "exit".equalsIgnoreCase(keyboardMsg) ) {
                    break;
                }
            }

            keyboardReader.close();
            socketReader.close();
            socketWriter.close();
            clientSocket.close();
        } catch (IOException ioE) {
            System.out.println("IOException");
            System.out.println(ioE.toString());
        } catch (Exception ex) {
            System.out.println("Exception");
            System.out.println(ex.toString());
        } finally {
            System.out.println("클라이언트 프로그램 종료");
        }
    }
    public static Socket init() throws IOException {
        Socket socket = new Socket(serverIp, port);
        System.out.println("클라이언트 소켓 생성후 서버에 접속 성공");
        return socket;
    }
}