package com.Ilvcode;
import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Ilvcode.service.impl.UserPoolAccessService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
    	BasicConfigurator.configure();
        SpringApplication.run(Application.class, args);
    }
}
