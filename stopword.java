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
* 	- Implement stopword removal using the following stopword list: http://bit.ly/1bqQWaV (Links to an external site.)
*
*	- Use the Porter Stemmer package: http://tartarus.org/~martin/PorterStemmer/  (Links to an external site.)
*
**/

import java.io.*;
import java.util.*;
//import Stemmer.class;

public class stopword{

	public static void main(String[] argv) throws Exception {
	
	/**
	* Run the tokenizer first, then the stopword removal, and finally the stemmer on the text provided in
	* the input file assignment3-input.txtPreview the documentView in a new window.
	**/
	
	
		//create the output file
		FileWriter file = new FileWriter("output2.txt");			
		BufferedWriter buffer = new BufferedWriter(file);
		PrintWriter print = new PrintWriter (buffer);
		
	
		//declare new input file & create Scanner to read that input file
		Scanner scanFile = new Scanner(new File("output.txt"));
		Scanner scanStopwordFile = new Scanner(new File("stopwords.txt"));
	
		scanFile.useDelimiter("\n");
		scanStopwordFile.useDelimiter("\n");
	
		Scanner lineTokenizer; 
		String line, word, stopWord;
	
		ArrayList<String> stopWords = new ArrayList<String>();		//list of STOPwords from the text file
		//fill list
	
		while (scanStopwordFile.hasNext()){
			stopWord = scanStopwordFile.next();
			stopWords.add(stopWord);
		}
	
	
			while (scanFile.hasNextLine() == true){

				line = scanFile.nextLine();
				lineTokenizer = new Scanner(line);
			
				while (lineTokenizer.hasNext()){
					word = lineTokenizer.next();
	
				
				
					/*
					* Stopword removal
					*/	
						if (stopWords.contains(word))
							print.print("");						
						else
							print.print(word + " ");

				
				
				}
				
				print.println("");
			
			}
			print.close();	// Close file writing


		/*
		* Call the Stemmer
		*/
		
		//read the input file
		Scanner scanFile2 = new Scanner(new File("output2.txt"));
		
		System.out.println("");
		System.out.println("Stopwords have been removed and output2.txt has been created");
		System.out.println("");

		//call the PorterStemmer
		System.out.println("To use the Porter Stemmer compile and run PorterStemmer.java");
        System.out.println("");
        
        System.out.println("to compile: \t javac PorterStemmer.java");
		System.out.println("to run: \t java Stemmer output2.txt");

		
	}
}