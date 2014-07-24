package com.rgen.modules;

public interface Generator {
	
	/**
	 * Returns the name of the generator.
	 * @return
	 */
	public String type();
	
	/**
	 * Takes the necessary user input.
	 */
	public void takeInput();
	
	/**
	 * Generates random data as per specified option
	 * @return the generated random data
	 */
	public String generate();
}
