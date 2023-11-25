import java.util.Comparator;

public class AvengerComparatorMentionOrder implements Comparator<Avenger> {

	@Override
	public int compare(Avenger a1, Avenger a2) {
		// TODO Auto-generated method stub
	     return a2.insertionOrder() - a1.insertionOrder();

	}

}
