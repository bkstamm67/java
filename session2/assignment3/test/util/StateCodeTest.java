package com.scg.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StateCodeTest {

	@Test
	public void testStateCodes() {
			
		assertEquals(StateCode.CA.toString(),"CA");
		assertEquals(StateCode.DC.name(),"DC");
		assertEquals(StateCode.MO.toString(),"MO");
		assertEquals(StateCode.NY.name(),"NY");
		assertEquals(StateCode.WA.toString(),"WA");
	}

}
