import java.io.*;
import java.net.*;

public class MutualServer implements Runnable {
    Socket socket;
    static ServerSocket ss;

    MutualServer(Socket s) { socket = s; }

    public static void main(String[] args) throws IOException {
        ss = new ServerSocket(7000);
        System.out.println("Server Started");
        while (true)
            new Thread(new MutualServer(ss.accept())).start();
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String msg;
            while ((msg = in.readLine()) != null)
                System.out.println(msg);
        } catch (IOException e) {}
    }
}
