package org.banking.domain;

import java.text.DecimalFormat;

public class Amount {

	private DecimalFormat decimalFormat = new DecimalFormat("#.00");	
	
	private int value;

	public int getValue() {
		return value;
	}

	public Amount(int myvalue) {
		this.value = myvalue;
	}

	public static Amount amountOf(int value) {
		return new Amount(value);
	}
	
	public Amount add(Amount otherAmount) {
		return amountOf(this.value + otherAmount.value);
	}

	public Amount retrieve() {
		return amountOf(-value);
	}


}
