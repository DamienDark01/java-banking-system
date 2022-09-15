import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount("Kylo", "C20220101");
        obj1.showMenu();
    }

}

class BankAccount {

    double balance;
    double previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    void deposit(double amount) {
        if (amount != 0.0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount) {
        if (amount != 0.0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction has occurred.");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Welcome " + customerName);
            System.out.println("Your ID : " + customerId);
            System.out.println("\n");
            System.out.println("A. Check balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous transaction");
            System.out.println("E. Exit");
            System.out.println("==================================================");
            System.out.println("Enter an option: ");
            System.out.println("==================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Balance : " + balance);
                    System.out.println("--------------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Enter an amount to deposit : ");
                    System.out.println("--------------------------------------------------");
                    double newAmount1 = scanner.nextDouble();
                    deposit(newAmount1);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Enter an amount to withdraw : ");
                    System.out.println("--------------------------------------------------");
                    double newAmount2 = scanner.nextDouble();
                    withdraw(newAmount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Previous Transaction : " + previousTransaction);
                    System.out.println("--------------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("**************************************************");
                    System.out.println("------------ Program Terminated . . . ------------");
                    break;

                default:
                    System.out.println("Invalid input. Please try again!");
                    break;
            }
        } while (option != 'E');

        System.out.println("Thank you for using out services!");
        System.out.println("Have a nice day!");
    }

}
