/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class State {

	// Fields
	protected Map<Symbole, Set<State>> accessibleStates;
	protected String name;
	protected boolean isFinal;
	protected boolean isInit;

	// Methods

	/**
	 * Constructor for the State class
	 * 
	 * @param a
	 * @param name
	 * @param isFinal
	 */
	@Deprecated
	public State(Map<Symbole, Set<State>> a, String name, boolean isFinal, boolean isInit) {
		this.accessibleStates = a;
		this.name = name;
		this.isFinal = isFinal;
		this.isInit=isInit;
	}
	public State(String name, boolean isInit, boolean isFinal){
		this.name = name ;
		this.isFinal = isFinal;
		this.isInit=isInit;
		this.accessibleStates = new HashMap<Symbole, Set<State>>() ;
	}
	
	public void addAccessibleState(State state, Symbole e){
		if(!this.accessibleStates.containsKey(e))
			this.accessibleStates.put(e, new HashSet<State>());
		this.accessibleStates.get(e).add(state);
	}
	/**
	 * Return true if this state is a final state
	 * 
	 * @return true if this state is a final state
	 */
	public boolean isFinal() {
		return this.isFinal;
	}
	
	/**
	 * Return true if this is an initial state
	 * 
	 * @return true if this is an initial state
	 */
	public boolean isInit() {
		return this.isInit;
	}

	/**
	 * Merges two states in a returned one
	 * name = {n1, n2}
	 * isInit & isFalse = true if st1 or st2 is true
	 * @param st1 the first state
	 * @param st2 the second state
	 * @return a new state in which st1 & st2 merged
	 */
	public static State merge(State st1, State st2) {
		String stResName = "{" + st1.toString() + ", " + st2.toString() + "}";
		boolean stResIsInit =  st1.isInit() || st2.isInit();
		boolean stResIsFinal = st1.isFinal() || st2.isFinal();
		return new State(stResName, stResIsInit, stResIsFinal);
	}
	
	/**
	 * Permet de connaitre les prochains Etats, attention c est un AFN il y a
	 * plusieurs destinations possibles
	 * 
	 * @param e
	 *            le symbole qui va etre lu
	 * @return les prochains états possible depuis l'Etat actuel ou null si rien
	 *         n'est possible
	 */
	public Set<State> delta(Symbole e) {
		if (!(this.accessibleStates.containsKey(e)))
			return new HashSet<State>();
		Set<State> leSet = this.accessibleStates.get(e);
		return leSet;
	}

	/**
	 * Returns true if a final state can be accessed from this
	 * 
	 * @return true if a final state can be accessed from this
	 */
	public boolean canAccessFinal() {
		for (State state : this.getCoAccessibleStates()) {
			if (state.isFinal())
				return true;
		}
		return this.isFinal;
	}

	/**
	 * Returns a Set of States coAccessibles from this state
	 * 
	 * @return a Set of States coAccessibles from this state
	 */
	public Set<State> getCoAccessibleStates() {
		return this.getCoAccessibleStates(new HashSet<State>());
	}

	/**
	 * Private method used by {@link automates.State#getCoAccessibleStates()}
	 * Returns a Set of States coAccessibles from this state
	 * 
	 * @param coaccessibleStates
	 *            a Set containing the visited states
	 * @return a Set containing the visited states append by
	 *         this.accessibleStates
	 */
	private Set<State> getCoAccessibleStates(Set<State> visitedStates) {
		for (Set<State> listeStates : this.accessibleStates.values()) {
			for (State state : listeStates) {
				visitedStates.add(state);
				state.getCoAccessibleStates(visitedStates);
			}
		}
		return visitedStates;
	}

	// A RETIRER JE CROIS JE
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see java.lang.Object#equals(java.lang.Object)
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (obj instanceof State) {
//			State other = (State) obj;
//			if (accessibleStates == null) {
//				if (other.accessibleStates != null)
//					return false;
//			} else
//				if (!accessibleStates.equals(other.accessibleStates))
//					return false;
//			return true;
//		}
//		return false;
//	}

	/**
	 * Renvoie le nom de l'Etat
	 * 
	 * @return a string containing the name of the state
	 */
	public String toString() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
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
}
