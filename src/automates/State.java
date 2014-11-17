/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */package automates;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class State {

	// Fields
	protected Map<Symbole, List<State>> accessibleStates;
	protected String name;
	protected boolean isFinal;

	// Methods

	/**
	 * Constructor for the State class
	 * 
	 * @param a
	 * @param name
	 * @param isFinal
	 */
	public State(Map<Symbole, List<State>> a, String name, boolean isFinal) {
		this.accessibleStates = a;
		this.name = name;
		this.isFinal = isFinal;
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
	public List<State> delta(Symbole e) {
		if (!(this.accessibleStates.containsKey(e)))
			return new LinkedList<State>();
		List<State> laListe = this.accessibleStates.get(e);
		return laListe;
	}

	/**
	 * Returns true if a final state can be accessed from this
	 * 
	 * @return true if a final state can be accessed from this
	 */
	public boolean canAccessFinal() {
		for (State state : this.getCoAccessibleStates()) {
			if(state.isFinal())
				return true;
		}
		return this.isFinal;
	}

	public Set<State> getCoAccessibleStates() {
		return this.getCoAccessibleStates(new HashSet<State>());
	}

	private Set<State> getCoAccessibleStates(Set<State> coaccessibleStates) {
		for (List<State> listeStates : this.accessibleStates.values()) {
			for (State state : listeStates) {
				coaccessibleStates.addAll(state.getCoAccessibleStates(coaccessibleStates));
			}
		}
		return coaccessibleStates;
	}

	/*
	 * (non-Javadoc)
	 * 
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
	 * Renvoie le nom de l'Etat
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

	public boolean isFinal() {
		return this.isFinal;
	}
}
