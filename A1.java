import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * COMP 2503 Fall 2023 Assignment 1
 * 
 * This program reads a input stream and keeps track of the statistics for
 * avengers mentioned by name, alias, or performer's last name.
 *
 * @author Maryam Elahi
 * @date Fall 2023
 */

public class A1 {

	public String[][] avengerRoster = { { "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan" } };

	private int topN = 4;
	File file = new File("input1.txt");
	private Scanner input = new Scanner(System.in);
	private int totalwordcount = 0;
	private ArrayList<Avenger> avengersArrayList = new ArrayList<>();
	private Map<String, Avenger> avengerMap = new HashMap<>();
	private String foundWord;

	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.run();
	}

	public void run() {
		readInput();
		printResults();
	}

	/**
	 * Read the input stream and keep track of how many times avengers are mentioned
	 * by alias or last name or performer's last name.
	 */
	private void readInput() {
		 Scanner input;
		try {
			input = new Scanner(file);
			
			while (input.hasNext()) {
			String word = input.next();
			// Step 1: Remove leading and trailing spaces, convert to lowercase
			word = word.trim().toLowerCase();

			// Step 2: Handle apostrophes
			if (word.contains("'")) {
				word = word.split("'")[0];
			}
			// Step 3: Remove punctuation and digits
			word = word.replaceAll("[^a-z]", "");

			// Step 4: Check if the word is not empty
			if (!word.isEmpty()) {
				totalwordcount++;

				// Step 5: Check if it's an avenger
				for (String[] avengerInfo : avengerRoster) {
					for (String avengerName : avengerInfo) {
						if (word.equals(avengerName)) {
							foundWord = word;
							updateAvengerCounts(avengerInfo);
							break;
						}
					}
				}
			}
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	/**
	 * Update the counts for the avenger found in the input.
	 *
	 * @param avengerInfo The information about the avenger.
	 */
	private void updateAvengerCounts(String[] avengerInfo) {
		String alias = avengerInfo[0];
		String lastName = avengerInfo[1];
		String performerLastName = avengerInfo[2];
		
		Avenger avenger = avengerMap.get(alias);
		// Print all ordered by appearance
		// Todo: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output
		

		 if (avenger == null) {
		        avenger = new Avenger(alias, lastName, performerLastName);
		        avengersArrayList.add(avenger);
		        avengerMap.put(alias, avenger);
		    } else {
		    }
		 System.out.println(foundWord);
		 if(foundWord.equals(alias)) {
			 avenger.incrementAliasCount();
		 }else if(foundWord.equals(lastName)) {
			 avenger.incrementLastNameCount();
		 }else if(foundWord.equals(performerLastName) ) {
			 avenger.incrementPerformerCount();
		 }
				 
		
	}


		/**
		 * print the results
		 */
		private void printResults() {
			/*
			 * Make sure your format matches the sample output exactly. No extra empty
			 * lines, or text. Use the diff command to check if your output matches the
			 * sample outputs.
			 */
			System.out.println("Total number of words: " + totalwordcount);
			System.out.println("Number of Avengers Mentioned: " + avengersArrayList.size());
			System.out.println();

			// Print all ordered by appearance
			System.out.println("All avengers in the order they appeared in the input stream:");
			// Todo: Print the list of avengers in the order they appeared in the input
			// Make sure you follow the formatting example in the sample output
			organizeList(avengersArrayList, false);
			System.out.println();

			// Print all ordered by AvengerComparatorFreqDesc
			System.out.println("Top " + topN + " most popular avengers:");
			// Todo: Print the topN most popular avengers, see the instructions for tie
			// breaking
			// Make sure you follow the formatting example in the sample output
			Collections.sort(avengersArrayList, new AvengerPopularitySort());
			organizeList(avengersArrayList, true);

			System.out.println();

			// Print top n ordered by AvengerPerformerComparatorFreqDesc
			System.out.println("Top " + topN + " most popular performers:");
			// Todo: Print the topN most popular performers, see the instructions for tie
			// breaking
			// Make sure you follow the formatting example in the sample output
			Collections.sort(avengersArrayList, new PerfomerPopularitySort());
			organizeList(avengersArrayList, true);
			System.out.println();

			// Print all ordered by alias alphabetically
			System.out.println("All mentioned avengers in alphabetical order:");
			// Todo: Print the list of avengers in alphabetical order
			// Make sure you follow the formatting example in the sample output
			Collections.sort(avengersArrayList);
			organizeList(avengersArrayList, false);
			System.out.println();
		}


	public  void organizeList(ArrayList<Avenger> avengers,boolean showTopHeros) {
		int index = 0;
		while(index < avengers.size()) {

			System.out.println(avengers.get(index).toString());
			index++;
			if(showTopHeros && index == topN  ) {
				break;
			}
				
		}
	}
}

