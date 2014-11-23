/**
 * @author Matthieu Caron
 * @author Arnaud Cojez
 */
package automates.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import automates.AlphaSymbole;
import automates.State;
import automates.Symbole;

/**
 * Class defining the StateTest
 */
public class StateTest {

	/**
	 * Test method for {@link automates.State#delta(automates.Symbole)}.
	 */
	@Test
	public void testDelta() {
		State stateA = new State("State a", false, true);
		State stateB = new State("State b", false, true);
		State stateTot = new State("tot", true, false);
		stateTot.addAccessibleState(stateA, new AlphaSymbole('a'));
		stateTot.addAccessibleState(stateB, new AlphaSymbole('b'));
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
		State stateA = new State("State a", false, true);
		State stateB = new State("State b", false, false);
		State stateTot = new State("tot", true, false);
		stateTot.addAccessibleState(stateA, new AlphaSymbole('a'));
		stateTot.addAccessibleState(stateB, new AlphaSymbole('b'));
		assertTrue(stateA.delta(new AlphaSymbole('a')).isEmpty());
		assertTrue(stateTot.canAccessFinal());
		assertTrue(stateA.canAccessFinal());
		assertFalse(stateB.canAccessFinal());
	}

	/**
	 * Test method for {@link automates.State#getCoAccessibleStates()}.
	 */
	@Test
	public void testGetCoAccessibleStates() {
		State stateA = new State("State a", false, true);
		State stateB = new State("State b", false, false);
		State stateTot = new State("tot", true, false);
		stateTot.addAccessibleState(stateA, new AlphaSymbole('a'));
		stateTot.addAccessibleState(stateB, new AlphaSymbole('b'));
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
		State stateFinal = new State("testFinal", true, true);
		State stateNotFinal = new State("testNotFinal", true, false);
		assertTrue(stateFinal.isFinal());
		assertFalse(stateNotFinal.isFinal());
	}

	/**
	 * Test method for {@link automates.State#isInit()}.
	 */
	@Test
	public void testIsInit() {
		State stateInit = new State("testInit", true, true);
		State stateNotInit = new State("testNotInit", false, true);
		assertTrue(stateInit.isInit());
		assertFalse(stateNotInit.isInit());
	}

	/**
	 * Test method for {@link automates.State#merge()}.
	 */
	@Test
	public void testMerge() {
		State stateA = new State("stateA", true, false);
		State stateB = new State("stateB", false, true);
		State stateAB = State.merge(stateA, stateB);
		assertEquals("{stateA, stateB}", stateAB.toString());
		assertTrue(stateAB.isInit());
		assertTrue(stateAB.isFinal());
	}
	
	
}
