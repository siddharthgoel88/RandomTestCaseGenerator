package com.rgen.modules;

public interface Generator {
	
	/**
	 * List all the available formats available for a generator.
	 * @return  a string of formats available for this type
	 */
	public String formats();

	/**
	 * Take user input for the type of format
	 */
	public void takeInput();
	
	/**
	 * Generates random data as per specified option
	 * @return the generated random data
	 */
	public String generate();
}
