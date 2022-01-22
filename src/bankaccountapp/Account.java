package bankaccountapp;

public abstract class Account implements IBaseRate {

  // List common properties for saving and checking accounts
  private String name;
  private String sSn;
  protected String accountNumber;
  private double balance;
  protected double rate;
  private static int index = 10000;

  // Constructor to set base properties and initialize the account
  public Account(String name, String sSn, double initialDeposit) {
    this.name = name;
    this.sSn = sSn;
    this.balance = initialDeposit;

    index++;
    this.accountNumber = generateAccountNumber();

    setRate();
  }

  // List common methods
  public void deposit(double amount) {
    System.out.println("Depositing the amount $" + amount);
    balance = balance + amount;
  }

  public void withdraw(double amount) {
    System.out.println("Withdrawing the amount $" + amount);
    balance = balance - amount;
  }

  public void transfer(String toWhere, double amount) {
    balance = balance - amount;
    System.out.println("Transferring $" + amount + " to " + toWhere);
  }

  public void printBalance() {
    System.out.println("Your balance now is $" + balance);
  }

  public abstract void setRate();

  private String generateAccountNumber() {
    String lastTwoOfSSN = sSn.substring(sSn.length() - 2);
    int uniqueID = index;
    int randomNumber = (int) (Math.random() * Math.pow(10, 3));

    return lastTwoOfSSN + uniqueID + randomNumber;
  }

  public void compound() {
    double accruedInterest = balance * (rate / 100);
    System.out.println("Accrued interest: $" + accruedInterest);
    printBalance();
  }

  public void showInfo() {
    System.out.println(
        "Name: "
            + name
            + "\nACCOUNT NUMBER: "
            + accountNumber
            + "\nBALANCE: "
            + balance
            + "\nRate: "
            + rate
            + "%");
  }
}
