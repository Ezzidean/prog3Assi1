import java.util.Comparator;

public class PerfomerPopularityCount implements Comparator<Avenger> {

	@Override
	public int compare(Avenger a1, Avenger a2) {
		int results = a2.getPerformerFreq() - a1.getPerformerFreq();
		if(results == 0) {
			
			if(a1.getPerformer().length() > a2.getPerformer().length()) {
				results = 1;
			}else if(a1.getPerformer().length() < a2.getPerformer().length()) {
				results = -1;
			}else if(a1.getPerformer().length() == a2.getPerformer().length()) {
				results = a1.getHeroAlias().compareTo(a2.getHeroAlias());
			}
		}
		return 0;
	}

}
