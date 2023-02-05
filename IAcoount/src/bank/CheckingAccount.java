package bank;

/**
 * This class represents a checking account with deposit, withdraw, and monthly maintenance function.
 * Implements the IAccount interface.
 */
public class CheckingAccount extends Account {
  private static final double minRemain = 100.00;
  private static final double maintenanceFee = 5.00;
  private static final double minStarter = 0.01;

  /**
   * Constructor for the checkingAccount class.
   *
   * @param startAmount The starting amount for account.
   */
  CheckingAccount(double startAmount) {
    super(startAmount);
  }

  /**
   * Withdraw method, subtract the specific withdraw amount to account balance.
   *
   * @param amount The amount to be reduced from account.
   * @return false if withdraw amount is less than 0 or balance is less than withdraw amount.
   * Return true if withdraw successfully.
   */
  @Override
  public boolean withdraw(double amount) {
    double minWithdraw = 0;
    if (amount < minWithdraw) {
      return false;
    }
    if (this.balance < amount) {
      return false;
    }
    this.balance -= amount;
    return true;
  }

  /**
   * Perform monthly maintenance method, updates the account balance by subtract maintenance fee,
   * if balance less than 0.01 after subtract, throw exception.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (this.balance < minRemain) {
      if (this.balance < maintenanceFee) {
        throw new IllegalArgumentException("Can not apply maintenance.");
      }
      if (this.balance > maintenanceFee) {
        this.balance -= maintenanceFee;
      }
    }
  }
}
