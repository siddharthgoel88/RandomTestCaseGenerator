package com.rgen.ds;

public class Date {
	private int day;
	private int month;
	private int year;
	private static final byte[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", 
		"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	public Date() {}
	
	public Date(int day, int month, int year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
		if (! isValid())
			throw new IllegalArgumentException();
	}
	
	public boolean isLeapYear() {
		if (year % 4 != 0)
			return false;
		
		if ((year % 100 == 0) && (year % 400 !=0 ))
			return false;
		
		return true;
	}
	
	public String toDDMMYYYY() {
		if (isValid())
			return Integer.toString(day) + "/" + Integer.toString(month) + "/" + Integer.toString(year);
		else
			throw new IllegalArgumentException();
	}
	
	public String toDDMMMYYYY() {
		if (isValid())
			return Integer.toString(day) + " " + months[this.month] + " " + Integer.toString(year);
		else
			throw new IllegalArgumentException();
	}
	
	public boolean isValid() {
		if (day > 31 || day < 1 || month > 12 || month < 1 || year < 1)
			return false;
		
		if (days[month] < day)
			return false;
		
		if (!isLeapYear() && days[2]==29)
			return false;
		
		return true;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
