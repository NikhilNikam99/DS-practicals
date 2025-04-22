import java.net.*;
import java.rmi.*;
public class AddServer {
public static void main(String args[]) {
try {
AddServerImpl addServerImpl = new AddServerImpl(); Naming.rebind("//127.0.0.1/AddServer", obj);
System.out.println("in server side");
}
catch(Exception e) { System.out.println("Exception: " + e);
}
}
}
