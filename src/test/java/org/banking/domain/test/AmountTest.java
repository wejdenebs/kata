package org.banking.domain.test;

import static org.banking.domain.Amount.amountOf;
import static org.junit.Assert.*;

import org.banking.domain.Amount;
import org.junit.Test;

public class AmountTest {
	
	@Test public void
	equal_to_another_instance_containing_same_amount() {
		Amount oneHundred = new Amount(100);
		Amount anotherOneHundred = new Amount(100);
		
		assertEquals(oneHundred.getValue(), anotherOneHundred.getValue());
	}

	@Test public void
	different_from_another_instance_containing_different_amount() {
		Amount ten = new Amount(10);
		Amount five = new Amount(5);
		
		assertNotSame(ten.getValue(), five.getValue());
	}
	
	@Test public void
	statically_initialise_an_amount() {
		assertEquals(new Amount(10).getValue(), amountOf(10).getValue());
	}
	
	@Test public void
	sum_up_amounts() {
		Amount ten = amountOf(10);
		Amount five = amountOf(5);
		Amount fifteen = amountOf(15);
		
		assertEquals(fifteen.getValue(), ten.add(five).getValue());
	}

	@Test public void
	return_the_negative_value() {
		Amount five = amountOf(5);

		assertEquals(amountOf(-5).getValue(), five.retrieve().getValue());
	}


	
}
