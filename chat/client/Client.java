package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 8188);
            System.out.println("Успешно подключен!");
            // Поток ввода
            DataInputStream in = new DataInputStream(socket.getInputStream());
            // Поток вывода
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            String response = in.readUTF();
                            System.out.println(response);
                        }
                    }catch (IOException e){
                        System.out.println("Соединение разорвано");
                    }
                }
            });
            thread.start();

            while (true){
                String text = scanner.nextLine();
                out.writeUTF(text);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
