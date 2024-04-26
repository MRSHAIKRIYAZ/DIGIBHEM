import java.util.Scanner;

// Class representing a bank account
class Account {
    private String userId;
    private String userPin;
    private double balance;

    public Account(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Your new balance is: $" + balance);
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
        } else {
            System.out.println("Insufficient funds. Unable to withdraw.");
        }
    }

    // Method to transfer money to another account
    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds. Unable to transfer.");
        }
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        // Add code to display transaction history
    }
}

// Main class representing the ATM interface
public class ATM556 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample account details
        Account account = new Account("user123", "1234", 1000);

        System.out.println("Welcome to the ATM Interface");
        System.out.print("Enter User ID: ");
        String userIdInput = scanner.nextLine();

        System.out.print("Enter User PIN: ");
        String userPinInput = scanner.nextLine();

        if (userIdInput.equals(account.getUserId()) && userPinInput.equals(account.getUserPin())) {
            System.out.println("Authentication successful.");
            boolean exit = false;
            while (!exit) {
                System.out.println("\nSelect an option:");
                System.out.println("1. View Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        account.displayTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's User ID: ");
                        String recipientId = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        // Assuming recipient's account details are known
                        Account recipient = new Account(recipientId, "", 0);
                        account.transfer(recipient, transferAmount);
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Thank you for using the ATM Interface.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } else {
            System.out.println("Authentication failed. Please try again later.");
        }
    }
}

