import mpi.MPI;
public class ScatterGather {
public static void main(String args[]) {
// Initialize MPI execution environment
MPI.Init(args);
// Get the ID of the current process
int rank = MPI.COMM_WORLD.Rank();
int size = MPI.COMM_WORLD.Size();
int root = 0;
int totalElements = size;
int[] sendbuf = new int[totalElements]; // Ensure sendbuf is not null for all ranks
// Only the root process initializes the full array
if (rank == root) {
sendbuf[0] = 10;
sendbuf[1] = 20;
sendbuf[2] = 30;
sendbuf[3] = 40;
System.out.print("Processor " + rank + " has original data: ");
for (int i = 0; i < totalElements; i++) {
System.out.print(sendbuf[i] + " ");
}
System.out.println();
}
// Each process will receive 1 element
int[] recvbuf = new int[1];
// Scatter the data to all processes
MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);
// Display the data received by each processor
System.out.println("Processor " + rank + " received: " + recvbuf[0]);
// Each processor processes its data (e.g., doubles it)
recvbuf[0] = recvbuf[0] * 2;
System.out.println("Processor " + rank + " after doubling: " + recvbuf[0]);
// Ensure sendbuf is properly initialized for `Gather`
if (rank == root) {
sendbuf = new int[totalElements]; // Root needs to have an allocated array
}
// Gather the processed data back at the root
MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);
// Root displays final gathered data and computes the sum
if (rank == root) {
System.out.print("Root process received final data: ");
int totalSum = 0;
for (int i = 0; i < totalElements; i++) {
System.out.print(sendbuf[i] + " ");
totalSum += sendbuf[i];
}
System.out.println("\nTotal sum after processing = " + totalSum);
}
// Finalize MPI environment
MPI.Finalize();
}
}