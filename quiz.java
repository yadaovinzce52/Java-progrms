package Quiz;

import java.util.*;

public class quiz {

	public static void main(String[] args) {
		char[] result = new char[4];
		String personality = " ";
		
		System.out.println("Find your major based on your personality!\n");
		instructions();
		System.out.println();
		result[0] = part1();
		System.out.println();
		result[1] = part2();
		System.out.println();
		result[2] = part3();
		System.out.println();
		result[3] = part4();
		System.out.println();
		
		for(int i = 0; i < 4; i++) {
			personality += result[i];
		}

		System.out.println("Thank you for taking the test your personality type is: " + personality);
	}
	
	public static void instructions() {
		System.out.println("This quiz will be used to figure out what your personality type is.");
		System.out.println("Each question will give you two options, the first option will");
		System.out.println("correspond to choice 'a' and the second option will correspond to");
		System.out.println("choice 'b' choose which most describes you."); 
	}
	
	// asks the first set of personality questions
	public static char part1() {
		char[] answers = new char[3];
		char result = ' ';
		char choice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Part 1:");
		do {
			System.out.println("In general, are you more outgoing or focused?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[0] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("In general, do you like to talk or are you the quiet type?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[1] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("In general, are you more socially engaged or reflective?");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[2] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		if(answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'a'
				|| answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'a') {
			result = 'E';
		}
		else if(answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'b'
				|| answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'b') {
			result = 'I';
		}
		
		return result;
	}
	
	// asks the second set of personality questions
	public static char part2() {
		char[] answers = new char[3];
		char result = ' ';
		char choice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Part 2:");
		do {
			System.out.println("Are you more imaginative or sensible?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[0] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("Are you creative or practical when it comes to solving problems?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[1] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("When it comes to planning, are you visionary or realistic?");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[2] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		if(answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'a'
				|| answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'a') {
			result = 'N';
		}
		else if(answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'b'
				|| answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'b') {
			result = 'S';
		}
		
		return result;
	}
	
	public static char part3() {
		char[] answers = new char[3];
		char result = ' ';
		char choice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Part 3:");
		do {
			System.out.println("Are you more of a logical or an emotional person?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[0] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("When it comes to your friends, are you fair or supportive?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[1] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("Do you deal with situations professionally or empathetically?");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[2] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		if(answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'a'
				|| answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'a') {
			result = 'T';
		}
		else if(answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'b'
				|| answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'b') {
			result = 'F';
		}
		
		return result;
	}
	
	public static char part4() {
		char[] answers = new char[3];
		char result = ' ';
		char choice;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Part 4:");
		do {
			System.out.println("Are you an organized or a spontaneous person?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[0] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("Are you goal oriented or flexible?(a/b)");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[1] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		do {
			System.out.println("When planning, are you methodical or open-ended?");
			choice = input.next().charAt(0);
			Character.toLowerCase(choice);
			if(choice == 'a' || choice == 'b') {
				answers[2] = choice;
				break;
			}
			else if(choice != 'a' || choice != 'b') {
				System.out.println("Not a valid choice.");
			}
		}while(choice != 'a' || choice != 'b');
		
		if(answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'a'
				|| answers[0] == 'a' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'a') {
			result = 'J';
		}
		else if(answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'b'
				|| answers[0] == 'b' && answers[1] == 'b' && answers[2] == 'a'
				|| answers[0] == 'b' && answers[1] == 'a' && answers[2] == 'b'
				|| answers[0] == 'a' && answers[1] == 'b' && answers[2] == 'b') {
			result = 'P';
		}
		
		return result;
	};
	
}
