package com.scg.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
* This is the JUnit tests for StateCodes.java
* @author Brian Stamm
*/
public class StateCodeTest {

	/**
	* Basic test set
	*/
	@Test
	public void testStateCodes() {

		StateCode california = StateCode.CA;
		assertEquals(StateCode.CA,california);
		assertEquals(StateCode.DC.name(),"DC");
		assertEquals(StateCode.MO.toString(),"MO");
		assertEquals(StateCode.NY.name(),"NY");
		assertEquals(StateCode.WA.toString(),"WA");
	}

}
