package Assignment1;

import java.util.Scanner;

public class UserInterface {
    // Attributes
    private Account[] accounts;
    private int accountCount;
    private Scanner scanner;
    private static int nextAccountNumber = 1001; // Starting account number
    private static final int MAX_ACCOUNTS = 100; // Maximum accounts limit
    
    // Constructor
    public UserInterface() {
        accounts = new Account[MAX_ACCOUNTS];
        accountCount = 0;
        scanner = new Scanner(System.in);
    }
    
    // Method to create a new account
    public void createAccount() {
        System.out.println("\n=== Create New Account ===");
        
        try {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine().trim();
            
            // String validation for name
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty!");
                return;
            }
            
            System.out.print("Enter initial deposit amount: ");
            double initialDeposit = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            
            // Validate initial deposit
            if (initialDeposit < 0) {
                System.out.println("Error: Initial deposit cannot be negative!");
                return;
            }
            
            System.out.print("Enter email address: ");
            String email = scanner.nextLine().trim();
            
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine().trim();
            
            // Check if we have space for more accounts
            if (accountCount >= MAX_ACCOUNTS) {
                System.out.println("Error: Maximum number of accounts reached!");
                return;
            }
            
            // Create new account
            Account newAccount = new Account(nextAccountNumber, name, initialDeposit, email, phoneNumber);
            accounts[accountCount] = newAccount;
            accountCount++;
            
            System.out.println("Account created successfully with Account Number: " + nextAccountNumber);
            nextAccountNumber++;
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    // Method to handle deposit operations
    public void performDeposit() {
        System.out.println("\n=== Deposit Money ===");
        
        try {
            System.out.print("Enter account number: ");
            int accountNum = scanner.nextInt();
            
            Account account = findAccount(accountNum);
            if (account == null) {
                System.out.println("Error: Account not found!");
                return;
            }
            
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            
            account.deposit(amount);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter valid numbers.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    // Method to handle withdrawal operations
    public void performWithdrawal() {
        System.out.println("\n=== Withdraw Money ===");
        
        try {
            System.out.print("Enter account number: ");
            int accountNum = scanner.nextInt();
            
            Account account = findAccount(accountNum);
            if (account == null) {
                System.out.println("Error: Account not found!");
                return;
            }
            
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            
            account.withdraw(amount);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter valid numbers.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    // Method to display account details
    public void showAccountDetails() {
        System.out.println("\n=== View Account Details ===");
        
        try {
            System.out.print("Enter account number: ");
            int accountNum = scanner.nextInt();
            
            Account account = findAccount(accountNum);
            if (account == null) {
                System.out.println("Error: Account not found!");
                return;
            }
            
            account.displayAccountDetails();
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter a valid account number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    // Method to update contact details
    public void updateContact() {
        System.out.println("\n=== Update Contact Details ===");
        
        try {
            System.out.print("Enter account number: ");
            int accountNum = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            Account account = findAccount(accountNum);
            if (account == null) {
                System.out.println("Error: Account not found!");
                return;
            }
            
            System.out.print("Enter new email address: ");
            String newEmail = scanner.nextLine().trim();
            
            System.out.print("Enter new phone number: ");
            String newPhoneNumber = scanner.nextLine().trim();
            
            account.updateContactDetails(newEmail, newPhoneNumber);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    // Helper method to find account by account number
    private Account findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }
    
    // Method to display accounts summary (bonus feature)
    public void displayAllAccounts() {
        System.out.println("\n=== All Accounts Summary ===");
        
        if (accountCount == 0) {
            System.out.println("No accounts found.");
            return;
        }
        
        System.out.println("Total Accounts: " + accountCount);
        System.out.println("Account No. | Account Holder | Balance");
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < accountCount; i++) {
            System.out.printf("%-11d | %-14s | $%.2f%n", 
                            accounts[i].getAccountNumber(),
                            accounts[i].getAccountHolderName(),
                            accounts[i].getBalance());
        }
    }
    
    // Main menu method
    public void mainMenu() {
        System.out.println("Welcome to the Banking Application!");
        
        int choice;
        
        do {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. View all accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                // Switch statement for menu navigation (control structure)
                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        performDeposit();
                        break;
                    case 3:
                        performWithdrawal();
                        break;
                    case 4:
                        showAccountDetails();
                        break;
                    case 5:
                        updateContact();
                        break;
                    case 6:
                        displayAllAccounts();
                        break;
                    case 7:
                        System.out.println("Thank you for using Banking Application!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select 1-7.");
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid number!");
                choice = 0; // Reset choice to continue loop
                scanner.nextLine(); // Clear invalid input
            }
            
        } while (choice != 7); // Loop until user chooses to exit
        
        scanner.close(); // Close scanner resource
    }
}

