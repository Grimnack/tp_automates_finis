/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

/**
 * Class defining the AFN, implementing the interface Automata
 */
public class AFN implements Automata {
	
	/**
	 * returns true if [mot] is accepted by the AFN
	 * @return true if [mot] is accepted by the AFN
	 */
	@Override
	public boolean accept(String mot) {
		// TODO Auto-generated method stub 
		return false;
	}

	/**
	 * returns true if the AFN is empty
	 * @return true if the AFN is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * returns an deterministic version of the AFN
	 * @return the AFD based on this AFN
	 */
	@Override
	public AFN deterministic() {
		// TODO Auto-generated method stub
		return null;
	}
}
