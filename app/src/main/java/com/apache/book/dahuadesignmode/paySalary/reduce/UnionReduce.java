package com.apache.book.dahuadesignmode.paySalary.reduce;

import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;
import com.apache.book.dahuadesignmode.paySalary.util.DateUtil;

import java.util.Date;
import java.util.Map;


/**
 * 协会收取会员费用
 * @author tery
 *
 */
public class UnionReduce implements IReduce {

	private String memberID;
	private double weeklyDue;
	private Map<Date, ServiceCharge> serviceCharges;
	
	public void addServiceCharge(ServiceCharge sc){
		serviceCharges.put(sc.getDate(), sc);
	}
	
	@Override
	public double calculateDeductions(PayDetail pc) {
		double totalPay = 0;
		for (ServiceCharge sc : serviceCharges.values()) {
			if (DateUtil.between(sc.getDate(), pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())) {
				totalPay+=sc.getAmount();	//会费
			}
		}
		return totalPay+calculatePayForWeeklyDue(pc);
	}
	/**
	 * 服务费
	 * 每周应付款，计算出有多少个周五*单周服务费
	 * @return
	 */
	private double calculatePayForWeeklyDue(PayDetail detail) {
		int interval=(int) DateUtil.getDaysBetween( detail.getPayPeriodStartDate(),detail.getPayPeriodEndDate());
		return interval/7*weeklyDue;
	}
}
