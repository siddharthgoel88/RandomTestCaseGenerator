package com.rgen.modules;
import edu.princeton.cs.introcs.*;

public class NumberList implements Generator {
	
	private String format;
	private String choice;
	private long size;
	private final int INTMAX = 999999;
	private final double DBMIN = 0.0;
	private final double DBMAX = 999999.0;
	
	public NumberList() {
		choice = "1"; //default choice of integers
		format = "1"; //default format
	}
	
	@Override
	public String type() {
		return "Number List";
	}
	
	private String formats() {
		String format = "";
		format += "Formats available:\n1. \n" + "<size_of_list>\n"
				+ "<number_1>\n<number_2>\n"
				+ "...\n<number_n>";
		return format;
	}
	
	@Override
	public void takeInput() {
		StdOut.println("Which type of list do you want ?\n"
				+ "1. Integer \n 2. Float\n Enter choice (1 or 2):");
		choice = StdIn.readString();
		
		StdOut.println(formats());
		StdOut.println("Enter choice (default->1):");
		format = StdIn.readString();
		
		StdOut.print("How many random numbers do you want to generate? :");
		size = StdIn.readLong();
		
		if (choice == null || format == null)
			throw new NullPointerException("Provide non-null input");
	}

	@Override
	public String generate() {
		String result = "";
		result = Long.toString(size);
		while (size-- > 0) {
			result += generateNumber(); 
		}
		return result;
	}
	
	private String generateNumber() {
		switch(choice) {
		case "1":
			return Integer.toString(StdRandom.uniform(INTMAX)) + "\n";
		case "2":
			return Double.toString(StdRandom.uniform(DBMIN,DBMAX)) + "\n";
		default:
			return Integer.toString(StdRandom.uniform(INTMAX)) + "\n";
		}
	}

}
