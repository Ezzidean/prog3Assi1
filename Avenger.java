
public class Avenger implements Comparable<Avenger> {
	private String heroAlias;
	private String heroName;
	private String performer;

	private int nameFreq;
	private int aliasFreq;
	private int performerFreq;

	// TODO: Implement the Avenger Class
	public Avenger( String heroName, String heroAlias, String performer,int nameFreq, int alisFreq, int PerformerFreq) {
		this.heroName = heroName;
		this.heroAlias = heroAlias;
		this.performer = performer;
		this.nameFreq = nameFreq;
		this.aliasFreq = alisFreq;
		this.performerFreq = PerformerFreq;
	}
	/***
	 *  returns the Avengers name
	 * @return heroName
	 */
	public String getHeroName() {
		return heroName;
	}
	/***
	 * returns the Avengers Alias
	 * @return heroAlias
	 */
	public String getHeroAlias() {
		return heroAlias;
	}
	public String getPerformer() {
		return performer;
	}
	public int getNameFreq() {
		return nameFreq;
	}
	public int getAlisFreq() {
		return aliasFreq;
	}
	public int getPerformerFreq() {
		return performerFreq;
	}
	public int frequencySum() {
		return nameFreq+ aliasFreq+ performerFreq;
	}
	
	
	@Override
	public int compareTo(Avenger o) {
		int result = o.getHeroAlias().compareTo(o.getHeroAlias());
		
		return result;
	}
}
