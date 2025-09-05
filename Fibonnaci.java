import java.util.Scanner;
public class Fibonnaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fib = new int[n];
        
        // Initialize the first two terms
        fib[0] = 0;
        fib[1] = 1;
        
        // Calculate the remaining terms
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        // Print the sequence
        System.out.println("Fibonacci Sequence:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i] + " ");
        }
        scanner.close();
    }
}
