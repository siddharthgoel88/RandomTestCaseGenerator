package com.rgen.modules;

import java.util.HashMap;

import com.rgen.ds.Date;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;

public class DateList implements Generator {
	
	private enum dateformats {
		DDMMYYYY, // eg. 20/10/1988
		DDMMMYYYY // eg. 20 Oct 1988
	}
	
	private String result;
	private int format;
	private long size;
	private Date date;
	private HashMap<String, Integer> check;
	
	public DateList() {
		result = "";
		check = new HashMap<String, Integer>();
		format = 1;
	}

	@Override
	public String type() {
		return "List of Dates";
	}

	public void formats() {
		String form = "";
		form += "Available formats are :\n"
				+ "1.\n"
				+ "<no_of_dates>\n"
				+ "DD/MM/YYYY\n"
				+ "...\n"
				+ "DD/MM/YYYY\n"
				+ "2.\n"
				+ "<no_of_dates>\n"
				+ "DD MMM YYYY\n"
				+ "...\n"
				+ "DD MMM YYYY\n";
		StdOut.println(form);
		StdOut.println("Enter the format you want to enter:");
		format = StdIn.readInt();
		format--;
	}
	
	@Override
	public void takeInput() {
		formats();
		StdOut.print("How many dates do you want to generate :");
		size = StdIn.readLong();
	}
	
	private String toStr() {
		if (format == dateformats.DDMMYYYY.ordinal())
			return date.toDDMMYYYY();
		else
			return date.toDDMMMYYYY();
	}

	private String generateDate() {
		boolean flag;
		int day,month,year;
		do {
			flag = false;
			day = StdRandom.uniform(1, 32);
			month = StdRandom.uniform(1, 13);
			year = StdRandom.uniform(1900, 2015);
			try {
				date = new Date(day, month, year);
				if (check.containsKey(toStr()))
					flag = true;
			} catch(Exception e) {
				flag = true;
			}
		} while(flag);
		
		check.put(toStr(), 1);
		return toStr();
	}
	
	@Override
	public String generate() {
		result += Long.toString(size) + "\n";
		while(size-- > 0) {
			result += generateDate() + "\n";
		}
		return result;
	}

}
