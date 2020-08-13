package com.apache.book.dahuadesignmode.paySalary.domain;

import java.util.Date;

/**
 * 销售提成
 */
public class SalesReceipt {
	private Date saleDate;
	private double amount;
	public Date getSaleDate() {
		return saleDate;
	}
	public double getAmount() {
		return amount;
	}
}
