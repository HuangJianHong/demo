package com.example.demo.controller;

import com.example.demo.bean.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/index/")
public class IndexController {
    @Value(value = "${zy.secret}")
    private String value;

    @Value(value = "${zy.address}")
    private String address;

    @RequestMapping("test")
    public String index() {
        System.out.println("hello index...");
        return "hello spring boot";
    }

    @RequestMapping("find/{id}/{name}")
    public UserInfo find(@PathVariable Integer id, @PathVariable String  name){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setName(name);
        return  userInfo;
    }

    @RequestMapping("get")
    public Map<String, Object> get(@RequestParam String name){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("value", value);
        map.put("address", address);
        return map;
    }

}
