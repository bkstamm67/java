/**
 * 
 */
package com.scg.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Brian Stamm
 *
 */
public class SkillTests {

	@Test
	public void testGetRate() {
		assertEquals(Skill.SOFTWARE_ENGINEER.getRate(),150);
	}
	
	@Test
	public void testToString() {
		assertEquals(Skill.SOFTWARE_TESTER.toString(),"Tester");
	}

}
