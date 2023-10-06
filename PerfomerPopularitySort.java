import java.util.Comparator;

public class PerfomerPopularitySort implements Comparator<Avenger> {

	
	@Override
	public int compare(Avenger a1, Avenger a2) {
		int results = a2.getPerformerCount() - a1.getPerformerCount();
		if(results == 0) {
			
			if(a1.getPerformerLastName().length() > a2.getPerformerLastName().length()) {
				results = 1;
			}else if(a1.getPerformerLastName().length() < a2.getPerformerLastName().length()) {
				results = -1;
			}else if(a1.getPerformerLastName().length() == a2.getPerformerLastName().length()) {
				results = a1.getAlias().compareTo(a2.getAlias());
			}
		}
		return results;
	}

}
