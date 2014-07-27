package com.rgen.modules;

public class DateList implements Generator {
	
	private String result;
	
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
