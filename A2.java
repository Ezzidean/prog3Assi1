import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A2 {
	public String[][] avengerRoster = { { "captainamerica", "rogers", "evans" }, { "ironman", "stark", "downey" },
			{ "blackwidow", "romanoff", "johansson" }, { "hulk", "banner", "ruffalo" },
			{ "blackpanther", "tchalla", "boseman" }, { "thor", "odinson", "hemsworth" },
			{ "hawkeye", "barton", "renner" }, { "warmachine", "rhodes", "cheadle" },
			{ "spiderman", "parker", "holland" }, { "wintersoldier", "barnes", "stan" } };

	private int topN = 4;
	private Scanner input = new Scanner(System.in);
	private int totalwordcount = 0;
	private Map<String, Avenger> avengerMap = new HashMap<>();
	private String foundKeyWords;
	private SLL<Avenger> orderAppeard = new SLL<>();
	private SLL<Avenger> popularAdvengerOrder = new SLL<>(new AvengerPopularitySort());
	private SLL<Avenger> popularPerformerOrder = new SLL<>(new PerfomerPopularitySort());
	private SLL<Avenger> AlpabeticalAlisorder = new SLL<>(new AlphabeticallyAliasSort());

	public static void main(String[] args) {
		A2 a2 = new A2();
		a2.run();
	}

	/**
	 * Runs program
	 */
	public void run() {
		readInput();
		printResults();
	}

	/**
	 * Reads the input stream and keep track of how many times avengers are
	 * mentioned by alias or last name or performer's last name.
	 * 
	 * 
	 */
	private void readInput() {

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

	/**
	 * Updates the counts for the avenger found in the input.
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
			orderAppeard.addInOrder(avenger);
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
		/*
		 * Make sure your format matches the sample output exactly. No extra empty
		 * lines, or text. Use the diff command to check if your output matches the
		 * sample outputs.
		 */
		System.out.println("Total number of words: " + totalwordcount);
		System.out.println("Number of Avengers Mentioned: " + orderAppeard.size());
		System.out.println();
		// Print all ordered by appearance
		System.out.println("All avengers in the order they appeared in the input stream:");
		// Todo: Print the list of avengers in the order they appeared in the input
		// Make sure you follow the formatting example in the sample output
		orderAppeard.printSLL();
		System.out.println();

		// Print all ordered by AvengerComparatorFreqDesc
		System.out.println("Top " + topN + " most popular avengers:");
		// Todo: Print the topN most popular avengers, see the instructions for tie
		// breaking
		// Make sure you follow the formatting example in the sample output
		popularAdvengerOrder = sortLists(popularAdvengerOrder);
		popularAdvengerOrder.printSLL(topN);
		System.out.println();

		// Print top n ordered by AvengerPerformerComparatorFreqDesc
		System.out.println("Top " + topN + " most popular performers:");
		// Todo: Print the topN most popular performers, see the instructions for tie
		// breaking
		// Make sure you follow the formatting example in the sample output
		popularPerformerOrder = sortLists( popularPerformerOrder);
		popularPerformerOrder.printSLL(topN);
		System.out.println();

		// Print all ordered by alias alphabetically
		System.out.println("All mentioned avengers in alphabetical order:");
		// Todo: Print the list of avengers in alphabetical order
		// Make sure you follow the formatting example in the sample output
		AlpabeticalAlisorder = sortLists( AlpabeticalAlisorder);
		AlpabeticalAlisorder.printSLL();
		System.out.println();
	}
	
	/// add the contents of orderedApeared SLL to the other llist
	public SLL<Avenger> sortLists(SLL<Avenger> sll) {
		int j = orderAppeard.size();
		int i = 0;
		while(i < j) {
			sll.addInOrder(orderAppeard.get(i));
			i++;
		}
		return sll;
		
	}

}
