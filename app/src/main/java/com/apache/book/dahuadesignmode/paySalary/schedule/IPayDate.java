package com.apache.book.dahuadesignmode.paySalary.schedule;

import java.util.Date;
/**
 * 支付日期接口
 * @author tery
 *
 */
public interface IPayDate {
	/**
	 * 是否时支付日
	 * @param date
	 * @return
	 */
	 boolean isPayDate(Date date);

	/**
	 *
	 * @param endDate
	 * @return
	 */
	 Date getPayPeriodStartDate(Date endDate);
}
