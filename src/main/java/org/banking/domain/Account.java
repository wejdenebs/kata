package org.banking.domain;

import java.util.Date;
import static org.banking.domain.Amount.amountOf;

public class Account {

	private Operation operation;
	private Amount balance = amountOf(0);

	public Amount getBalance() {
		return balance;
	}

	public Account(Operation newoperation) {
		this.operation = newoperation;
	}

	private void recordTransaction(Amount value, Date date) {
		Transaction transaction = new Transaction(value, date);
		Amount balanceAfterTransaction = transaction.balanceAfterTransaction(balance);
		balance = balanceAfterTransaction;
		operation.addLineContaining(transaction, balanceAfterTransaction);
	}

	public void deposit(Amount value, Date date) {
		recordTransaction(value, date);
	}

	public void withdrawal(Amount value, Date date) {
		recordTransaction(value.retrieve(), date);
	}



	
}
