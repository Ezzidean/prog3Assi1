
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * COMP 2503 Fall 2023 Assignment 3 Avenger Statistics
 * 
 * This program reads a input stream and keeps track of the statistics for avengers
 * mentioned by name, alias, or performer's last name.
 * The program uses a BST
 * for storing the data. Multiple BSTs with alternative orderings are
 * constructed to show the required output.
 * 
 * @author Maryam Elahi
 * @date Fall 2023
 */

public class A3 {

	private Map<String, Avenger> avengerMap = new HashMap<>();
	private String foundKeyWords;
	public String[][] avengerRoster = { { "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan" } };

	private int topN = 4;
	private int totalwordcount = 0;
	private int orderAdded;
	private Scanner input = new Scanner(System.in);
	private BST<Avenger> alphabticalBST = new BST<>();
	private BST<Avenger> mentionBST = new BST<Avenger>(new AvengerComparatorMentionOrder());
	private BST<Avenger> mostPopularAvengerBST = new BST<Avenger>(new AvengerComparatorFreqDesc());
	private BST<Avenger> mostPopularPerformerBST = new BST<Avenger>(new AvengerPerformerComparatorFreqDesc());
	
	public static void main(String[] args) {
		A3 a3 = new A3();
		a3.run();
	}

	public void run() {
		readInput();
		
		createdAlternativeOrderBSTs();
		printResults();
	}

	private void createdAlternativeOrderBSTs() {
		/* TODO:
		 *   - delete the following two avengers (if they exist) from the alphabetical tree
		 *   	- barton
		 *   	- banner
		 *   use the tree iterator to do an in-order traversal of the alphabetical tree,
		 *   and add avengers to the other trees with alternative ordering
		 */
		alphabticalBST.delete(new Avenger("hawkeye", "barton", "renner"));
	    alphabticalBST.delete(new Avenger("hulk", "banner", "ruffalo"));
	    
	    Iterator<Avenger> ai = alphabticalBST.iterator();
		while(ai.hasNext()) {
			Avenger avenger = ai.next();
			
			mentionBST.add(avenger);
			mostPopularAvengerBST.add(avenger);
			mostPopularPerformerBST.add(avenger);
		}
		

		
	}

	/**
	 * read the input stream and keep track how many times avengers are mentioned by
	 * alias or last name or performer name.
	 */
	private void readInput() {
		/* Create a mention index counter and initialize it to 1
		 * While the scanner object has not reached end of stream, 
		 * 	- read a word. 
		 * 	- clean up the word 
		 * 	- if the word is not empty, add the word count. 
		 * 	- Check if the word is either an avenger alias or last name, or performer last name then
		 *		- Create a new avenger object with the corresponding alias and last name and performer last name.
		 *		- check if this avenger has already been added to the alphabetically ordered tree
		 *			- if yes, increase the corresponding frequency count for the object already in the tree.
		 *			- if no, add the newly created avenger to the alphabetically ordered BST, 
		 *				- remember to set the frequency and the mention index.
		 * You need to think carefully about how you are keeping track of the mention order by setting the mention order for each new avenger.
		 */
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
							foundKeyWords = word;
							updateAvengerCounts(avengerInfo);
							break;
						}
					}
				}
			}
		}
	}
	
	
	private void updateAvengerCounts(String[] avengerInfo) {
		String alias = avengerInfo[0];
		String lastName = avengerInfo[1];
		String performerLastName = avengerInfo[2];

		Avenger avenger = avengerMap.get(alias);
		// Print all ordered by appearance
		// Todo: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output

		if (avenger == null) {
			orderAdded++;
			avenger = new Avenger(alias, lastName, performerLastName);
			avenger.SetInsertionOrder(orderAdded);
			alphabticalBST.add(avenger);
			avengerMap.put(alias, avenger);
		} else {
		}
		// System.out.println(foundKeyWords);

		if (foundKeyWords.equals(alias)) {
			avenger.incrementAliasCount();
		} else if (foundKeyWords.equals(lastName)) {
			avenger.incrementLastNameCount();
		} else if (foundKeyWords.equals(performerLastName)) {
			avenger.incrementPerformerCount();
		}

	}

	/**
	 * print the results
	 */
	private void printResults() {
		// Todo: Print the total number of words (this total should not include words that are all digits or punctuation.)
		System.out.println("Total number of words: " + totalwordcount);
		// TODO: Print the number of mentioned avengers after deleting "barton" and "banner".
		System.out.println("Number of Avengers Mentioned: " + alphabticalBST.getSize());
		
		System.out.println();

		System.out.println("All avengers in the order they appeared in the input stream:");
		// TODO: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output
		Iterator<Avenger> mb = mentionBST.iterator();
		while(mb.hasNext()) {
			System.out.println(mb.next());
		}
		
		System.out.println();
		
		System.out.println("Top " + topN + " most popular avengers:");
		// TODO: Print the most popular avengers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		Iterator<Avenger> popavenger = mostPopularAvengerBST.iterator();
		while(popavenger.hasNext()) {
			System.out.println(popavenger.next());
		}
		System.out.println();

		System.out.println("Top " + topN + " most popular performers:");
		// TODO: Print the most popular performers, see the instructions for tie breaking
		// Make sure you follow the formatting example in the sample output
		
		
		Iterator<Avenger> popperformer = mostPopularPerformerBST.iterator();
		while(popperformer.hasNext()) {
			System.out.println(popperformer.next());
		}
		System.out.println();

		System.out.println("All mentioned avengers in alphabetical order:");
		// TODO: Print the list of avengers in alphabetical order
		Iterator<Avenger> it = alphabticalBST.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();

		// TODO: Print the actual height and the optimal height for each of the four trees.
		System.out.println("Height of the mention order tree is : " + mentionBST.height(mentionBST.root) + "Optimal height for this tree is :" + mentionBST.optimalHeight(mentionBST.root));
		
		System.out.println("Height of the alphabetical tree is : " + alphabeticalBST.height(alphabeticalBST.root) + "Optimal height for this tree is :" + alphabeticalBST.optimalHeight(alphabeticalBST.root));
		
		System.out.println("Height of the most frequent tree is : " + mostFrequentBST.height(mostFrequentBST.root) + "Optimal height for this tree is :" + mostFrequentBST.optimalHeight(mostFrequentBST.root));
		
		System.out.println("Height of the most frequent performer tree is : " + mostFrequentPerformerBST.height(mostFrequentPerformerBST.root) + "Optimal height for this tree is :" + mostFrequentPerformerBST.optimalHeight(mostFrequentPerformerBST.root));
	}
}
