public class Factorial {
    // Using recursion
    public static void main(String[] args) {
        int number = 5; // Example number
        long factorial = factorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);
    }

    // Recursive method to calculate factorial
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}