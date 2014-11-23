/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Class defining the AFN, implementing the interface Automata
 */
public class AFN implements Automata {
	
	protected List<State> initialsStates ;
	protected List<State> finalsStates ;
	protected Set<Symbole> alphabet ;
	
	/**
	 * Constructor of class AFN need two lists of states 
	 */
	public AFN(List<State> init, List<State> finals,Set<Symbole> alphabet){
		this.initialsStates = init ;
		this.finalsStates = finals ;
		this.alphabet = alphabet ;
	}
	
	/**
	 * returns true if [mot] is accepted by the AFN
	 * @return true if [mot] is accepted by the AFN
	 */
	@Override
	public boolean accept(String mot) {
		
		return aux(mot, this.initialsStates);
	}

	/**
	 * 
	 * @param mot le mot qui doit etre accepter par l'automate 
	 * @param list la list des automates a tester 
	 * @return true quand on a fini la recursivité, et qu'un etat de la liste est un etat final
	 */
	private boolean aux(String mot, List<State> list)
	{
		if(mot.equalsIgnoreCase(""))
		{
			return this.isTerminal(list);
		}else 
		{	
				return aux(mot.substring(1),this.listDelta(list,new AlphaSymbole(mot.charAt(0))));	
		}
	}
	/**
	 * 
	 * @param list
	 * @param e le symbole a tester 
	 * @return une liste d'etat qui sont les etats potentiels après l'évaluation de e
	 */
	private List<State> listDelta(List<State> list, Symbole e)
	{
		List<State> res = new LinkedList<State>() ;
		for (Iterator<State> i = list.iterator();i.hasNext();)
		{
			res.addAll(i.next().delta(e)) ;
		}
		return res ;
	}
	
	private boolean isTerminal(List<State> list)
	{
		for(Iterator<State> i = list.iterator();i.hasNext();)
		{
			if(i.next().isFinal())
				return true;
		}
		return false;
	}
	
	
	
	/**
	 * returns true if the AFN is empty
	 * @return true if the AFN is empty
	 */
	@Override
	public boolean isEmpty() {
		boolean empty = false;
		for (State state : this.initialsStates) {
			empty = !state.canAccessFinal();
		}
		return empty;
	}

	/**
	 * returns an deterministic version of the AFN
	 * @return the AFD based on this AFN
	 */
	@Override
	public AFN deterministic() {
		/*Bon là on admet que l'on a un Set des etats initiaux*/
		/*etape 1*/
		/*On donne un set d'etats, pour chaque symbole de l'alphabet on obtient un Set.*/
		/*j'ai ajouté l'attribut alphabet dans AFN, il faut aussi je pense ajouter le boolean isInitial dans State*/
		return null;
	}
}
