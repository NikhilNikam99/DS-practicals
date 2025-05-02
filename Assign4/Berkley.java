/*
import java.io.*;
import java.util.*;
public class Berkley
{
float diff(int h, int m, int s, int nh, int nm, int ns){
int dh = h-nh;
int dm = m-nm;
int ds = s-ns;
int diff = (dh*60*60)+(dm*60)+ds;
return diff;
}
float average(float diff[], int n){
int sum=0;
for(int i=0; i<n; i++)
{
sum+=diff[i];
}
float average = (float)sum/(n+1);
System.out.println("The average of all time differences is "+average);
return average;
}
void sync(float diff[], int n, int h, int m, int s, int nh[], int nm[], int ns[], float average)
{
for(int i=0;i<n;i++)
{
diff[i]+=average;
int dh=(int)diff[i]/(60*60);
diff[i]%=(60*60);
int dm=(int)diff[i]/60;
diff[i]%=60;
int ds=(int)diff[i];nh[i]+=dh;
if(nh[i]>23)
{
nh[i]%=24;
}
nm[i]+=dm;
if(nm[i]>59)
{
nh[i]++;
nm[i]%=60;
}
ns[i]+=ds;
if(ns[i]>59)
{
nm[i]++;
ns[i]%=60;
}
if(ns[i]<0)
{
nm[i]--;
ns[i]+=60;
}
}
h+=(int)(average/(60*60));
if(h>23)
{ h%=24;
}
m+=(int)(average/(60*60*60));
if(m>59)
{
h++;
m%=60;
}
s+=(int)(average%(60*60*60));
if(s>59)
{
m++;s%=60;
}
if(s<0)
{
m--;
s+=60;
}
System.out.println("The synchronized clocks are:\nTime Server ---> "+h+" : "+m+" : "+s);
for(int i=0;i<n;i++)
{
System.out.println("Node "+(i+1)+" ---> "+nh[i]+" : "+nm[i]+" : "+ns[i]);
}
}
public static void main(String[] args) throws IOException {
Berkley b = new Berkley();
Date date = new Date();
BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter number of nodes:");
int n = Integer.parseInt(obj.readLine()); int h = date.getHours();
int m = date.getMinutes();
int s = date.getSeconds();
int nh[] = new int[n];
int nm[] = new int[n];
int ns[] = new int[n];
for(int i=0; i<n; i++)
{
System.out.println("Enter time for node "+(i+1)+"\n Hours:");
nh[i]=Integer.parseInt(obj.readLine());
System.out.println("Minutes:");
nm[i]=Integer.parseInt(obj.readLine());
System.out.println("Seconds:");
ns[i]=Integer.parseInt(obj.readLine());
}
for(int i=0; i<n; i++)
{
System.out.println("Time Server sent time "+h+" : "+m+" : "+s+" to node "+(i+1));
}float diff[] = new float[n];
for(int i=0;i<n;i++)
{
diff[i] = b.diff(h,m,s,nh[i],nm[i],ns[i]);
System.out.println("Node "+(i+1)+" sent time difference of "+(int)diff[i]+" to Time Server.");
}
float average = b.average(diff,n);
b.sync(diff, n, h, m, s, nh, nm, ns, average);
}
}
*/
import java.io.*;
import java.util.*;

public class Berkley {
    
    static int getSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    static void printTime(String label, int seconds) {
        int h = (seconds / 3600) % 24;
        int m = (seconds % 3600) / 60;
        int s = seconds % 60;
        System.out.println(label + " ---> " + h + " : " + m + " : " + s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Date date = new Date();
        int serverTime = getSeconds(date.getHours(), date.getMinutes(), date.getSeconds());

        System.out.print("Enter number of nodes: ");
        int n = Integer.parseInt(br.readLine());
        int[] nodeTimes = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter time for node " + (i + 1));
            System.out.print("Hours: "); int h = Integer.parseInt(br.readLine());
            System.out.print("Minutes: "); int m = Integer.parseInt(br.readLine());
            System.out.print("Seconds: "); int s = Integer.parseInt(br.readLine());
            nodeTimes[i] = getSeconds(h, m, s);
        }

        float totalDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = serverTime - nodeTimes[i];
            totalDiff += diff;
            printTime("Time Server sent time to node " + (i + 1), serverTime);
            System.out.println("Node " + (i + 1) + " sent time difference of " + diff + " to Time Server.");
        }

        float avgDiff = totalDiff / (n + 1);
        System.out.println("The average of all time differences is " + avgDiff);

        // Sync times
        int newServerTime = serverTime + (int) avgDiff;
        printTime("Time Server", newServerTime);

        for (int i = 0; i < n; i++) {
            nodeTimes[i] += avgDiff;
            printTime("Node " + (i + 1), nodeTimes[i]);
        }
    }
}
