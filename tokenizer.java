/** 
* Assignment 3 (Text Processing)
*
* @ author: Erica Krause
* @ class: CSC 320 - Information Retrieval
* @ professor: Dr. Cooper
* @ last edit: October 3, 2014
*
* This program implements a text processor using the following specs:
*
*	- Tokenize all abbreviations containing periods as strings without periods
*
*	- Treat the rest of the punctuation as word separators
*
*	- Lowercase all letters
*
* to compile:   javac tokenizer.java
* to run:       java tokenizer
*
**/

import java.io.*;
import java.util.*;

public class tokenizer{

	public static void main(String[] argv) throws Exception {
	
	/**
	* Run the tokenizer first, then the stopword removal, and finally the stemmer on the text provided in
	* the input file assignment3-input.txtPreview the documentView in a new window.
	**/

		//create the output file
		FileWriter file = new FileWriter("output.txt");			
		BufferedWriter buffer = new BufferedWriter(file);
		PrintWriter print = new PrintWriter (buffer);
	
		//declare new input file & create Scanner to read that input file
		Scanner scanFile = new Scanner(new File("assignment3-input.txt"));
		scanFile.useDelimiter("");	

		Scanner lineTokenizer; 
		String character;
	
		while (scanFile.hasNextLine() == true){

			character = scanFile.next();
			
			if (character.equals("."))
				character.replaceAll("(?<=(^|[.])[\\S&&\\D])[.](?=[\\S&&\\D]([.]|$))", "").replace(".", " ");

			if (character.equals(",") || character.equals("'") || character.equals("/") || character.equals("(") || character.equals(")") ||character.equals("\"") || character.equals(":") || character.equals("-") || character.equals("_")|| character.equals("."))
				character.replace(character, " ");
							
			else
				print.print(character.toLowerCase()); //lowercase the letter when printing
				
		}
		
		print.close();	// Close file writing
        
        System.out.println("");
        System.out.println("The tokenizer has ran.");
        System.out.println("");
        System.out.println("Next, remove stopwords by compiling and running stopword.java");
        System.out.println("");
        System.out.println("to compile: \t javac stopword.java");
        System.out.println("to run: \t java stopword");


	}
	
}
