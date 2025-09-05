import java.util.Scanner;
public class Factorial {    // Using recursion
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        long factorial = factorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);
        scanner.close();
    }
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}