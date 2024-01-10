import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit Successful. Current Balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Funds. Unable to Withdraw.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful. Current Balance: " + balance);
            return true;
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                System.out.println("Current Balance: " + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter Deposit Amount: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter Withdrawal Amount: ");
                double withdrawAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Exiting. Thank you for using a service!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option!. Please try again!.");
                break;
        }
    }
}

public class ATMinterface {
    public static void main(String[] args) {
        // Initial balance set to 500
        BankAccount userAccount = new BankAccount(500.0); 
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            atm.processOption(choice, scanner);
        }
    }
}
