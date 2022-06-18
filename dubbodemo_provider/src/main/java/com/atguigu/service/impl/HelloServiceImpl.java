package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.service.HelloService;
import org.springframework.transaction.annotation.Transactional;

/**
 * title:
 *
 * @Author xu
 * @Date 2022/06/18 14:27
 * @FileName: HelloServiceImpl
 */
@Service(interfaceClass = HelloService.class)//Dubbo框架提供的注解 发布服务
@Transactional
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "8081:hello " + name;
    }
}
