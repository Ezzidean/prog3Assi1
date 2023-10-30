import java.util.Comparator;

public class AlphabeticallyAliasSort implements Comparator<Avenger> {

	@Override
	public int compare(Avenger o1, Avenger o2) {
		int result = o1.getAlias().compareTo(o2.getAlias());

		return result;
	}

}
