package com.apache.book.dahuadesignmode.paySalary.schedule;

import com.apache.book.dahuadesignmode.paySalary.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;




public class OverWeekPay implements IPayDate {
	Date firstPayableFriday = DateUtil.parseDate("2017-6-2");
	
	@Override
	public boolean isPayDate(Date date) {
		long interval = DateUtil.getDaysBetween(firstPayableFriday, date);
		return interval % 14 == 0;
	}

	@Override
	public Date getPayPeriodStartDate(Date payPeriodEndDate) {
		//隔一周周五支付 从本次支付时间减去13天 也就是从上上周六开始
		return DateUtil.add(payPeriodEndDate, -13);
		
	}
	
	public static void main(String [] args) throws Exception{
		OverWeekPay schedule = new OverWeekPay();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("2017-06-30");
		
		System.out.println(schedule.isPayDate(d));
		
		System.out.println(DateUtil.isFriday(d));		
		
		System.out.println(schedule.getPayPeriodStartDate(d));
	}

}
