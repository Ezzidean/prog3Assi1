import java.util.Comparator;

/**
 * Sorts popularity of avengers by implementing Comparator
 */
public class AvengerPopularitySort implements Comparator<Avenger> {

	/**
	 * Creates order for names to sorted by and stores that value in results
	 * 
	 * @return results value of the comparison
	 */
	@Override
	public int compare(Avenger a1, Avenger a2) {
		int results = a2.getTotalCount() - a1.getTotalCount();
		if (results == 0) {
			results = a1.getPerformerLastName().compareTo(a2.getPerformerLastName());
		}
		return results;
	}

}
