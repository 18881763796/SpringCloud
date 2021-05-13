package com.alice.cloud.controller;

import com.alice.cloud.entities.CommonRuselt;
import com.alice.cloud.entities.Payment;
import com.alice.cloud.service.IPayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/payMent")
public class PayMentController {

    @Value("${server.port}")
    private String prot;

    @Resource
    private DiscoveryClient discoveryClient;

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
        return new CommonRuselt(200,"查询成功，服务端口："+prot,payment);
    }

    @GetMapping("/queryService")
    public CommonRuselt queryService(){
        Map<String,List> map = new HashMap<>();
        List<String> services = discoveryClient.getServices();
        map.put("Services",services);
        int i = 0;
        for (String service:services) {
            i++;
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            map.put("instance"+i,instances);
        }
        return new CommonRuselt(200,"查询成功！",map);
    }

}
