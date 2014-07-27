package com.rgen.ds;

public class Date {
	private int day;
	private int month;
	private int year;
	private byte[] days;
	
	public Date() {
		days = new byte[13];
		days[0] = 0;
		days[1] = 31;
		days[2] = 29;
		days[3] = 31;
		days[4] = 30;
		days[5] = 31;
		days[6] = 30;
		days[7] = 31;
		days[8] = 31;
		days[9] = 30;
		days[10] = 31;
		days[11] = 30;
		days[12] = 31;
		
	}
	
	public Date(int day, int month, int year) {
		super();
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	
	public boolean isLeapYear() {
		if (year % 4 != 0)
			return false;
		
		if ((year % 100 == 0) && (year % 400 !=0 ))
			return false;
		
		return true;
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
