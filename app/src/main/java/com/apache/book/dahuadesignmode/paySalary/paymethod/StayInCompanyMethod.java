package com.apache.book.dahuadesignmode.paySalary.paymethod;

import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;

/**
 * 保留在财务
 * @author tery
 *
 */
public class StayInCompanyMethod implements IPayMethod {

	@Override
	public void pay(PayDetail detail) {
		System.out.println("财务保留应付： "+detail.getGrossPay() +", 扣款: "+detail.getDeductions() +" ,实付 : "+detail.getNetPay());
	}

}
