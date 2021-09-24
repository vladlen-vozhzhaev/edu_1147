package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188);
            System.out.println("Сервер запущен");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Подключился новый клиент");
                User currentUser = new User(socket);
                users.add(currentUser);
                currentUser.setOut(new DataOutputStream(currentUser.getSocket().getOutputStream()));
                currentUser.setIn(new DataInputStream(currentUser.getSocket().getInputStream()));
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String text;
                        try {
                            currentUser.getOut().writeUTF("Введите имя: ");
                            String userName = currentUser.getIn().readUTF();
                            currentUser.setUserName(userName);
                            for (User user : users) {
                                user.getOut().writeUTF("Пользователь "+currentUser.getUserName()+" присоеденился к беседе");
                            }

                            while (true) {
                                text = currentUser.getIn().readUTF();
                                if(text.equals("/onlineUsers")){
                                    String names = "Пользователи онлайн: ";
                                    for (User user: users){
                                        names += user.getUserName()+", ";
                                    }
                                    currentUser.getOut().writeUTF(names); // Отправили список
                                }else{
                                    // Рассылка сообщения
                                    System.out.println(currentUser.getUserName()+": " + text);
                                    for (User user : users) {
                                        if (currentUser.getUuid().equals(user.getUuid())) continue;
                                        user.getOut().writeUTF(currentUser.getUserName()+": " + text);
                                    }
                                }

                            }
                        } catch (IOException exception) {
                            users.remove(currentUser);
                            for (User user : users) {
                                try {
                                    user.getOut().writeUTF("Пользователь "+currentUser.getUserName()+" покинул беседу");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("Пользователь "+currentUser.getUserName()+" покинул беседу");
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
