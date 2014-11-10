/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

/**
 * Class defining the AlphaMot
 */
public class AlphaMot extends Mot {
	
	
	public AlphaMot(String mot){
		this.lesSymboles = new AlphaSymbole[mot.length()] ;
		for(int i=0;i<mot.length();i++){
			this.lesSymboles[i] = new AlphaSymbole(mot.charAt(i)) ;
		}
	}
	

	/* (non-Javadoc)
	 * @see automates.Mot#getSymboleAt(int)
	 */
	@Override
	public Symbole getSymboleAt(int i) {
		return this.lesSymboles[i];
	}
	
	

}
