package com.rgen;
import edu.princeton.cs.introcs.*;

public class RandomTestGenerator {
	private final int INTMAX = 999999;
	private final double DBMIN = 0.0;
	private final double DBMAX = 999999.0;
	String result;
	String filename;
	
	public RandomTestGenerator() {
		result = "";
	}

	public void init() {
		this.takeInput();
		this.choose();
		this.makeFile();
	}
	
	//Take test-case related input from the user.
	private void takeInput() {
		String option;
		StdOut.print("Enter the filename :");
		filename = StdIn.readString();

		StdOut.print("Choose the type of data to be generated:\n"
				+ "1. List of random numbers\n"
				+ "2. Graph\n"
				+ "Enter the option number:");
		option = StdIn.readString().trim();

		switch(option) {
			case "1":
				generateList();
				break;
			case "2":
				generateGraph();
				break;
			default:
				generateList();
				break;
		}
	}
	
	private void generateGraph() {
		// TODO Auto-generated method stub
		result = "Graph test case yet to implemented.";
	}

	private void generateList() {
		int count=0;
		String option;
		StdOut.print("Type of list:\n"
				+ "1. Interger\n"
				+ "2. Float\n"
				+ "Enter the option number:");
		option = StdIn.readString().trim();

		StdOut.println("Size of list you want:");
		count = StdIn.readInt();

		StdOut.println(filename + " will be of following format:\n"
				+ "[size]\n"
				+ "[Number 1]\n"
				+ "[Number 2]\n"
				+ "...\n"
				+ "[Number n]\n");

		while(count-- > 0)
			result += generateNumber(option);

	}

	private String generateNumber(String option) {
		switch(option) {
		case "1":
			return Integer.toString(StdRandom.uniform(INTMAX)) + "\n";
		case "2":
			return Double.toString(StdRandom.uniform(DBMIN,DBMAX)) + "\n";
		default:
			return Integer.toString(StdRandom.uniform(INTMAX)) + "\n";
		}
	}

	//Choose the type of test-case data to be generated
	private void choose() {
	}
	
	//Write the result to the file
	private void makeFile() {
		StdOut.println("Creating file ...");
		Out file = new Out(filename);
		file.print(result);
		file.close();
		StdOut.println("File created.");
	}
	
	public static void main(String[] args) {
		RandomTestGenerator obj = new RandomTestGenerator();
		obj.init();
	}

}
