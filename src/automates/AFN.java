/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class defining the AFN, implementing the interface Automata
 */
public class AFN implements Automata {

	protected Set<State> initialsStates;
	protected Set<Symbole> alphabet;

	/**
	 * Constructor of class AFN
	 * 
	 * @param init
	 *            Set of initial States
	 * @param alphabet
	 *            Set of symbols representing the alphabet
	 */
	public AFN(Set<State> init, Set<Symbole> alphabet) {
		this.initialsStates = init;
		this.alphabet = alphabet;
	}

	/**
	 * Constructor of class AFN The initial States will be added after the
	 * construction by {@link addState}
	 * 
	 * @param alphabet
	 *            Set of symbols representing the alphabet
	 */
	public AFN(Set<Symbole> alpha) {
		this.initialsStates = new HashSet<State>();
		this.alphabet = alpha;
	}

	/**
	 * Adds an initial State to this
	 * 
	 * @param state
	 *            the State to add
	 */
	public void addState(State state) {
		this.initialsStates.add(state);
	}

	/**
	 * Adds a Set of initial States to this
	 * 
	 * @param lesEtats
	 *            the Set containing the States to add
	 */
	public void addStateSet(Set<State> lesEtats) {
		for (State state : lesEtats) {
			this.addState(state);
		}

	}

	/**
	 * returns true if [mot] is accepted by the AFN
	 * 
	 * @return true if [mot] is accepted by the AFN
	 */
	@Override
	public boolean accept(String mot) {

		return aux(mot, this.initialsStates);
	}

	/**
	 * Recursive function used by accept
	 * 
	 * @param mot
	 *            the word we want to test
	 * @param set
	 *            the state where we start to test
	 * @return true when we passed by all states and a State in [set] is final
	 */
	private boolean aux(String mot, Set<State> set) {
		if (mot.equalsIgnoreCase("")) {
			return this.isTerminal(set);
		} else {
			return aux(mot.substring(1),
					this.deltaSet(set, new AlphaSymbole(mot.charAt(0))));
		}
	}

	/**
	 * Function used by aux Returns a Set of States reached from the States in
	 * [set] with the Symbole [e] transition
	 * 
	 * @param set
	 *            the Set of States where we start searching
	 * @param e
	 *            the Symbole of the transition
	 * @return a Set of States reached from the States in [set] with the Symbole
	 *         [e] transition
	 */
	private Set<State> deltaSet(Set<State> set, Symbole e) {
		Set<State> res = new HashSet<State>();
		for (Iterator<State> i = set.iterator(); i.hasNext();) {
			res.addAll(i.next().delta(e));
		}
		return res;
	}

	/**
	 * Function used by aux Returns true if a State in [set] is Final
	 * 
	 * @param set
	 *            the Set analysed
	 * @return true if a State in [set] is Final
	 */
	private boolean isTerminal(Set<State> set) {
		for (Iterator<State> i = set.iterator(); i.hasNext();) {
			if (i.next().isFinal())
				return true;
		}
		return false;
	}

	/**
	 * Returns true if the AFN is empty
	 * 
	 * @return true if the AFN is empty
	 */
	@Override
	public boolean isEmpty() {
		for (State state : this.initialsStates) {
			if(state.canAccessFinal())
				return false;
		}
		return true;
	}

	/**
	 * Returns an deterministic version of the AFN
	 * 
	 * @return the AFD based on this AFN
	 */
	@Override
	public AFN deterministic() {
		Set<State> lesEtats = this.initialsStates;
		boolean onContinue = true;
		while (onContinue) {
			onContinue = false;
			/*
			 * pour chaque etat du set si on accede à un etat qui appartient pas
			 * au set on continue on ajoute l'etat au set sinon on stop
			 */
			for (State state : lesEtats) {
				for (Symbole e : this.alphabet) {
					State nouveau = this
							.envoieNouveau(state.delta(e), lesEtats);
					if (nouveau != null) { /*
											 * En gros 1 etat a été rajouté, bon
											 * maintenant coco réfléchit pour
											 * build l'AFN en meme temps
											 */
						lesEtats.add(nouveau);
						onContinue = true;
					}

				}
			}
		}
		AFN res = new AFN(this.alphabet);
		/* il faut ajouter les etats initiaux du set les Etats */
		res.addStateSet(lesEtats);
		return res;
	}

	/**
	 * Function used by deterministic Returns a new State which contains all the
	 * State characteristics of the [nouveaux]'s States
	 * 
	 * @param nouveaux
	 * @param courants
	 * @return a new State which contains all the State characteristics of the
	 *         [nouveaux]'s States
	 */
	private State envoieNouveau(Set<State> nouveaux, Set<State> courants) {
		State etatARajouter;
		Iterator<State> i = nouveaux.iterator();
		etatARajouter = i.next();
		if (containsMany(nouveaux)) {
			while (i.hasNext()) {
				State.merge(etatARajouter, i.next());
			}
			return etatARajouter;
		}
		return null;

	}

	/**
	 * Returns true if there is more than one State in [ensemble]
	 * 
	 * @param ensemble
	 *            the Set of State we want to analyse
	 * @return true if there is more than one State in [ensemble]
	 */
	@SuppressWarnings("unused")
	private boolean containsMany(Set<State> ensemble) {
		int cpt = 0;
		for (State state : ensemble)
			cpt++;
		if (cpt > 1)
			return true;
		return false;
	}

}
