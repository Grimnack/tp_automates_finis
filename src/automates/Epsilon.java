/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

/**
 * Class defining the Epsilon
 */
public class Epsilon implements Symbole {

	//Attributes
	
	/**
	 * Constant EPS
	 */
	public static final Epsilon EPS = new Epsilon();
	
	//Methods
	/**
	 * Constructor for the Epsilon class
	 * Private because there is only one instance of Epsilon
	 */
	private Epsilon() {
		
	}

	/**
	 * Returns a string defining the AlphaSymbol
	 * @return a string defining the AlphaSymbol
	 */
	public String toString() {
		return "Ɛ";
	}

}
