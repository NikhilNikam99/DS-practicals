// ReverseServer.java
import ReverseModule.ReverseHelper; // Add this if missing
import ReverseModule.Reverse;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
class ReverseServer {
public static void main(String[] args) {
try {
// Initialize the ORB
ORB orb = ORB.init(args, null);
// Initialize the POA
POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
rootPOA.the_POAManager().activate();
// Create an instance of ReverseImpl
ReverseImpl rvr = new ReverseImpl();
org.omg.CORBA.Object ref = rootPOA.servant_to_reference(rvr);
Reverse h_ref = ReverseHelper.narrow(ref);
// Register with Naming Service
org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
String name = "Reverse";
NameComponent path[] = ncRef.to_name(name);
ncRef.rebind(path, h_ref);
System.out.println("Reverse Server is running...");
orb.run();
} catch (Exception e) {
e.printStackTrace();
}
}
}