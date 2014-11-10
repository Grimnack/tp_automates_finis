/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package automates;

import java.util.List;

/**
 * Class defining the epsilon AFN, extending an AFN
 */
public class EpsilonAFN extends AFN{

	/**
	 * Constructor for the EpsilonAFN class
	 * @param init
	 * @param finals
	 */
	public EpsilonAFN(List<State> init, List<State> finals) {
		super(init, finals);
		// TODO Auto-generated constructor stub
	}

}
