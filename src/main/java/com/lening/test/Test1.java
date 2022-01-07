package com.lening.test;

import com.lening.utils.ResultInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
/**
 * 本类作者： 石永栋
 * 创建时间为：2021/12/30 16:21
 * 本类作用： xxx
 */

public class Test1 {

//     @Bean
//     public RestTemplate restTemplate(){
//          return  new RestTemplate();
//     }

//     @Autowired
//     private RestTemplate restTemplate;

     @Test
     public void httpa(){
          RestTemplate restTemplate = new RestTemplate();
          ResultInfo forObject = restTemplate.getForObject("http://localhost:9990/test/test11", ResultInfo.class);
          System.out.println(forObject.getMsg());
     }




}
