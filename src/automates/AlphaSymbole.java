/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package automates;

/**
 * Class defining the AlphaSymbole
 */
public class AlphaSymbole implements Symbole {
	
	//Attributes
	
	protected char symbole;
	
	//Methods
	/**
	 * Constructor for the AlphaSymbole class
	 * throws an IllegalArgumentException if symbole is not a letter
	 * @param symbole a letter
	 * @throws IllegalArgumentException
	 */
	public AlphaSymbole(char symbole) throws IllegalArgumentException {
		if(Character.isLetter(symbole))
			this.symbole = symbole;
		else
			throw new IllegalArgumentException("Not a letter");
	}
	
	/**
	 * Returns true if the two symbols are the same
	 * @return true if the two symbols are the same
	 */
	public boolean equals(Object o) {
		if(o instanceof AlphaSymbole) {
			AlphaSymbole s2 = (AlphaSymbole) o;
			return this.symbole == s2.symbole;
		}
		return false;
	}
	
	/**
	 * Returns a string defining the AlphaSymbol
	 * @return a string defining the AlphaSymbol
	 */
	public String toString() {
		return "" + this.symbole;
	}
}
