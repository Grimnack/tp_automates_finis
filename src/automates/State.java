/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package automates;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class State {
	protected List<Vector> lesVecteurs ;
	protected String name ;
	
	public State(LinkedList<Vector> v, String name ){
		this.lesVecteurs=v ;
		this.name= name ;
	}
	
	/**
	 * Permet de connaitre les prochains Etats, attention c est un AFN il y a plusieurs destinations possibles 
	 * 
	 * @param e le symbole qui va etre lu 
	 * @return les prochains états possible depuis l'Etat actuel ou null si rien n'est possible 
	 */
	public List<State> delta(Symbole e){
		Iterator<Vector> i = lesVecteurs.iterator() ;
		LinkedList<State> res = new LinkedList<State>() ;
		while(i.hasNext()){
			State actuel = i.next().readSymbole(e) ;
			if(actuel!=null)
				res.add(actuel) ;
		}
		return res ;
	}

	
	/**
	 * Renvoie le nom de l'Etat
	 */
	public String toString() {
		return this.name ;
	}
	
	
	
	

}
