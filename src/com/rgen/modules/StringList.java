package com.rgen.modules;

import edu.princeton.cs.introcs.*;

public class StringList implements Generator {
	private long size;
	private String result;
	
	public StringList() {
		result = "";
	}

	@Override
	public String type() {
		return "Strings List";
	}
	
	private String formats() {
		String format;
		format = "Various available lists are:\n"
				+ "1. Dictionary words\n";
		return format;
	}
	
	@Override
	public void takeInput() {
		StdOut.println(this.formats());
		StdOut.print("How many words do you want to generate:");
		size = StdIn.readLong();
	}

	@Override
	public String generate() {
		String filename;
		String[] allStrings;
		int len,count;
		
		filename = "data/dictionary-words.txt";
		
		In input = new In(filename);
		len = input.readAllStrings().length;
		input.close();
		count = len;
		allStrings = new String[len];
		input = new In(filename);
		allStrings = input.readAllStrings();
		StdRandom.shuffle(allStrings);
		
		while(size-- > 0) {
			result += allStrings[--count] + "\n";
			if (count == 0) {
				count = len;
				StdRandom.shuffle(allStrings);
			}
		}
		
		return result;
	}

}
