
public class Avenger implements Comparable<Avenger> {
	private String alias;
	private String lastName;
	private String performerLastName;
	private int aliasCount;
	private int lastNameCount;
	private int performerCount;

	public Avenger(String alias, String lastName, String performerLastName) {
		this.alias = alias;
		this.lastName = lastName;
		this.performerLastName = performerLastName;
		this.aliasCount = 0;
		this.lastNameCount = 0;
		this.performerCount = 0;
	}

	public String getAlias() {
		return alias;
	}
	public String getPerformerLastName() {
		return performerLastName;
	}

	public int getAliasCount() {
		return aliasCount;
	}

	public int getLastNameCount() {
		return lastNameCount;
	}

	public int getPerformerCount() {
		return performerCount;
	}

	public int getTotalCount() {
		return aliasCount + lastNameCount + performerCount;
	}

	public void incrementAliasCount() {
		aliasCount++;
	}

	public void incrementLastNameCount() {
		lastNameCount++;
	}

	public void incrementPerformerCount() {
		performerCount++;
	}
	
	public String toString() {
		String format = alias + " aka " + lastName
				+ " performed by " + performerLastName
				+ " mentioned "
				+ "(n: " + lastNameCount
				+ " + a: " + aliasCount
				+ " + p: " + performerCount
				+ ")" + " time(s)";
		return format;
	}
	
	@Override
	public int compareTo(Avenger o) {
		int result = this.getAlias().compareTo(o.getAlias());
		
		return result;
	}
}
