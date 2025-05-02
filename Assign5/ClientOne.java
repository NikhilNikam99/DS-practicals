import java.io.*;
import java.net.*;

public class ClientOne {
    public static void main(String[] args) throws IOException {
        Socket sendSocket = new Socket("localhost", 7000);
        PrintStream out = new PrintStream(sendSocket.getOutputStream());

        ServerSocket ss = new ServerSocket(7001);
        Socket recvSocket = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(recvSocket.getInputStream()));
        PrintStream out1 = new PrintStream(recvSocket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token = "Token", input;
        while (true) {
            if (token.equalsIgnoreCase("Token")) {
                System.out.print("Send data? (Yes/No): ");
                input = br.readLine();
                if (input.equalsIgnoreCase("Yes")) {
                    System.out.print("Enter data: ");
                    out.println(br.readLine());
                }
                out1.println("Token");
            }
            System.out.println("Waiting for Token...");
            token = in.readLine();
        }
    }
}
