package org.banking.domain.test;

import static org.banking.domain.DateInit.date;
import static org.banking.domain.Amount.amountOf;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Date;

import org.banking.domain.Amount;
import org.banking.domain.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTest {

    @Test public void
    calculate_current_balance_after_deposit() {
        Transaction transaction = null;
        try {
            transaction = new Transaction(amountOf(1000), date("29/01/2021"));
            Amount currentValue = transaction.balanceAfterTransaction(amountOf(100));
            assertEquals(currentValue.getValue(), amountOf(1100).getValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test public void
    calculate_current_balance_after_withdrawal() {
        Transaction transaction = null;
        try {
            transaction = new Transaction(amountOf(-1000), date("31/01/2021"));
            Amount currentValue = transaction.balanceAfterTransaction(amountOf(100));
            assertEquals(currentValue.getValue(), amountOf(-900).getValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Test public void
    equal_to_other_transaction_with_same_value_and_date() {
        Date depositDate = null;
        try {
            depositDate = date("10/01/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Transaction depositOfOneHundred = new Transaction(amountOf(1000), depositDate);
        Transaction anotherDepositOfOneHundred = new Transaction(amountOf(1000), depositDate);
        assertEquals(depositOfOneHundred.getAmount().getValue(), anotherDepositOfOneHundred.getAmount().getValue());
    }

}