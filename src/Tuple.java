
/**
 * @author Yuxiang Chen
 *
 */
public class Tuple {

	/**
	 * Key of Tuple
	 */
	private int keyP;
	/**
	 * Value of Tuple
	 */
	private float valueP;

	/**
	 * Constructor for Tuple
	 * 
	 * @param keyP
	 *            Key of Tuple
	 * @param valueP
	 *            Value of Tuple
	 */
	public Tuple(int keyP, float valueP) {
		this.keyP = keyP;
		this.valueP = valueP;
	}

	/**
	 * @return the key of Tuple
	 */
	public int getKey() {
		return keyP;
	}

	/**
	 * @return the value of Tuple
	 */
	public float getValue() {
		return valueP;
	}

	/**
	 * Check if this Tuple equals t
	 * 
	 * @param t
	 *            the Tuple that's being compared
	 * @return true if both keys and values are equal.<br>
	 *         false, otherwise.
	 */
	public boolean equals(Tuple t) {
		return (t.getKey() == keyP && t.getValue() == valueP);
	}

}
