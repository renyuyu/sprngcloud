package org.lixue;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 李雪 on 2017-08-26.
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping ("/consumer")
    public String consumerHi() {
        return helloWorldService.consumerHi();
    }
}
