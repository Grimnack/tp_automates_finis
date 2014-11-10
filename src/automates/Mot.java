/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

/**
 * Class defining the Mot
 */
public abstract class Mot {
	protected Symbole[] lesSymboles ;
	
	
	/**
	 * renvoie le symbole a l'indice i 
	 */
	public abstract Symbole getSymboleAt(int i) ; 
}
