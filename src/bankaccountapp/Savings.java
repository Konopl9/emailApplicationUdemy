package bankaccountapp;

public class Savings extends Account {
  // List properties specific to this accounts
  int safetyDepositBoxID;
  int safetyDepositBoxKey;

  // Constructor to initialize savings account properties
  public Savings(String name, String sSn, double initialDeposit) {
    super(name, sSn, initialDeposit);
    accountNumber = "1" + accountNumber;
    this.safetyDepositBoxID = createSafetyDepositBoxID();
    this.safetyDepositBoxKey = crateSafetyDepositBoxKey();
  }

  @Override
  public void setRate() {
    rate = getBaseRate() - .25;
  }

  // List any methods specific to savings account
  private int createSafetyDepositBoxID() {
    return (int) (Math.random() * Math.pow(10, 3));
  }

  private int crateSafetyDepositBoxKey() {
    return (int) (Math.random() * Math.pow(10, 4));
  }

  public void showInfo() {
    super.showInfo();
    System.out.println(
        "Your savings account features"
            + "\nSafety deposit box id "
            + safetyDepositBoxID
            + "\nSafety deposit box key "
            + safetyDepositBoxKey);
  }
}
