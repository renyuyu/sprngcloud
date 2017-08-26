package org.lixue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 李雪 on 2017-08-26.
 */
@RestController
public class HelloWorldController {

    @Value ("${server.port}")
    private int port;

    @RequestMapping ("/hi")
    public String hi() {
        return "Hello World hi " + port;
    }
}
