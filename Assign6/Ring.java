import java.util.*;

public class Ring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("No. of processes: ");
        int n = sc.nextInt();
        int[] ids = new int[n + 1];
        boolean[] active = new boolean[n + 1];

        System.out.println("Enter process IDs:");
        for (int i = 1; i <= n; i++) {
            ids[i] = sc.nextInt();
            active[i] = true;
        }

        System.out.print("Initiator index (1 - " + n + "): ");
        int init = sc.nextInt();
        int curr = init, max = ids[init];

        System.out.println("Process " + ids[init] + " starts election.");

        do {
            curr = curr % n + 1; // wrap from n to 1
            if (active[curr]) {
                System.out.println("Process " + ids[curr] + " gets message.");
                if (ids[curr] > max) max = ids[curr];
            }
        } while (curr != init);

        System.out.println("New coordinator: Process " + max);
        sc.close();
    }
}
