/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import automates.AFN;
import automates.AlphaSymbole;
import automates.State;
import automates.Symbole;

/**
 * Class defining the AFNTest
 */
public class AFNTest {

	/**
	 * Test method for {@link automates.AFN#addState(automates.State)}.
	 */
	@Test
	public void testaddState() {
		Set<Symbole> alpha = new HashSet<Symbole>();
		alpha.add(new AlphaSymbole('s'));
		AFN afn = new AFN(alpha);
		State state = new State("state", true, true);
		assertTrue(afn.isEmpty());
		afn.addState(state);
		assertFalse(afn.isEmpty());
	}

	/**
	 * Test method for {@link automates.AFN#addStateSet(java.util.Set)}.
	 */
	@Test
	public void testAddStateSet() {
		Set<Symbole> alpha = new HashSet<Symbole>();
		alpha.add(new AlphaSymbole('s'));
		AFN afn = new AFN(alpha);
		Set<State> stateSet = new HashSet<State>();
		stateSet.add(new State("state1", true, true));
		stateSet.add(new State("state2", true, false));
		stateSet.add(new State("state3", true, false));
		assertTrue(afn.isEmpty());
		afn.addStateSet(stateSet);
		assertFalse(afn.isEmpty());
	}

	/**
	 * Test method for {@link automates.AFN#accept(java.lang.String)}.
	 */
	@Test
	public void testAccept() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link automates.AFN#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		Set<Symbole> alpha = new HashSet<Symbole>();
		alpha.add(new AlphaSymbole('s'));
		AFN afn = new AFN(alpha);
		State state = new State("stateInit", true, false);
		afn.addState(state);
		assertTrue(afn.isEmpty());
		state = new State("stateFinal", true, true);
		afn.addState(state);
		assertFalse(afn.isEmpty());
	}

	/**
	 * Test method for {@link automates.AFN#deterministic()}.
	 */
	@Test
	public void testDeterministic() {
		fail("Not yet implemented");
	}

}
