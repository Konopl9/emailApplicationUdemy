package bankaccountapp;

public class Checking extends Account {
  // List properties specific to this accounts
  int debitCardNumber;
  int debitCardPIN;

  // Constructor to initialize checking account properties
  public Checking(String name, String sSn, double initialDeposit) {
    super(name, sSn, initialDeposit);
    accountNumber = "2" + accountNumber;
    this.debitCardNumber = createdDebitCardNumber();
    this.debitCardPIN = createdDebitCardPIN();
  }

  @Override
  public void setRate() {
    rate = getBaseRate() * .15;
  }

  // List any methods specific to checking account
  private int createdDebitCardNumber() {
    return (int) (Math.random() * Math.pow(10, 12));
  }

  private int createdDebitCardPIN() {
    return (int) (Math.random() * Math.pow(10, 4));
  }

  public void showInfo() {
    super.showInfo();
    System.out.println(
        "Your checking account features"
            + "\nDebit card number "
            + debitCardNumber
            + "\nDebit card PIN "
            + debitCardPIN);
  }
}
