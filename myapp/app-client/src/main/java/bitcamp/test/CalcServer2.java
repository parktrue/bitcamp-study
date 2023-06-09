package bitcamp.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer2 {
  public static void main(String[] args) throws Exception {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행!");

      while (true) {
        processReques(serverSocket.accept());
      }
    }
  }

  static void processReques(Socket socket) {
    InetSocketAddress sockAddr = (InetSocketAddress) socket.getRemoteSocketAddress();
    System.out.printf("%s(%d) 클라이언트 접속!", sockAddr.getHostString(), sockAddr.getPort());

    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      int result = 0;

      String op = in.readUTF();
      if (op.equals("quit")) {
        return;
      }

      int value = in.readInt();

      switch (op) {
        case "+":
          result += value;
          break;
        case "-":
          result -= value;
          break;
        case "*":
          result *= value;
          break;
        case "/":
          result /= value;
          break;
        case "%":
          result %= value;
          break;
        default:
          out.writeUTF("지원하지 않는 연산자입니다!");
      }
      out.writeUTF(String.format("%d", result));
    } catch (Exception e) {
      System.out.printf("%s(%d) 클라이언트 통신오류!!\n", sockAddr.getHostString(), sockAddr.getPort());
    }
  }
}
