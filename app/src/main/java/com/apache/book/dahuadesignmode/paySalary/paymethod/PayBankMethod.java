package com.apache.book.dahuadesignmode.paySalary.paymethod;

import com.apache.book.dahuadesignmode.paySalary.domain.PayDetail;

/**
 * Created by jerryliu on 2017/8/23.
 * 银行转帐
 */

public class PayBankMethod implements IPayMethod {
    @Override
    public void pay(PayDetail detail) {
        System.out.println("银行支付应付： "+detail.getGrossPay() +", 扣款: "+detail.getDeductions() +" ,实付 : "+detail.getNetPay());
    }
}
