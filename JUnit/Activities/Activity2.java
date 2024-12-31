package activities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Activity2 {

	@Test
	void notEnoughFunds() {
		// create an object for bankaccount class
		Bankaccount account = new Bankaccount(20);
		// assertion for exception
		assertThrows(NotEnoughFundsException.class, () -> account.withdraw(30),
				"Balance must be less then amount of withdrawal");
	}

	@Test
	void enoughFunds() {
		// create an object for bankaccount class
		Bankaccount account = new Bankaccount(100);
		// expected balance
		int expectedbalance = 0;
		//// assertion for no exception
		assertDoesNotThrow(() -> account.withdraw(10));
		assertEquals(expectedbalance, account.withdraw(90));
	}

}
