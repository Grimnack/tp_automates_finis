/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

/**
 * Class defining the Alphabetaz
 */
public class Alphabetaz extends Alphabet {

	/**
	 * Constructor for the Alphabetaz class
	 */
	public Alphabetaz() {
		super();
		char letters[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };
		for (char c : letters) {
			this.add(new AlphaSymbole(c));
		}
	}

}
