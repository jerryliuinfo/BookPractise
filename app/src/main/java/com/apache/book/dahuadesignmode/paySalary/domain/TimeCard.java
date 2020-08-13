package com.apache.book.dahuadesignmode.paySalary.domain;

import java.util.Date;

/**
 * 按公时计算
 */
public class TimeCard {
	private Date date;
	private int hours;
	
	public Date getDate() {
		return date;
	}
	public int getHours() {
		return hours;
	}


	public TimeCard(Date date, int hours) {
		this.date = date;
		this.hours = hours;
	}
}
