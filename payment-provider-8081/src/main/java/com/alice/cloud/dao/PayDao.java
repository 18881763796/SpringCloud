package com.alice.cloud.dao;

import com.alice.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {

    /*
    * 增删改查
    * */

    public void insert(Payment payment);

    public void delete(long id);

    public Payment update(Payment payment);

    public Payment query(long id);
}
