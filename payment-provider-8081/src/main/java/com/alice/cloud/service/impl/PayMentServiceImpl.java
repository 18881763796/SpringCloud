package com.alice.cloud.service.impl;

import com.alice.cloud.dao.PayDao;
import com.alice.cloud.entities.Payment;
import com.alice.cloud.service.IPayMentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayMentServiceImpl implements IPayMentService {

    @Resource
    private PayDao payDao;

    @Override
    public void insert(Payment payment) {
        payDao.insert(payment);
    }

    @Override
    public void delete(long id) {
        payDao.delete(id);
    }

    @Override
    public Payment update(Payment payment) {
        Payment p = payDao.update(payment);
        return p;
    }

    @Override
    public Payment query(long id) {
        Payment payment = payDao.query(id);
        return payment;
    }
}
