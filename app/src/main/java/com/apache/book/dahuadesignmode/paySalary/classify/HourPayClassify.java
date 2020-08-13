package com.apache.book.dahuadesignmode.paySalary.classify;

import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;
import com.apache.book.dahuadesignmode.paySalary.domain.TimeCard;
import com.apache.book.dahuadesignmode.paySalary.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 按小时支付
 * @author tery
 *
 */

public class HourPayClassify implements IPayClassify {
	private double rate;
	private Map<Date, TimeCard> timeCards;
	
	public HourPayClassify(double hourlyRate) {
		timeCards = new HashMap<>();
		this.rate = hourlyRate;
	}
	public void addTimeCard(TimeCard tc){
		timeCards.put(tc.getDate(), tc);
	}
	@Override
	public double calculatePay(PayDetail detail) {
		double totalPay = 0;
		for(TimeCard tc : timeCards.values()){
			if(DateUtil.between(tc.getDate(), detail.getPayPeriodStartDate(),
					detail.getPayPeriodEndDate())){
				totalPay += calculatePayForTimeCard(tc);
			}
		}		
		return totalPay;
		
	}
	private double calculatePayForTimeCard(TimeCard  tc) {
	    int hours = tc.getHours();
	    
	    if(hours > 12){
	    	return 12*rate + (hours-12) * rate * 2;
	    } else{
	    	return 12*rate;
	    }
	}


	public Map<Date, TimeCard> getTimeCards() {
		return timeCards;
	}
}

