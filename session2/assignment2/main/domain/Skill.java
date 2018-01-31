package com.scg.domain;

/**
 * Encapsulates the concept of a billable skill.
 * @author Brian Stamm
 */
public enum Skill {
	PROJECT_MANAGER("Project Manager",250),
	SYSTEM_ARCHITECT("System Architect",200),
	SOFTWARE_ENGINEER("Software Engineer",150),
	SOFTWARE_TESTER("Tester",100),
	UNKNOWN_SKILL("Unknown",0);
	
	private String formalName;
	private int rate;
	
	private Skill(String formalName, int rate) {
		this.formalName = formalName;
		this.rate = rate;
	}
	
	/**
	 * Getter for property rate.
	 * @return Value of property rate.
	 */
	public int getRate() {
		return rate;
	}
	
	/**
	 * Returns the friendly name for this enumerated value.
	 * @return the friendly name for this enumerated value
	 */
	@Override
	public String toString() {
		return formalName;
	}

}
