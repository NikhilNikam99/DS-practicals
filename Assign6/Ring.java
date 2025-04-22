import java.util.Scanner;
import java.util.InputMismatchException;
public class Ring {
public static void main(String[] args) {
int temp, i, j;
Rr proc[] = new Rr[10];
for (i = 0; i < proc.length; i++) proc[i] = new Rr();
Scanner in = new Scanner(System.in);
int num = 0;
while (true) {
try {
System.out.println("Enter the number of processes: ");
num = in.nextInt();
if (num <= 0 || num > 10) {
System.out.println("Please enter a number between 1 and 10.");
continue;
}
break; // Exit the loop if input is valid
} catch (InputMismatchException e) {
System.out.println("Invalid input. Please enter an integer.");
in.next(); // Clear the invalid input
}
}
for (i = 0; i < num; i++) {
proc[i].index = i;
while (true) {
try {
System.out.println("Enter the id of process: ");
proc[i].id = in.nextInt();
break; // Exit the loop if input is valid
} catch (InputMismatchException e) {
System.out.println("Invalid input. Please enter an integer.");
in.next(); // Clear the invalid input
}
}
proc[i].state = "active";
proc[i].f = 0;
}
for (i = 0; i < num - 1; i++) {
for (j = 0; j < num - 1; j++) {
if (proc[j].id > proc[j + 1].id) {
temp = proc[j].id;
proc[j].id = proc[j + 1].id;
proc[j + 1].id = temp;
}
}
}
for (i = 0; i < num; i++) {
System.out.print(" [" + i + "]" + " " + proc[i].id);
}
int init;
int ch;
int temp1;
int temp2;
int arr[] = new int[10];
proc[num - 1].state = "inactive";
System.out.println("\nProcess " + proc[num - 1].id + " selected as co-ordinator");
while (true) {
System.out.println("\n1. Election 2. Quit ");
while (true) {
try {
ch = in.nextInt();
break; // Exit the loop if input is valid
} catch (InputMismatchException e) {
System.out.println("Invalid input. Please enter an integer.");
in.next(); // Clear the invalid input
}
}
for (i = 0; i < num; i++) {
proc[i].f = 0;
}
switch (ch) {
case 1:
System.out.println("\nEnter the Process number who initialized election: ");
while (true) {
try {
init = in.nextInt();
init--;
if (init < 0 || init >= num) {
System.out.println("Invalid process number. Please try again."); continue;
}
break; // Exit the loop if input is valid
} catch (InputMismatchException e) {
System.out.println("Invalid input. Please enter an integer.");
in.next(); // Clear the invalid input
}
}
temp2 = init;
temp1 = init + 1;
i = 0;
while (temp2 != temp1) {
if ("active".equals(proc[temp1].state) && proc[temp1].f == 0) {
System.out.println("\nProcess " + proc[init].id + " sends message to "
+proc[temp1].id);
proc[temp1].f = 1;
init = temp1;
arr[i] = proc[temp1].id;
i++;
}
if (temp1 == num) {
temp1 = 0;
} else {
temp1++;
}
}
System.out.println("\nProcess " + proc[init].id + " sends message to " + proc[temp1].id);
arr[i] = proc[temp1].id;
i++;
int max = -1;
for (j = 0; j < i; j++) {
if (max < arr[j]) {
max = arr[j];
}
}
System.out.println("\nProcess " + max + " selected as co-ordinator");
for (i = 0; i < num; i++) {
if (proc[i].id == max) {
proc[i].state = "inactive";
}
}
break;
case 2:
System.out.println("Program terminated ...");
return;
default:
System.out.println("\nInvalid response \n");
break;
}
}
}
}
class Rr {
public int index;
public int id;
public int f;
String state;
}