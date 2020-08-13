package com.apache.book.dahuadesignmode.paySalary.reduce;


import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;

/**
 * 不扣除
 *
 */
public class NonReduce implements IReduce {
	@Override
	public double calculateDeductions(PayDetail detail) {
		
		return 0;
	}
}
