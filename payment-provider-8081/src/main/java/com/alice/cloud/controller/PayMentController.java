package com.alice.cloud.controller;

import com.alice.cloud.entities.CommonRuselt;
import com.alice.cloud.entities.Payment;
import com.alice.cloud.service.IPayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payMent")
public class PayMentController {

    @Resource
    private IPayMentService payMentService;

    @GetMapping("/queryPayMent/{id}")
    public CommonRuselt queryPayMent(@PathVariable long id){
        Payment payment = new Payment();
        try {
             payment = payMentService.query(id);
        } catch (Exception e) {
            log.error("查询出错");
            return new CommonRuselt(500,"服务器异常");
        }
        return new CommonRuselt(200,"查询成功！",payment);
    }

}
