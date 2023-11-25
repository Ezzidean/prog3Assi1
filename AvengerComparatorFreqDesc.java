import java.util.Comparator;

public class AvengerComparatorFreqDesc implements Comparator<Avenger> {

	@Override
	public int compare(Avenger a1, Avenger a2) {
		int results = a1.getTotalCount() - a2.getTotalCount();
		if (results == 0) {
			results = a2.getPerformerLastName().compareTo(a1.getPerformerLastName());
		}
		return results;
	}

}
