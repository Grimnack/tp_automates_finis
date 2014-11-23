/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Class defining the AFN, implementing the interface Automata
 */
public class AFN implements Automata {
	
	protected Set<State> initialsStates ;
	protected Set<Symbole> alphabet ;
	
	
	
	
	
	/**
	 * Constructor of class AFN need two lists of states 
	 */
	public AFN(Set<State> init, Set<Symbole> alphabet){
		this.initialsStates = init ;
		this.alphabet = alphabet ;
	}
	public AFN(){
		this.initialsStates=new HashSet<State>() ;
		this.alphabet=new HashSet<Symbole>();
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
	private boolean aux(String mot, Set<State> list)
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
	private Set<State> listDelta(Set<State> list, Symbole e)
	{
		Set<State> res = new HashSet<State>() ;
		for (Iterator<State> i = list.iterator();i.hasNext();)
		{
			res.addAll(i.next().delta(e)) ;
		}
		return res ;
	}
	
	private boolean isTerminal(Set<State> set)
	{
		for(Iterator<State> i = set.iterator();i.hasNext();)
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
		Set<State> lesEtats = this.initialsStates ;
		boolean onContinue = true ;
		int numEtat = 0 ;
		while(onContinue){
			onContinue=false;
			/*pour chaque etat du set si on accede à un etat qui appartient pas au set on continue
			 * on ajoute l'etat au set
			 * sinon on stop*/
			for(State state : lesEtats){
				nouvelEtat = new State() ;
				for(Symbole e : this.alphabet){
					State nouveau = this.ajouteNouveaux(state.delta(e),lesEtats);
					if(nouveau != null){ /*En gros 1 etat a été rajouté, bon maintenant coco réfléchit pour build l'AFN en meme temps*/
						lesEtats.add(nouveau) ;
						onContinue = true ;
					}
						
				}
			}
		}
		return new AFN() ;
	}
	/*
	 * 
	 */
	private State envoieNouveau(Set<State> nouveaux,Set<State> courants){
		Set<State> res = courants ;
		State etatARajouter ;
		Iterator<State> i = nouveaux.iterator();
		etatARajouter = i.next();
		if(containsMany(nouveaux)){
			while(i.hasNext()){
				etatARajouter.fusionne(i.next());
			}
			return etatARajouter ;
		}
		return null;
		
	}
	
	private boolean containsMany(Set<State> ensemble){
		int cpt = 0 ;
		/*ce qui serait cool ce serait de savoir si nouveaux contient plusieurs etats */
		for(State state : ensemble )
			cpt++;
		if(cpt>1)
			return true ;
		return false ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
