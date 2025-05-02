import java.rmi.Naming;

public class AddClient {
    public static void main(String[] args) {
        try {
            AddServerIntf obj = (AddServerIntf) Naming.lookup("rmi://" + args[0] + "/AddServer");
            double d1 = Double.parseDouble(args[1]);
            double d2 = Double.parseDouble(args[2]);
            System.out.println("Sum: " + obj.add(d1, d2));
        } catch (Exception e) {
            System.out.println("Client Exception: " + e);
        }
    }
}