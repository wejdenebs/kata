package org.banking.domain;

import java.util.LinkedList;
import java.util.List;

public class Operation {

	private List<OperationLine> operationLines = new LinkedList<OperationLine>();
	
	public void addLineContaining(Transaction transaction, Amount currentBalance) {
		operationLines.add( new OperationLine(transaction, currentBalance));
	}

}
