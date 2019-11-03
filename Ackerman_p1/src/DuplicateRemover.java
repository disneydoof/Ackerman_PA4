import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashSet; 
import java.io.File;
import java.util.Set;
import java.io.PrintWriter;


public class DuplicateRemover {
	
	private Set<String> uniqueWords; // Setting Set up
	
	public DuplicateRemover()
    {
        uniqueWords = new HashSet<>(); // Instance variable declaration
    }
	
	public void remove(String dataFile) 
    {
        try {
            Scanner scnr = new Scanner(new File(dataFile)); // Scanner pointing to dataFile
            while (scnr.hasNext()) // While there is a word
            {
                uniqueWords.add(scnr.next());  // Add word to the hashset
            }
            scnr.close(); // Close scanner
        } catch (FileNotFoundException e) // Really only if file is not found
        {
            System.out.println(e); 
        }
    }
	
	public void Write(String outputFile)
    {
        try {
            PrintWriter pw = new PrintWriter(new File(outputFile)); // PrintWriter pointing to outputFile

            for (String string : uniqueWords) // For every line in uniqueWords
            {
                pw.println(string); // Prints word
            }
            pw.flush(); // Flushes PrintWriter
            pw.close(); // Closes PrintWriter
        } catch (FileNotFoundException e) // Happens when an exceptional IO event occurs
        {
            System.out.println(e);
        }
    }
}