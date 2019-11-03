package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {

        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(8189)) {    // только 1 параметр - порт
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();                     // здесь выполнение блокируется

            System.out.println("Клиент подключился");

//            InputStream in = socket.getInputStream();
//            OutputStream out = socket.getOutputStream();


            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")) {
                    break;
                }
                out.writeUTF("Эхо: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
