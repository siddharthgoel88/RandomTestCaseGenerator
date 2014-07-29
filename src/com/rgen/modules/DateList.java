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
		format = 0;
	}

	@Override
	public String type() {
		return "List of Dates";
	}

	public String formats() {
		return null;
	}
	
	@Override
	public void takeInput() {
		StdOut.println("How many dates do you want to generate :");
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
			} catch(Exception e) {
				flag = true;
			}
			if (check.containsKey(toStr()))
				flag = true;
		} while(flag);
		
		check.put(toStr(), 1);
		return toStr();
	}
	
	@Override
	public String generate() {
		while(size-- > 0) {
			result += generateDate() + "\n";
		}
		return result;
	}

}
