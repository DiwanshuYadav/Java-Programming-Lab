import java.util.Scanner;

public class SimpleATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double balance = 1000.0; 
        int choice;
        
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Your Current Balance: ₹" + balance);
                    break;
                    
                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = sc.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("₹" + deposit + " deposited successfully!");
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = sc.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("₹" + withdraw + " withdrawn successfully!");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient Balance!");
                    } else {
                        System.out.println("Invalid withdraw amount!");
                    }
                    break;
                    
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
            
        } while (choice != 4);
        
        sc.close();
    }
}