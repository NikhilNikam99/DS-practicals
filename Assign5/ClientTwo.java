import java.io.*;
import java.net.*;

public class ClientTwo {
    public static void main(String[] args) throws IOException {
        Socket sendSocket = new Socket("localhost", 7000);
        PrintStream out = new PrintStream(sendSocket.getOutputStream());

        Socket recvSocket = new Socket("localhost", 7001);
        BufferedReader in = new BufferedReader(new InputStreamReader(recvSocket.getInputStream()));
        PrintStream out2 = new PrintStream(recvSocket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token;
        while (true) {
            System.out.println("Waiting for Token...");
            token = in.readLine();
            if (token.equalsIgnoreCase("Token")) {
                System.out.print("Send data? (Yes/No): ");
                if (br.readLine().equalsIgnoreCase("Yes")) {
                    System.out.print("Enter data: ");
                    out.println(br.readLine());
                }
                out2.println("Token");
            }
        }
    }
}
