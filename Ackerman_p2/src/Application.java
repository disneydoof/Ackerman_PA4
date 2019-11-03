public class Application {

	public static void main(String[] args) {
		
		DuplicateCounter duplicateCounter = new DuplicateCounter(); // Instance of DuplicateCounter
		
		duplicateCounter.count("problem2.txt"); // Calling count
		duplicateCounter.write("unique_word_counts.txt"); // Calling write
		
	}

}
