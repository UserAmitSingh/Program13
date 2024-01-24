package Program13;
import java.util.Scanner;


/**
 * Team : 3
 * Members: Michael Anderson, Sophie Byron, Paul Manning, Amit Singh
 * Date: 1/24/2024
 * Class: APCSA
 * Teacher: Mr. Meinzen
 * Description: Takes an input using scanner, and uses the Expression class
 * 	to solve a post order equation.
 */
public class ExpressionsTest {
	//Field Variables
	private static  Expression expression;
	private static  Scanner input = new Scanner(System.in);
	private static boolean isTerminated;
	
	/**
	 * Main method.
	 *  Will start a loop and test the Expression class inside,
	 */
	public static void main(String a[]) {
		//Instantiate 2 field variables
		expression = new Expression();
		isTerminated = false;
		
		System.out.println("You can type Exit to stop the loop." +'\n');
		
		//Start the loop
		while(!isTerminated) {
			push(askForInput());
			print();
		}
	}
	
	/**
	 * The askForInput() method uses the scanner to get a double or String.
	 */
	private static Object askForInput() {
		Object inputedTerm;
		
		System.out.println("Please put a number, operator (+ - / *), or command below.");
		if(input.hasNextDouble()) {inputedTerm = input.nextDouble();}
		else if(input.hasNext()) {inputedTerm = input.next();}
		else {inputedTerm = null;}
		
		return inputedTerm;
	}
	
	/**
	 * The push() method calls the pushToFront() method to 
	 * push the parameter value onto the stack of the Expression
	 * class.
	 */
	private static void push(Object value) {
		try {
			if(value.equals("Exit")) isTerminated = true;
			else
				expression.pushToFront(value);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Prints out the toString() of the stack in the expression class.
	 */
	private static void print() {
		System.out.println(expression.toString());
	}
}

