/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */

package automates;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class State {
	protected Map<Symbole, List<State>> accessibleStates ;
	protected String name ;
	protected boolean isFinal ;
	
	
	public State(Map<Symbole, List<State>> a, String name,boolean isFinal ){
		this.accessibleStates=a;
		this.name= name ;
		this.isFinal=isFinal;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((accessibleStates == null) ? 0 : accessibleStates.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (accessibleStates == null) {
			if (other.accessibleStates != null)
				return false;
		} else if (!accessibleStates.equals(other.accessibleStates))
			return false;
		return true;
	}



	/**
	 * Permet de connaitre les prochains Etats, attention c est un AFN il y a plusieurs destinations possibles 
	 * 
	 * @param e le symbole qui va etre lu 
	 * @return les prochains états possible depuis l'Etat actuel ou null si rien n'est possible 
	 */
	public List<State> delta(Symbole e){
		if(!(this.accessibleStates.containsKey(e)))
			return new LinkedList<State>();
			List<State> laListe = this.accessibleStates.get(e);
			return laListe;
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


	/**
	 * Returns true if a final state can be accessed from this
	 * @return true if a final state can be accessed from this
	 */
	public boolean canAccessFinal() {
		if(this.isFinal() && this.accessibleStates.isEmpty()) 
			for (List<State> listeStates : this.accessibleStates.values()) {
				for (State state : listeStates) {
					if(state.canAccessFinal())
						return true;
				}
			}
		return this.isFinal;
	}
}
