package server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String clientUsername;

    public ClientHandler(Socket socket) throws IOException {
        try {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.clientUsername = reader.readLine();
            clientHandlers.add(this);
            broadcastMessage("[SUNUCU] " + clientUsername + " giriş yaptı!");
        } catch (IOException e) {
            socket.close();
            reader.close();
            writer.close();
        }
    }

    @Override
    public void run() {
        String msg;

        while (socket.isConnected()) {
            try {
                msg = reader.readLine();
                broadcastMessage(msg);
            } catch (IOException e) {
                try {
                    socket.close();
                    reader.close();
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }
    }

    public void broadcastMessage(String messageToSend) throws IOException {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                if (!clientHandler.clientUsername.equals(clientUsername)) {
                    clientHandler.writer.write(messageToSend);
                    clientHandler.writer.newLine();
                    clientHandler.writer.flush();
                }
            } catch (IOException e) {
                socket.close();
                reader.close();
                writer.close();
            }
        }
    }

}
