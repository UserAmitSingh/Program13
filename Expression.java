package Program13;

import Program12.*;

/**
 * Team : 1
 * Members: 
 * Date: 1/23/2024
 * Class: APCSA
 * Teacher: Mr. Meinzen
 * Description: Cre
 */
public class Expression {
	//Field Variables
	private StackList stack;
	private String[]  operations = {"+", "-", "/", "*", "^"};
	private int 	  numberInStack;
	
	/**
	 * The Expression() constructor method instantiates the 
	 * stack and numberInStack field variables
	 */
	public Expression() {
		stack = new StackList();
		numberInStack = 0;
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
		//Not enough numbers to operate
		if(numberInStack<2) throw new Exception("Please make sure you have at least "
				+ "2 numbers in the List.");
		else {
			for(int i=0; i<operations.length; i++) {
				if(value.equals(operations[i])) {
					operate(i); 
					return;
				}
			}
		}
		
		//Operator did not match (lines 42-47) and the parameter value is not a double
		if(!(value instanceof Double)) 
			throw new Exception("Please make sure you are using numbers or operators");
		
		//Successfully add 1 to the list
		numberInStack++;
		stack.push(value);
	}
	
	/**
	 * Completes an operation on the top 2 doubles of the stack.
	 * @param operation
	 */
	private void operate(int operation) {
		//Take out 2 from the stack
		double term1 = (double) stack.pop();
		double term2 = (double) stack.pop();
		
		double term3;
		if(operation==0) {
			term3 = term2 + term1;
			stack.push(term3);
		}
		else if(operation==1) {
			term3 = term2 - term1;
			stack.push(term3);
		}
		else if(operation==2) {
			term3 = term2 / term1;
			stack.push(term3);
		}
		else if(operation==3) {
			term3 = term2 * term1;
			stack.push(term3);
		}
		else if(operation==4) {
			term3 = Math.pow(term2, term1);
			stack.push(term3);
		}
		
		//Took out 2 and added 1
		numberInStack--;
	}
	
	/**
	 * Calls the toString() method of the stack and gives the String
	 * taken from the toString() method of the stack.
	 */
	public String toString() {
		return stack.toString();
	}
}
