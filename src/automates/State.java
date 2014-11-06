/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package automates;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class State {
	protected Map<Symbole, List<State>> lesVecteurs ;
	protected String name ;
	protected boolean isFinal ;
	
	
	public State(Map<Symbole, List<State>> v, String name,boolean isFinal ){
		this.lesVecteurs=v ;
		this.name= name ;
		this.isFinal=isFinal ;
	}
	
	/**
	 * Permet de connaitre les prochains Etats, attention c est un AFN il y a plusieurs destinations possibles 
	 * 
	 * @param e le symbole qui va etre lu 
	 * @return les prochains états possible depuis l'Etat actuel ou null si rien n'est possible 
	 */
	public List<State> delta(Symbole e){
	// a completer
		
	return null ;
	}

	
	/**
	 * Renvoie le nom de l'Etat
	 */
	public String toString() {
		return this.name ;
	}
	
	public boolean isFinal() {
		return this.isFinal ;
	}
	
	

}
