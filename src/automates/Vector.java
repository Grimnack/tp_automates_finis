/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package automates;

public class Vector {
	protected State arrive ;
	protected Symbole symbole ;
	
	public Vector(State arrive, Symbole symbole){
		this.arrive=arrive;
		this.symbole=symbole ;
	}
	
	/**
	 * Renvoie l'etat pointé par le vecteur si il accepte l'unique symbole s 
	 * @param s le symbole a tester 
	 * @return l'etat pointé par le vecteur si il accepte l'unique symbole s, sinon null
	 */
	public State readSymbole(Symbole s){
		if(this.symbole.equals(s))
			return this.arrive ;
		else
			return null;
	}
	
	

}
