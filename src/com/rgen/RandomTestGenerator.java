package com.rgen;

public class RandomTestGenerator {
	String result;
	String filename;
	String option;
	
	public RandomTestGenerator() {
		result = "";
		filename = "test-case.txt";
	}

	public void init() {
		this.takeInput();
		this.choose();
		this.makeFile();
	}
	
	//Take test-case related input from the user.
	private void takeInput() {
	}
	
	//Choose the type of test-case data to be generated
	private void choose() {
	}
	
	//Write the result to the file
	private void makeFile() {
	}
	
	public static void main(String[] args) {
		RandomTestGenerator obj = new RandomTestGenerator();
		obj.init();
	}

}
