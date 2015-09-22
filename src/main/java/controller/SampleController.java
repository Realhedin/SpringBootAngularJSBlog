package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main class to run application
 *
 * Created by dkorolev on 9/22/15.
 */
@Configuration
@RestController
@ComponentScan
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/test")
    @ResponseBody
    String home() {
        return "hello, world!";
    }


    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}

