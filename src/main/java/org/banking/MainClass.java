package org.banking;

import static org.banking.domain.DateInit.date;
import static org.banking.domain.Amount.amountOf;

import dnl.utils.text.table.TextTable;
import org.banking.domain.Account;
import org.banking.domain.Operation;
import java.text.ParseException;

public class MainClass {
	
	public static void main(String[] args) throws ParseException {
		Account account = new Account(new Operation());
		account.deposit(amountOf(1000), date("18-01-2021"));
		int balanceOne = account.getBalance().getValue();
		account.deposit(amountOf(2000), date("01-02-2021"));
		int balanceTwo = account.getBalance().getValue();
		account.withdrawal(amountOf(500), date("01-02-2021"));
		int balanceThree = account.getBalance().getValue();

		String[] columnNames = {
				"Date",
				"Credit",
				"Debit",
				"Balance"
				};

		Object[][] data = {
				{"18-01-2021",1000,null,balanceOne},
				{"01-02-2021",2000,null,balanceTwo},
				{"18-02-2021",null,500,balanceThree}

		};

		TextTable tt = new TextTable(columnNames, data);
		tt.setAddRowNumbering(true);
		tt.printTable();

	}

}
