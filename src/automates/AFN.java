/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

import java.util.Iterator;
import java.util.List;

/**
 * Class defining the AFN, implementing the interface Automata
 */
public class AFN implements Automata {
	
	protected List<State> initialsStates ;
	protected List<State> finalsStates ;
	
	/**
	 * Constructor of class AFN need two lists of states 
	 */
	public AFN(List<State> init, List<State> finals){
		this.initialsStates = init ;
		this.finalsStates = finals ;
	}
	
	/**
	 * returns true if [mot] is accepted by the AFN
	 * @return true if [mot] is accepted by the AFN
	 */
	@Override
	public boolean accept(String mot) {
		String chaineActuelle = mot; 
		boolean res = true;
		Iterator<State> iter = this.initialsStates.iterator();
		while(iter.hasNext()&&chaineActuelle!=""){
			Symbole s = new AlphaSymbole(chaineActuelle.charAt(0)) ;
			List<State> nextStates = iter.next().delta(s);
			chaineActuelle = chaineActuelle.substring(1) ;
			if(nextStates!=null){
					/*Faut que je pense a faire ça sur papier avant
					 * mais d'abord dodo */
				
			} 
			
		}
		
		return res;
	}

	private boolean aux(String mot, boolean notAccepted){
		if(mot == ""){
			List<State> nextStates = iter.next().delta(leMot.getSymboleAt(0));
			if(nextStates!=null){
				
			} 
		}
		return notAccepted;
		
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
		// TODO Auto-generated method stub
		return null;
	}
}
