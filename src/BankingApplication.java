// imports
import java.util.Scanner;

// execution class
public class BankingApplication {
  // main method
  public static void main(String[] args) {
    // creating object to take inputs
    Scanner input = new Scanner(System.in);

    // displaying the prompt and taking inputs
    System.out.println("Welcome! Please enter your name : ");
    String name = input.next();
    System.out.println("Enter your Bank ID : ");
    String id = input.next();

    // creating the necessary BankAccount object
    BankAccount obj1 = new BankAccount(name, id);
    
    // calling the showMenu() method via the created object
    obj1.showMenu();
  }
}

// custom class
class BankAccount {
  // variables
  double balance;
  double previousTransaction;
  String customerName;
  String customerId;

  // constructor
  BankAccount(String cName, String cId) {
    customerName = cName;
    customerId = cId;
  }

  // method to deposit money
  void deposit(double amount) {
    // checks whether the amount entered is null
    if (amount != 0.0) {
      // adds the entered amount to the balance
      balance += amount;

      // updating the required variables
      previousTransaction = amount;
    }
  }

  // method to withdraw money
  void withdraw(double amount) {
    // checks whether the amount entered is null
    if (amount != 0.0) {
      // deducts the amount entered from the balance
      balance -= amount;

      // updating the required variables
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
    char option;
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("\n");
      System.out.println("Welcome " + customerName + "!");
      System.out.println("Your Bank ID : " + customerId);
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
          System.out.println("Previous Transaction : ");
          getPreviousTransaction();
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
