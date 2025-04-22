import java.util.Scanner;
public class Bully {
static boolean[] state = new boolean[5];
public static void up(int up) {
if (state[up - 1]) {
System.out.println("Process " + up + " is already up");
} else {
int i;
state[up - 1] = true;
System.out.println("Process " + up + " held election");
for (i = up; i < 5; ++i) {
System.out.println("Election message sent from process " + up + " to process " + (i + 1));
}
for (i = up + 1; i <= 5; ++i) {
if (!state[i - 1]) continue;
System.out.println("Alive message sent from process " + i + " to process " + up);
break;
}
}
}
public static void down(int down) {
if (!state[down - 1]) {
System.out.println("Process " + down + " is already down.");
} else {
state[down - 1] = false;
System.out.println("Process " + down + " is now down.");
}
}
public static void mess(int mess) {
if (state[mess - 1]) {
if (state[4]) {
System.out.println("OK");
} else if (!state[4]) {
int i;
System.out.println("Process " + mess + " election");
for (i = mess; i < 5; ++i) {
System.out.println("Election sent from process " + mess + " to process " + (i + 1));
}
for (i = 5; i >= mess; --i) {
if (!state[i - 1]) continue;
System.out.println("Coordinator message sent from process " + i + " to all");
break;
}
}
} else {
System.out.println("Process " + mess + " is down");
}
}
public static void main(String[] args) {
int choice;
Scanner sc = new Scanner(System.in);
for (int i = 0; i < 5; ++i) {
state[i] = true;
}
System.out.println("5 active processes are:");
System.out.println("Process up = p1 p2 p3 p4 p5");
System.out.println("Process 5 is coordinator");
do {
System.out.println(" ........ ");
System.out.println("1. Bring up a process.");
System.out.println("2. Bring down a process.");
System.out.println("3. Send a message");
System.out.println("4. Exit");
choice = sc.nextInt();
switch (choice) {
case 1: {
System.out.println("Bring process up");
int up = sc.nextInt();
if (up == 5) {
System.out.println("Process 5 is co-ordinator");
state[4] = true;
break;
}
up(up);
break;
}
case 2: {
System.out.println("Bring down any process.");
int down = sc.nextInt();
down(down);
break;
}
case 3: {
System.out.println("Which process will send a message?");
int mess = sc.nextInt();
mess(mess);
break;
}
}
} while (choice != 4);
sc.close();
}
}