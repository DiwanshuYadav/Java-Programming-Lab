import java.util.Scanner;
public class discount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input purchase amount
        System.out.print("Enter purchase amount: ");
        double amount = sc.nextDouble();
        double discount, finalAmount;

        // Check conditions
        if (amount > 100) {
            discount = amount * 0.10;  // 10% discount
        } else {
            discount = amount * 0.05;  // 5% discount
        }

        finalAmount = amount - discount;

        // Output
        System.out.println("Original Amount: " + amount);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount to Pay: " + finalAmount);

        sc.close();
    }
}