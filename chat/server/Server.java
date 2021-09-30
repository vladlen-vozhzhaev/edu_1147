package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<String> usersName = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188);
            System.out.println("Сервер запущен");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Подключился новый клиент");
                User currentUser = new User(socket);
                users.add(currentUser);
                currentUser.setOos(new ObjectOutputStream(currentUser.getSocket().getOutputStream()));
                currentUser.setIn(new DataInputStream(currentUser.getSocket().getInputStream()));
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String text;
                        try {
                            currentUser.getOos().writeObject("Введите имя: "); // Отправка клиенту
                            String userName = currentUser.getIn().readUTF(); // Получаем от клиента
                            currentUser.setUserName(userName);
                            usersName.add(userName);

                            for (User user : users) {
                                user.getOos().writeObject(new ArrayList<>(usersName)); // Отправка клиенту
                                user.getOos().writeObject("Пользователь "+currentUser.getUserName()+" присоеденился к беседе");
                            }

                            while (true) {
                                text = currentUser.getIn().readUTF();
                                if(text.equals("/onlineUsers")){
                                    String names = "Пользователи онлайн: ";
                                    for (User user: users){
                                        names += user.getUserName()+", ";
                                    }
                                    currentUser.getOos().writeObject(names); // Отправили список
                                }else if(text.indexOf("/m") == 0){
                                    String[] splittedText = text.split(" ");
                                    for(User user : users){
                                        if(user.getUserName().equals(splittedText[1])){
                                            user.getOos().writeObject(splittedText[2]);
                                            break;
                                        }
                                    }
                                }else{
                                    // Рассылка сообщения
                                    System.out.println(currentUser.getUserName()+": " + text);
                                    for (User user : users) {
                                        if (currentUser.getUuid().equals(user.getUuid())) continue;
                                        user.getOos().writeObject(currentUser.getUserName()+": " + text);
                                    }
                                }

                            }
                        } catch (IOException exception) {
                            users.remove(currentUser); // Удалить User
                            usersName.remove(currentUser.getUserName()); // Удалить имя из списка
                            for (User user : users) {
                                try {
                                    user.getOos().writeObject(new ArrayList<>(usersName));
                                    user.getOos().writeObject("Пользователь "+currentUser.getUserName()+" покинул беседу");
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
