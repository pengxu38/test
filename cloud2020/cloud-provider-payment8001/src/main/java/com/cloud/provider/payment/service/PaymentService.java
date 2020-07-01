package com.cloud.provider.payment.service;
import org.apache.ibatis.annotations.Param;

import com.atguigu.springcloud.entites.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentByid(@Param("id") Long id);
}
