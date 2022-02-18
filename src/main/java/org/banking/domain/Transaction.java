package org.banking.domain;

import java.util.Date;

public class Transaction {

	private Amount amount;
	private Date date;

	public Amount getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public Transaction(Amount value, Date date) {
		this.amount = value;
		this.date = date;
	}

	public Amount balanceAfterTransaction(Amount currentBalance) {
		return currentBalance.add(amount);
	}

}
