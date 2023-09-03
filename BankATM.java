import java.util.Scanner;

class CustomerAccount {
    private String accHolderName;
    private double accBalance;

    public CustomerAccount(String accHolderName, double initialBalance) {
        this.accHolderName = accHolderName;
        this.accBalance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            accBalance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && accBalance >= amount) {
            accBalance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return accBalance;
    }
}

class AutomatedTellerMachine {
    private CustomerAccount customerAccount;
    private Scanner scanner;

    public AutomatedTellerMachine(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Quit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Please select an option (1/2/3/4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: $" + customerAccount.checkBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    if (customerAccount.deposit(depositAmount)) {
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount. Please enter a positive value.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (customerAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Invalid amount or insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1/2/3/4).");
            }
        }
    }
}

public class BankATM {
    public static void main(String[] args) {
        CustomerAccount userAccount = new CustomerAccount("Jane Smith", 1500.0);
        AutomatedTellerMachine atm = new AutomatedTellerMachine(userAccount);
        atm.run();
    }
}
