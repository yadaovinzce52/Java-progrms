package hw1;

import java.util.Scanner;

public class DiceStats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many dice will constitute one roll? ");
		int dice = input.nextInt();
		System.out.print("How many rolls? ");
		int rolls = input.nextInt();
		int[] list = new int[rolls];
		for(int i = 0; i < rolls; i++) {
			int total = 0;
			for(int j = 1; j <= dice; j++) {
				int die = (int)(Math.random() * 6) + 1;
				total += die;
			}
			list[i] = total;
		}
		
		System.out.println("\nSum\t# of times\tPercentage\n");
		
		for(int i = dice; i <= (dice*6); i++) {
			int count = 0;
			float result = 0;
			for(int j = 0; j < list.length; j++) {
				if(list[j] == i) {
					count++;
					result = count/((float)rolls);
					result *= 100;
				}
			}
			
			System.out.print(i + "\t" + count);
			System.out.printf("\t\t%.2f", result);
			System.out.println("%");
		}

		
		input.close();
	}

}
