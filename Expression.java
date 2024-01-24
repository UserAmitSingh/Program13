package Program13;

import Program12.*;

/**
 * Team : 3
 * Members: Michael Anderson, Sophie Byron, Paul Manning, Amit Singh
 * Date: 1/24/2024
 * Class: APCSA
 * Teacher: Mr. Meinzen
 * Description: Creates an Expression class which gives the 
 * 	result of a post order equation.
 */
public class Expression {
	//Field Variables
	private StackList stack;
	private static String[]  operations = {"+", "-", "/", "*"};
	private int numInStack;
	
	/**
	 * The Expression() constructor method instantiates the 
	 * stack and numberInStack field variables
	 */
	public Expression() {
		stack = new StackList();
		numInStack = 0;
	}
	
	/**
	 * The pushToFront() method  
	 * Adds the parameter value to the list if it is a double.
	 * Operates on the top 2 doubles in the stack if the parameter
	 * 	value is an operator.
	 * 
	 * @param value
	 * @throws Exception
	 */
	public void pushToFront(Object value) throws Exception {
		if(numInStack>=2) {
			for(int i=0; i<operations.length; i++) {
				if(value.equals(operations[i])) {
					operate(i); 
					return;
				}
			}
		}
		
		//Operator did not match (lines 42-47) and the parameter value is not a double
		//Or not enough number
		if(!(value instanceof Double)) 
			throw new Exception("Please make sure you are using numbers or operators, and"
					+ " that you have enough numbers to operate.");

		numInStack++;
		stack.push(value);
	}
	
	/**
	 * Completes an operation on the top 2 doubles of the stack.
	 * @param operation
	 */
	private void operate(int operation) {
		double term1 = (double) stack.pop();
		double term2 = (double) stack.pop();
		
		double term3;
		switch(operation) {
		  case 0:
			 term3 = term2 + term1;
			 stack.push(term3);
			 break;
		  case 1:
			 term3 = term2 - term1;
			 stack.push(term3);
			 break;
		  case 2:
			 term3 = term2 / term1;
			 stack.push(term3); 
			 break;
		  case 3:
			 term3 = term2 * term1;
			 stack.push(term3);
			 break;
		}
		
		numInStack--;
	}
	
	/**
	 * Calls the toString() method of the stack and gives the String
	 * taken from the toString() method of the stack.
	 */
	public String toString() {
		return stack.toString();
	}
}
