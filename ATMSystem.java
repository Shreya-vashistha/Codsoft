import java.util.Scanner;

// BankAccount class represents a user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: rs." + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: rs." + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance for withdrawal.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the current balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class represents the ATM machine interface
class ATM {
    private BankAccount account;

    // Constructor to initialize ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // User interface for ATM
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        // Loop to allow continuous interaction with the ATM
        do {
            System.out.println("\n--- ATM Interface ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:  // Check balance
                    System.out.println("Current Balance: $" + account.checkBalance());
                    break;
                case 2:  // Deposit money
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:  // Withdraw money
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:  // Exit
                    System.out.println("Exiting ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
        scanner.close();
    }
}

// Main class to test the ATM and BankAccount classes
public class ATMSystem {
    public static void main(String[] args) {
        // Create a BankAccount with an initial balance of $500
        BankAccount userAccount = new BankAccount(500);
        
        // Create the ATM instance
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}
