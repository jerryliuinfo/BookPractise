package com.apache.book.dahuadesignmode.paySalary.paymethod;

import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;

/**
 * 支付方式
 */
public interface IPayMethod {
	 void pay(PayDetail detail);
}
