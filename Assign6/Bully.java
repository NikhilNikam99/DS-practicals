import java.util.*;

public class Bully {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of processes in the system: ");
        int n = sc.nextInt();

        int[] ids = new int[n];
        System.out.println("Enter the IDs of all processes (unique integers):");

        for (int i = 0; i < n; i++) ids[i] = sc.nextInt();

        System.out.print("Enter the ID of the process that detects the coordinator failure: ");
        int initiator = sc.nextInt();
        int coord = initiator;

        System.out.println("Process " + initiator + " has detected coordinator failure and initiates the Bully Election Algorithm.");

        for (int i = 0; i < n; i++) {
            if (ids[i] > initiator)
                System.out.println("Process " + initiator + " sends election message to Process " + ids[i]);
        }

        for (int i = 0; i < n; i++) {
            if (ids[i] > coord)
                coord = ids[i];
        }

        System.out.println("Process " + coord + " is elected as the new coordinator.");
    }
}
