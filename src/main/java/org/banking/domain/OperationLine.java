package org.banking.domain;


public class OperationLine {

	private Transaction transaction;
	private Amount currentBalance;

	public OperationLine(Transaction transaction, Amount currentBalance) {
		this.transaction = transaction;
		this.currentBalance = currentBalance;
	}

}
