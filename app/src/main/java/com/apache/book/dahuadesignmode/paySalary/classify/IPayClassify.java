package com.apache.book.dahuadesignmode.paySalary.classify;

import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;

/**
 * 支付策略接口
 * @author tery
 *
 */
public interface IPayClassify {
	 double calculatePay(PayDetail detail);
}
