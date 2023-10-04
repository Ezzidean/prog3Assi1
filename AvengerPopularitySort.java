import java.util.Comparator;

public class AvengerPopularitySort implements Comparator<Avenger> {

	@Override
	public int compare(Avenger a1, Avenger a2) {
		int results =  a2.frequencySum() - a1.frequencySum();
		if(results == 0) {
			a1.getPerformer().compareTo(a2.getPerformer());
		}
		return results;
	}

	
}
