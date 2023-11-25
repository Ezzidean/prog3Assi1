import java.util.Comparator;

public class AvengerPerformerComparatorFreqDesc implements Comparator<Avenger> {

	@Override
	public int compare(Avenger a1, Avenger a2) {
		int results = a1.getPerformerCount() - a2.getPerformerCount();
		if (results == 0) {
			results = a2.getLastName().length() - a1.getLastName().length();
			 if (results == 0) {
				results = a2.getAlias().compareTo(a1.getAlias());
			}
		}
		return results;
	}
}
