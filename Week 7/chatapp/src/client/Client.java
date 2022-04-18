package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String username;

    public Client(Socket socket, String username) throws IOException {
        try {
            this.socket = socket;
            this.username = username;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Bağlantı başarıyla kuruldu!");
        } catch (IOException e) {
            socket.close();
            reader.close();
            writer.close();
        }
    }

    public void sendMessage() throws IOException {
        try {
            writer.write(username);
            writer.newLine();
            writer.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String messageToSend = scanner.nextLine();
                writer.write(username + ": " + messageToSend);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            socket.close();
            reader.close();
            writer.close();
        }
    }

    public void listen() {
        new Thread(() -> {
            String msg;
            while (socket.isConnected()) {
                try {
                    System.out.print("> ");
                    msg = reader.readLine();
                    System.out.println(msg);
                } catch (IOException e) {
                    try {
                        socket.close();
                        reader.close();
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı adınız: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 8080);

        Client client = new Client(socket, username);
        client.listen();
        client.sendMessage();
    }
}
