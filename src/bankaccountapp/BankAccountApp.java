package bankaccountapp;

import java.util.LinkedList;
import java.util.List;
import utilites.CSV;

public class BankAccountApp {

  public static void main(String[] args) {
    List<Account> accounts = new LinkedList<Account>();
    String file = System.getProperty("user.dir") + "/NewBankAccounts.csv";
    List<String[]> newAccountHolders = CSV.read(file);

    for (String[] newAccountHolder : newAccountHolders) {
      String name = newAccountHolder[0];
      String sSn = newAccountHolder[1];
      String accountType = newAccountHolder[2];
      double initialDeposit = Double.parseDouble(newAccountHolder[3]);
      if (accountType.equals("Savings")) {
        System.out.println("Opening a savings account");
        accounts.add(new Savings(name, sSn, initialDeposit));
      } else if (accountType.equals("Checking")) {
        System.out.println("Opening a checking account");
        accounts.add(new Checking(name, sSn, initialDeposit));
      } else {
        System.out.println("ERROR READING ACCOUNT TYPE");
      }
    }

    for (Account account : accounts) {
      System.out.println(
          "============================ " + account.accountNumber + " ================");
      account.showInfo();
    }
  }
}
