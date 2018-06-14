package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Skill enum class
 * @author Brian Stamm
 */
public class SkillTests {

	//Variables for testing
	private int testRate = 150;
	private String softwareTesterString = "Tester";
	
	/**
	* Tests the getRate() method, checking that it returns the correct value
	*/
	@Test
	public void testGetRate() {
		assertEquals(Skill.SOFTWARE_ENGINEER.getRate(),testRate);
	}
	
	/**
	* Tests the toString() method
	*/
	@Test
	public void testToString() {
		assertEquals(Skill.SOFTWARE_TESTER.toString(),softwareTesterString);
	}

}
