
public class Avenger implements Comparable<Avenger> {
	private String alias;
	private String lastName;
	private String performerLastName;
	private int aliasCount;
	private int lastNameCount;
	private int performerCount;
    

	/**
	 * Assigns Avengers to attributes.
	 * 
	 * @param alias             as a string
	 * @param lastName          String as a string
	 * @param performerLastName as a string
	 */
	public Avenger(String alias, String lastName, String performerLastName) {
		this.alias = alias;
		this.lastName = lastName;
		this.performerLastName = performerLastName;
		this.aliasCount = 0;
		this.lastNameCount = 0;
		this.performerCount = 0;
	}

	/**
	 * gets alias
	 * 
	 * @return alias of avenger
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * gets PerformerLastName
	 * 
	 * @return performerLastName of avenger
	 */
	public String getPerformerLastName() {
		return performerLastName;
	}

	/**
	 * gets lastName
	 * 
	 * @return lastName of avenger
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * gets aliasCount
	 * 
	 * @return aliasCount of avenger
	 */
	public int getAliasCount() {
		return aliasCount;
	}

	/**
	 * gets lastNameCount
	 * 
	 * @return lastNameCount of avenger
	 */
	public int getLastNameCount() {
		return lastNameCount;
	}

	/**
	 * gets PerformerCount
	 * 
	 * @return performerCount of avenger
	 */
	public int getPerformerCount() {
		return performerCount;
	}

	/**
	 * gets totalCount of the three name types
	 * 
	 * @return sums of aliasCount + lastNameCount + performerCount of avenger
	 */
	public int getTotalCount() {
		return aliasCount + lastNameCount + performerCount;
	}

	/**
	 * increments aliasCount
	 */
	public void incrementAliasCount() {
		aliasCount++;
	}

	/**
	 * increments lastNameCount
	 */
	public void incrementLastNameCount() {
		lastNameCount++;
	}

	/**
	 * increments performerCount
	 */
	public void incrementPerformerCount() {
		performerCount++;
	}

	/**
	 * Creates toString format for output
	 * 
	 * @return format returns toString format
	 */
	public String toString() {
		String format = alias + " aka " + lastName + " performed by " + performerLastName + " mentioned " + "(n: "
				+ lastNameCount + " + a: " + aliasCount + " + p: " + performerCount + ")" + " time(s)";
		return format;
	}

	/**
	 * Creates an order for alias to be compared
	 * 
	 * @return result of the int value for the comparison
	 */
	@Override
	public int compareTo(Avenger o) {
		int result = this.getAlias().compareTo(o.getAlias());

		return result;
	}
	

	
	
}
