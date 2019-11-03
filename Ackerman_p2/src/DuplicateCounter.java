import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.io.PrintWriter;
import java.util.Scanner;


public class DuplicateCounter {
	private Map<String, Integer> wordCounter; // Initial map creation
	
	public DuplicateCounter() {
		wordCounter = new HashMap<String, Integer>(); // Instance variable declaration
	}
	
	public void count(String dataFile)
    {
        Scanner inputFile = null; // Setting initially to null
        try
        {
            inputFile = new Scanner(new File(dataFile)); // Scanner pointing to dataFile
        } catch (FileNotFoundException e) // Really only if file is not found
        {
            System.out.println(e.getMessage());
            return;
        }
       
        while (inputFile.hasNext()) // While there is a word
        {
            String word = inputFile.next().toLowerCase(); // Word is equal to the lowercase version
            Integer count = wordCounter.get(word); // 
            if (count == null)
            {
                count = 1; // Count is set to 1 if null
            }
            else {
                count += 1; // Count adds one if not null
            }
            wordCounter.put(word, count);
        }
        inputFile.close(); // Closing inputFile
    }

	public void write(String outputFile){
        try{
            PrintWriter pw = new PrintWriter(new File(outputFile)); // PrintWriter pointing to outputFile
            for (String i : wordCounter.keySet())
            {
                pw.println(i + " " + wordCounter.get(i)); // Prints string and how many times it was counted
            }
            pw.close();
        } catch (FileNotFoundException e) //Happens when an exceptional IO event occurs
        {
            System.out.println(e.getMessage());
        }
    }
}
