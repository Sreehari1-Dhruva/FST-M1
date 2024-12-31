package activities;

public class Bankaccount {
	private Integer balance;

	// create a constructor
	public Bankaccount(Integer initialBalance) {
		balance = initialBalance;
	}

	// add method to calculate
	// balance amount after withdrawal
	public Integer withdraw(Integer amount) {
		if (balance < amount) {
			throw new NotEnoughFundsException(amount, balance);
		}
		balance -= amount;
		return balance;
	}

}
