package HW2;


/**
 * Some tests for the IntegerSet and the Fraction classes in HW 2.
 * 
 */

public class HW2Tester {

	public static void testIntegerSet() {
		System.out.println("IntegerSet tests:\n");
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.insertElement(0);
		set1.insertElement(2);
		set1.insertElement(8);
		System.out.println("After set1.insertElement(10), set1 = " + set1.insertElement(10));
		set1.insertElement(4);
		set1.insertElement(6);
		set1.insertElement(10);
		set1.insertElement(100);
		set1.insertElement(12);
		set1.insertElement(95);

		set2.insertElement(0);
		set2.insertElement(3);
		set2.insertElement(6);
		set2.insertElement(9);
		set2.insertElement(12);

		System.out.println("default IntegerSet is = " + (new IntegerSet()));
		System.out.println("set1 = " + set1);
		System.out.println("set2 = " + set2);
		//construct a new set set3 that copies from an existing set, set1
		IntegerSet set3 = new IntegerSet(set1);
		System.out.println("set3 = " + set3);
		
		System.out.println("set1.isSet(8) = " + set1.isSet(8) + ", set1.isSet(11) = " + set1.isSet(11));
		System.out.println("set1.union(set2) = " + set1.union(set2));
		System.out.println("set1.intersection(set2) = " + set1.intersection(set2));
		System.out.println("set1.deleteElement(2) = " + set1.deleteElement(2));
		System.out.println("set1.isEmpty() = " + set1.isEmpty());
		System.out.println("set1.cardinality() = " + set1.cardinality());
		System.out.println("set1.isEqualTo(set1) = " + set1.isEqualTo(set1));
		System.out.println("set1.isEqualTo(set2) = " + set1.isEqualTo(set2));
	}
	
	public static void testFraction() {
		System.out.println("\n\nFraction tests:\n");
		Fraction f1 = new Fraction(4, 6);
		Fraction f2 = new Fraction(75, 175);
		Fraction f3 = new Fraction(-6, 17);

		System.out.println(f1 + " simplified = " + f1.simplify());
		System.out.println(f2 + " simplified = " + f2.simplify());
		System.out.println(f3 + " simplified = " + f3.simplify());

		// show that f1, f2, f3 haven't changed
		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
		System.out.println("f3 = " + f3);

		// arithmetic
		System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
		System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
		System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
		System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));
		System.out.println();

		System.out.println(f2 + " + " + f3 + " = " + f2.add(f3));
		System.out.println(f2 + " - " + f3 + " = " + f2.subtract(f3));
		System.out.println(f2 + " * " + f3 + " = " + f2.multiply(f3));
		System.out.println(f2 + " / " + f3 + " = " + f2.divide(f3));
		System.out.println();

		// test 'division by zero' handling
		Fraction zero = new Fraction();
		System.out.println(f2 + " / " + zero + " = " + f2.divide(zero));
	}
	
	public static void main(String[] args) {
		testIntegerSet();
		testFraction();
	}

}
