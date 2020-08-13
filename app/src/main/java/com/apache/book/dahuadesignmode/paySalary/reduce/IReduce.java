package com.apache.book.dahuadesignmode.paySalary.reduce;


import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;

/**
 * 扣除项
 */
public interface IReduce {

	 double calculateDeductions(PayDetail detail);
}
