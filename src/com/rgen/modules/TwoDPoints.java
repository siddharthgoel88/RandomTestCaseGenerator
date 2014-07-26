package com.rgen.modules;

import java.util.HashMap;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class TwoDPoints implements Generator {

	private String result;
	private HashMap<String, Integer> pointsAdded;
	private int x;
	private int y;
	private long size;
	private final int POINTMAX = 30000;
	private final int POINTMIN = 0;
	
	public TwoDPoints() {
		pointsAdded = new HashMap<String, Integer>();
		result = "";
	}
	
	@Override
	public String type() {
		return "Two dimensional co-ordinate points";
	}

	@Override
	public void takeInput() {
		StdOut.println(formats());
		StdOut.println("How many points do you want:");
		size = StdIn.readLong();
	}
	
	private String formats() {
		String format="";
		format = "List of available formats are:\n"
				+ "1.\n<number_of_points> \n"
				+ "<x1-coordinate> <y1-coordinate>\n"
				+ "<x2-coordinate> <y2-coordinate>\n"
				+ "...\n"
				+ "<xk-coordinate> <yk-coordinate>\n";
		return format;
	}
	
	private String toStr() {
		return Integer.toString(x) + " " + Integer.toString(y);
	}

	private String genTwoD() {
		do {
			x = StdRandom.uniform(POINTMIN, POINTMAX);
			y = StdRandom.uniform(POINTMIN, POINTMAX);
		} while (pointsAdded.containsKey(toStr()));
		pointsAdded.put(toStr(), 1);
		return toStr();
	}
	
	@Override
	public String generate() {
		result = Long.toString(size) + "\n";
		while (size-- > 0) {
			result += genTwoD() + "\n";
		}
		return result;
	}

}
