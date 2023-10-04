import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	private Scanner input = new Scanner(System.in);
	private int totalwordcount = 0;
	private ArrayList<Avenger> avengersArrayList = new ArrayList<>();

	public static void main(String[] args) {
		A1 a1 = new A1();
		a1.run();
	}

	public void run() {
		readInput();
		printResults();
	}

	/**
	 * read the input stream and keep track how many times avengers are mentioned by
	 * alias or last name or performer's last name.
	 */
	private void readInput() {
		/*
		 * In a loop, while the scanner object has not reached end of stream,
		 * 
		 * - read a word. - clean up the word - if the word is not empty, add the word
		 * count. - Check if the word is either an avenger alias or last name, or
		 * performer last name then - Create a new avenger object with the corresponding
		 * alias and last name and performer last name. - if this avenger has already
		 * been mentioned, increase the corresponding frequency count for the object
		 * already in the list. - if this avenger has not been mentioned before, add the
		 * newly created avenger to the list, remember to update the corresponding
		 * frequency.
		 */
		int wordCount = 0;
		int words = 0;
		for (int i = 0; i <= words; i++) {
			File input = new File("input1.txt");
			try {
				Scanner fileReader = new Scanner(input);
				while (fileReader.hasNext()) {
					ArrayList<String> Avengers = new ArrayList<String>();

					String newWord = fileReader.next().toLowerCase().trim();
					if (!newWord.matches("[^a-z]*")) {

					}

					if (!newWord.matches("^'[a-z]*")) {
						Avengers.add(newWord);
						wordCount += 1;

						if (newWord.contains("'")) {
							int j = newWord.indexOf("'");
							newWord = newWord.substring(0, j);
						}

					} else {
						continue;
					}

					System.out.println(Avengers);

				}
				System.out.println(wordCount);
			} catch (FileNotFoundException e) {

				System.out.println("Wrong file address");
				run();
			}

		}
	}

	/*
	 * Create helper functions as needed
	 */

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
		System.out.println();

		// Print all ordered by AvengerComparatorFreqDesc
		System.out.println("Top " + topN + " most popular avengers:");
		// Todo: Print the topN most popular avengers, see the instructions for tie
		// breaking
		// Make sure you follow the formatting example in the sample output
		System.out.println();

		// Print top n ordered by AvengerPerformerComparatorFreqDesc
		System.out.println("Top " + topN + " most popular performers:");
		// Todo: Print the topN most popular performers, see the instructions for tie
		// breaking
		// Make sure you follow the formatting example in the sample output
		System.out.println();

		// Print all ordered by alias alphabetically
		System.out.println("All mentioned avengers in alphabetical order:");
		// Todo: Print the list of avengers in alphabetical order
		// Make sure you follow the formatting example in the sample output
		System.out.println();
	}
}
