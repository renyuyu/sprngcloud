package org.lixue;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by 李雪 on 2017-08-26.
 */
@Service
public class HelloWorldService {

    private Random random = new Random();

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand (fallbackMethod = "consumerFallback")
    public String consumerHi() {
        int randomInt = random.nextInt(10);
        if (randomInt < 8) {  //模拟调用失败情况
            throw new RuntimeException("调用服务失败！");
        } else {
            return restTemplate.getForObject("http://ORG.LIXUE.HELLOWORLD/hi", String.class);
        }
    }

    private String consumerFallback() {
        return "fallback";
    }
}
