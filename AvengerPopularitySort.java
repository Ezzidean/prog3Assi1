import java.util.Comparator;

public class AvengerPopularitySort implements Comparator<Avenger> {

	@Override
	public int compare(Avenger a1, Avenger a2) {
		int results =      a2.getTotalCount() - a1.getTotalCount();
		if(results == 0) {
		   results =	a1.getPerformerLastName().compareTo(a2.getPerformerLastName());
		}
		return results;
	}

	
}
