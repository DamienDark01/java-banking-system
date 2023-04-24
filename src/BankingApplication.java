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

  // method to output the previous transaction
  void getPreviousTransaction() {
    if (previousTransaction > 0) // condition to check if the prevois transaction is greater than 0
    {
      // output message
      System.out.println("Deposited: " + previousTransaction);
    } 
    else if (previousTransaction < 0) // condition to check if the prevois transaction is lesser than 0
    { 
      // output message
      System.out.println("Withdrawn: " + Math.abs(previousTransaction));
    } 
    else // message to display if no transaction has occured
    { 
      // output message
      System.out.println("No transaction has occurred.");
    }
  }

  // method to show the menu
  void showMenu() {
    // variables
    char option;
    
    // object for taking inputs
    Scanner scanner = new Scanner(System.in);

    // loop to keep the required code block running
    do {
      // welcome message
      System.out.println("\n");
      System.out.println("Welcome " + customerName + "!");
      System.out.println("Your Bank ID : " + customerId);
      System.out.println("\n");
      // options
      System.out.println("A. Check balance");
      System.out.println("B. Deposit");
      System.out.println("C. Withdraw");
      System.out.println("D. Previous transaction");
      System.out.println("E. Exit");
      // prompt to take input
      System.out.println("==================================================");
      System.out.println("Enter an option: ");
      System.out.println("==================================================");
      option = scanner.next().charAt(0);
      System.out.println("\n");

      // switch case structure to conditionally check the input
      switch (option) {
        // option to check balance
        case 'A':
          // output
          System.out.println("--------------------------------------------------");
          System.out.println("Balance : " + balance);
          System.out.println("--------------------------------------------------");
          System.out.println("\n");

          // break statement
          break;

        // option to enter an amount
        case 'B':
          // output
          System.out.println("--------------------------------------------------");
          System.out.println("Enter an amount to deposit : ");
          System.out.println("--------------------------------------------------");

          // create object to take inputs
          double newAmount1 = scanner.nextDouble();

          // method calling
          deposit(newAmount1);

          // necessary outputs
          System.out.println("\n");

          // break statement
          break;

        // option to withdraw an amount
        case 'C':
          // output
          System.out.println("--------------------------------------------------");
          System.out.println("Enter an amount to withdraw : ");
          System.out.println("--------------------------------------------------");

          // create object to take inputs
          double newAmount2 = scanner.nextDouble();

          // method calling
          withdraw(newAmount2);

          // necessary outputs
          System.out.println("\n");

          // break statement
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
