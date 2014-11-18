/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Class defining the StateTest
 */
public class StateTest {

	/**
	 * Test method for {@link automates.State#delta(automates.Symbole)}.
	 */
	@Test
	public void testDelta() {
		State stateA = new State(new HashMap<Symbole, Set<State>>(), "State a", true);
		State stateB = new State(new HashMap<Symbole, Set<State>>(), "State b", true);
		HashMap<Symbole, Set<State>> mapStates = new HashMap<Symbole, Set<State>>();
		Set<State> setStateA = new HashSet<State>();
		setStateA.add(stateA);
		Set<State> setStateB = new HashSet<State>();
		setStateB.add(stateB);
		mapStates.put(new AlphaSymbole('a'), setStateA);
		mapStates.put(new AlphaSymbole('b'), setStateB);
		State stateTot = new State(mapStates, "tot", false);
		assertTrue(stateA.delta(new AlphaSymbole('a')).isEmpty());
		assertTrue(stateTot.delta(new AlphaSymbole('a')).contains(stateA));
		assertTrue(stateTot.delta(new AlphaSymbole('b')).contains(stateB));
		assertFalse(stateTot.delta(new AlphaSymbole('b')).contains(stateA));
		assertFalse(stateTot.delta(new AlphaSymbole('a')).contains(stateB));
	}

	/**
	 * Test method for {@link automates.State#canAccessFinal()}.
	 */
	@Test
	public void testCanAccessFinal() {
		State stateA = new State(new HashMap<Symbole, Set<State>>(), "State a", true);
		State stateB = new State(new HashMap<Symbole, Set<State>>(), "State b", false);
		HashMap<Symbole, Set<State>> mapStates = new HashMap<Symbole, Set<State>>();
		Set<State> setStateA = new HashSet<State>();
		setStateA.add(stateA);
		Set<State> setStateB = new HashSet<State>();
		setStateB.add(stateB);
		mapStates.put(new AlphaSymbole('a'), setStateA);
		mapStates.put(new AlphaSymbole('b'), setStateB);
		State stateTot = new State(mapStates, "tot", false);
		assertTrue(stateTot.canAccessFinal());
		assertTrue(stateA.canAccessFinal());
		assertFalse(stateB.canAccessFinal());
	}

	/**
	 * Test method for {@link automates.State#getCoAccessibleStates()}.
	 */
	@Test
	public void testGetCoAccessibleStates() {
		State stateA = new State(new HashMap<Symbole, Set<State>>(), "State a", true);
		State stateB = new State(new HashMap<Symbole, Set<State>>(), "State b", false);
		HashMap<Symbole, Set<State>> mapStates = new HashMap<Symbole, Set<State>>();
		Set<State> setStateA = new HashSet<State>();
		setStateA.add(stateA);
		Set<State> setStateB = new HashSet<State>();
		setStateB.add(stateB);
		mapStates.put(new AlphaSymbole('a'), setStateA);
		mapStates.put(new AlphaSymbole('b'), setStateB);
		State stateTot = new State(mapStates, "tot", false);
		Set<State> coAccess = stateTot.getCoAccessibleStates();
		assertFalse(coAccess.isEmpty());
		assertTrue(coAccess.contains(stateA));
		assertTrue(coAccess.contains(stateB));
	}

	/**
	 * Test method for {@link automates.State#isFinal()}.
	 */
	@Test
	public void testIsFinal() {
		State stateFinal = new State(new HashMap<Symbole, Set<State>>(), "testFinal", true);
		State stateNotFinal = new State(new HashMap<Symbole, Set<State>>(), "testNotFinal", false);
		assertTrue(stateFinal.isFinal());
		assertFalse(stateNotFinal.isFinal());
	}

}
