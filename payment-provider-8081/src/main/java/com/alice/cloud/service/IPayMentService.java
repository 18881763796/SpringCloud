package com.alice.cloud.service;

import com.alice.cloud.entities.Payment;

public interface IPayMentService {
    public Payment query(long id);
}
