package hw1;

import java.util.Scanner;

public class Reverse {
	
	public static void reverseDigits(long num) {
		long reversed = 0;
		while(num != 0) {
			long digit = num % 10;
			reversed = reversed * 10 + digit;
			num /= 10;
		}
		if(reversed != 0) {
			System.out.println("\nThe number reversed is: " + reversed + "\n");
		}
		else {
			System.out.println("\nGoodbye!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		long num;
		do {
			System.out.print("Please enter a long integer (0 to quit): ");
			while(!input.hasNextLong()) {
				System.out.print("\nThe input is not a long integer, please enter a long integer (0 to quit): ");
				input.next();
			}
			num = input.nextLong();
			reverseDigits(num);
		}while(num != 0); 
		
		input.close();
	}
}
