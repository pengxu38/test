package com.cloud.provider.payment.service.impl;


import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.entites.Payment;
import com.cloud.provider.payment.dao.PaymentDao;
import com.cloud.provider.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentByid(@Param("id") Long id){
        return paymentDao.getPaymentByid(id);
    }
}
