package com.alice.cloud.service;

import com.alice.cloud.entities.Payment;

public interface IPayMentService {

    public void insert(Payment payment);

    public void delete(long id);

    public Payment update(Payment payment);

    public Payment query(long id);
}
