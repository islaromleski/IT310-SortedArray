package sa;

public class ADT {
	private int[] array = new int[10];
	private int upperBound = -1;
	private int lowerBound = 0;
	
	void insertData(int number) {
		
		if(this.getUpperBound() == this.array.length-1) {
			return;
		}
		
		int index = binarySearchInsert(number);
		
		if (index == -1) {
			this.setUpperBound(0);
			this.array[0] = number;
		}
		else if (index == this.getUpperBound()+1) {
			this.setUpperBound(this.getUpperBound()+1);
			this.array[this.getUpperBound()] = number;
		}
		else {
			for(int j = this.getUpperBound(); j >= index; j--) {
				this.array[j+1] = this.array[j];
			}
			this.setUpperBound(this.getUpperBound()+1);
			this.array[index] = number;
		}
	}
	
	int binarySearchInsert(int number) {
		if (this.getUpperBound() == -1) {
			return -1;
		}
		
		int upper = this.getUpperBound();
		int lower = this.getLowerBound();
		
		if (upper == 0 && lower == 0) {
			if(number > this.array[0]) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		int index = this.binarySearchInsert(number, upper, lower);
		return index;
	}
	
	int binarySearchInsert(int number, int upper, int lower) {
		int index = (upper + lower)/2;
		
		if (upper < this.getLowerBound() || upper < lower) {
			return this.getUpperBound()+1;
		}
		else if(lower > this.getUpperBound() || lower > upper) {
			return this.getLowerBound();
		}
		else if(this.array[index] == number) {
			return index;
		}
		else if(index != 0 && this.array[index-1] <= number && number < this.array[index]) {
			return index;
		}
		else if(index != this.array.length-1 && this.array[index] < number && number <= this.array[index+1]) {
			return index+1;
		}
		else if(number < this.array[index]) {
			upper = index-1;
			return this.binarySearchInsert(number, upper, lower);
		}
		else if(number > this.array[index]) {
			lower = index+1;
			return this.binarySearchInsert(number, upper, lower);
		}
		
		return -1;
	}
	
	void setUpperBound(int newUpperBound) {
		this.upperBound = newUpperBound;
	}
	
	int getUpperBound() {
		return this.upperBound;
	}
	
	void setLowerBound(int newLowerBound) {
		this.lowerBound = newLowerBound;
	}
	
	int getLowerBound() {
		return this.lowerBound;
	}
	
	String outputMinMax() {
		String aMessage = "";
		int lower = this.getLowerBound();
		int upper = this.getUpperBound();
		
		while(lower <= upper) {
			aMessage += this.array[lower] + "\n";
			lower++;
		}
		
		return aMessage;
	}
	
	String outputMaxMin() {
		String aMessage = "";
		int lower = this.getLowerBound();
		int upper = this.getUpperBound();
		
		while(lower <= upper) {
			aMessage += this.array[upper] + "\n";
			upper--;
		}
		
		return aMessage;
	}
	
	int findIndex(int number) {
		if(this.getUpperBound() == -1) {
			return -1;
		}
		else {
			int index = binarySearchIndex(number);
			return index;
		}
	}
	
	int binarySearchIndex(int number) {
		int upper = this.getUpperBound();
		int lower = this.getLowerBound();
		int index = this.binarySearchIndex(number, upper, lower);
		
		return index;
	}
	
	int binarySearchIndex(int number, int upper, int lower) {
		int index = (upper + lower)/2;
		
		if (upper < this.getLowerBound() || lower > this.getUpperBound() || upper < lower) {
			return -1;
		}
		else if(this.array[index] == number) {
			return index;
		}
		else if(this.array[index] < number){
			lower = index+1;
			return this.binarySearchIndex(number, upper, lower);
		}
		else {
			upper = index-1;
			return this.binarySearchIndex(number, upper, lower);
		}
	}
	
	void deleteByIndex(int index) {
		int upper = this.getUpperBound();
		
		for (int i = index; i < upper; i++) {
			this.array[i] = this.array[i+1];
		}
		
		this.array[upper] = 0;
		this.setUpperBound(this.getUpperBound()-1);
	}

	void deleteByNumber(int number) {
		int index = this.binarySearchIndex(number);
		
		if(index != -1) {
			this.deleteByIndex(index);
		}
	}
}