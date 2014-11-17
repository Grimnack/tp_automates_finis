/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class defining the Alphabet
 */
public class Alphabet {

	protected Set<Symbole> symboles;
	
	public Alphabet() {
		this.symboles = new HashSet<Symbole>();
	}
	
	public Alphabet(List<Symbole> symboles) {
		this.symboles = new HashSet<Symbole>(symboles);
	}
	
	public void add(Symbole sym) {
		this.symboles.add(sym);
	}
	
	public boolean contains(Symbole sym) {
		return this.symboles.contains(sym);
	}
}
