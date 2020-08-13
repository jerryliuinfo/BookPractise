package com.apache.book.dahuadesignmode.paySalary.classify;

import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;
import com.apache.book.dahuadesignmode.paySalary.domain.SalesReceipt;
import com.apache.book.dahuadesignmode.paySalary.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 提成支付
 * @author tery
 *
 */
public class SalesPayClassify implements IPayClassify {
	double salary;
	double rate;
	Map<Date, SalesReceipt> receipts;
	public SalesPayClassify(double salary , double rate){
		receipts = new HashMap<>();
		this.salary = salary;
		this.rate = rate;
	}

	@Override
	public double calculatePay(PayDetail detail) {
		double commission = 0.0;
		for(SalesReceipt sr : receipts.values()){
			if(DateUtil.between(sr.getSaleDate(), detail.getPayPeriodStartDate(),
					detail.getPayPeriodEndDate())){
				commission += sr.getAmount() * rate;
			}
		}
		return salary + commission;
	}

}
