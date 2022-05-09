package HW2;

public class IntegerSet {
	
	private boolean [] arr;
	
	public IntegerSet() {
		arr = new boolean[101];
	}
	
	public IntegerSet(IntegerSet oSet) {
		arr = new boolean[101];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = oSet.arr[i];
		}
	}
	
	public boolean isSet(int data) {
		return (arr[data] == true);
	}
	
	public IntegerSet insertElement(int data) {
		if((data >= 0) && (data < arr.length)) {
			arr[data] = true;
		}
		return this;
	}
	
	public IntegerSet deleteElement(int data) {
		if((data >= 0) && (data < arr.length)) {
			arr[data] = false;
		}
		return this;
	}
	
	public IntegerSet union(IntegerSet oSet) {
		IntegerSet newSet = new IntegerSet(this);
		
		for(int i = 0; i < arr.length; i++) {
			if(oSet.isSet(i)) {
				newSet.insertElement(i);
			}
		}
		return newSet;
	}
	
	public IntegerSet intersection(IntegerSet oSet) {
		IntegerSet newSet = new IntegerSet(this);
		
		for(int i = 0; i < arr.length; i++) {
			if(!oSet.isSet(i)) {
				newSet.deleteElement(i);
			}
		}
		return newSet;
	}
	
	public boolean isEqualTo(IntegerSet oSet) {
		for(int i = 0; i < arr.length; i++) {
			if(oSet.isSet(i) != isSet(i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isEmpty() {
		for(int i = 0; i < arr.length; i++) {
			if(isSet(i)) {
				return false;
			}
		}
		return true;
	}
	
	public int cardinality() {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(isSet(i)) {
				count++;
			}
		}
		return count;
	}

	public String toString() {
		boolean isEmpty = true;
		StringBuilder string = new StringBuilder();
		string.append("{");
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]) {
				isEmpty = false;
				string.append(i).append(' ');
			}
		}
		return isEmpty?"---":string.append("}").toString();
	}
}