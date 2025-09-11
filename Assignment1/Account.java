package Assignment1;

public class Account {
    // Attributes
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;
    
    // Constructor
    public Account(int accountNumber, String accountHolderName, double initialDeposit, 
                   String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Method to deposit money
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive!");
            return false;
        }
        balance += amount;
        System.out.println("Successfully deposited $" + amount);
        System.out.println("New balance: $" + balance);
        return true;
    }
    
    // Method to withdraw money
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive!");
            return false;
        }
        if (amount > balance) {
            System.out.println("Error: Insufficient funds! Current balance: $" + balance);
            return false;
        }
        balance -= amount;
        System.out.println("Successfully withdrew $" + amount);
        System.out.println("Remaining balance: $" + balance);
        return true;
    }
    
    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("\n=== Account Details ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("=====================");
    }
    
    // Method to update contact details
    public void updateContactDetails(String newEmail, String newPhoneNumber) {
        // String validation for email (basic check)
        if (newEmail != null && newEmail.contains("@") && newEmail.contains(".")) {
            this.email = newEmail;
            System.out.println("Email updated successfully!");
        } else {
            System.out.println("Error: Invalid email format!");
        }
        
        // String validation for phone number (basic check)
        if (newPhoneNumber != null && newPhoneNumber.length() >= 10 && 
            newPhoneNumber.matches("\\d+")) {
            this.phoneNumber = newPhoneNumber;
            System.out.println("Phone number updated successfully!");
        } else {
            System.out.println("Error: Invalid phone number format!");
        }
    }
    
    // Getter methods
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
}
