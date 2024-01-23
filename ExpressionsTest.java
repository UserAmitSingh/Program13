package Program13;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Program12.*;

public class ExpressionsTest {
	private static  Expression expression;
	private static  Scanner input = new Scanner(System.in);
	private static boolean isTerminated;
	
	public static void main(String a[]) throws InterruptedException {
		expression = new Expression();
		isTerminated = false;
		
		System.out.println("Hello User");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Before you are asked for any inputs, ");
		TimeUnit.SECONDS.sleep(2);
		System.out.println("Here are some commands: ");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Clear - Clear all messages in the console ");
		System.out.println("Exit - Stop the program");
		
		TimeUnit.SECONDS.sleep(1);
		
		while(!isTerminated) {
			push(askForInput());
			print();
		}
	}
	
	private static Object askForInput() {
		Object inputedTerm;
		
		System.out.println("Please put a number, operator (+ - / *), or command below.");
		if(input.hasNextDouble()) {inputedTerm = input.nextDouble();}
		else if(input.hasNext()) {inputedTerm = input.next();}
		else {inputedTerm = null;}
		
		return inputedTerm;
	}
	
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
	
	private static void print() {
		System.out.println(expression.toString());
	}
}

