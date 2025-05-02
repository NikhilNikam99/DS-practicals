import java.rmi.Naming;

public class AddServer {
    public static void main(String[] args) {
        try {
            Naming.rebind("AddServer", new AddServerImpl());
        } catch (Exception e) {
            System.out.println("Server Exception: " + e);
        }
    }
}