package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * title:
 *
 * @Author xu
 * @Date 2022/06/18 14:46
 * @FileName: HelloController
 */
@Controller
@RequestMapping("/demo")
public class HelloController {
    //调用远程服务 RPC
    @Reference(loadbalance = "roundrobin")//使用dubbo框架提供的依赖注入注解，而不是Spring框架提供的@Autowired注解
    private HelloService helloService;//生成JDK动态代理对象，实现RPC。封装Socker/ServerSocker编程。

    @RequestMapping("/hello")
    @ResponseBody
    public String getName(String name) {
        //远程调用
        // HttpMessageConverter  消息转换器
        // ==>> StringHttpMessageConverter ===>>  out.print()
        // ==>> MappingJackson2HttpMessageConverter  ==>>   toJsonString()
        String result = helloService.sayHello(name);
        System.out.println("result = " + result);
        return result;//@ResponseBody注解：直接返回字符串到页面上，无需视图解析；如果是类对象，会变成JSON数据返回
    }
}
