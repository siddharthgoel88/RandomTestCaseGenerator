package com.rgen.modules;

import com.rgen.ds.Date;

public class DateList implements Generator {
	
	private String result;
	private Date date;
	
	public DateList() {
		result = "";
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
		// TODO Auto-generated method stub

	}

	@Override
	public String generate() {
		// TODO Auto-generated method stub
		return result;
	}

}
