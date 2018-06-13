package com.zyl.learn02.controller;

import com.zyl.learn02.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({User.class})
public class MyController {
    @Value("${com.zyl.name}")
    private  String name;
    @Value("${com.zyl.age}")
    private int age;
    @Autowired
    User user;

    @RequestMapping(value = "getMyValue")
    public  String getMyValue(){
        return  name+":"+age;
    }
    @RequestMapping(value = "getConfigBean")
    public  String getConfigValue(){
        return  "my name is "+name+", I'm "+age+"years old";
    }
}
