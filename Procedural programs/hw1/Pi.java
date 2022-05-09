package hw1;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Exercise 5.20: 'Approximating PI'");
		System.out.print("Compute to how many terms of the series? ");
		
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		System.out.println("terms PI approximation");
		System.out.println("1\t4.0");
		
		double div = 3.0; 
		double pi = 4.0;
		double temp = 4.0;
		
		for(int i = 2; i < num + 1; i++) {
			if(i % 2 == 0) {
				temp = 4/div;
				pi -= temp;
				div += 2;
				System.out.println(i + "\t" + pi);
			}
			else {
				temp = 4/div;
				pi += temp;
				div += 2;
				System.out.println(i + "\t" + pi);
			}
		}
		
		input.close();
	}

}
