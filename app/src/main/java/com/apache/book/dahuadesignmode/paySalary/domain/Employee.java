package com.apache.book.dahuadesignmode.paySalary.domain;

import com.apache.book.dahuadesignmode.paySalary.classify.IPayClassify;
import com.apache.book.dahuadesignmode.paySalary.paymethod.IPayMethod;
import com.apache.book.dahuadesignmode.paySalary.reduce.IReduce;
import com.apache.book.dahuadesignmode.paySalary.schedule.IPayDate;

import java.util.Date;


public class Employee {
	private String id;
	private String name;
	private Integer age;
	private Integer sex;
	private IPayClassify classify;//支付策略类型
	private IPayDate IPayDate;//支付时间抽象类
	private IPayMethod IPayMethod;//支付方式
	private IReduce iReduce;//扣除项

	public Employee(String id, String name){
		this.id = id;
		this.name = name;
	}
	public boolean isPayDay(Date d) {
		return this.IPayDate.isPayDate(d);
	}

	public Date getStartDate(Date d) {
		return this.IPayDate.getPayPeriodStartDate(d);
	}

	public void payDay(PayDetail detail){
		 double grossPay = classify.calculatePay(detail);
		 double deductions = iReduce.calculateDeductions(detail);
		 double netPay = grossPay - deductions;
		 detail.setGrossPay(grossPay);
		 detail.setDeductions(deductions);
		 detail.setNetPay(netPay);
		 IPayMethod.pay(detail);
	}
	
	public void setClassification(IPayClassify classify) {
		this.classify = classify;
	}
	public void setSchedule(IPayDate payDateUtil) {
		this.IPayDate = payDateUtil;
	}
	public void setIPayMethod(IPayMethod IPayMethod) {
		this.IPayMethod = IPayMethod;
	}


	public void setiReduce(IReduce iReduce) {
		this.iReduce = iReduce;
	}
}

