package com.leisucn.xa.newsc2c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by SL on 2017/4/6.
 */

@SpringBootApplication
@EnableAutoConfiguration
public class App {

    public static void main(String[] args){
        ApplicationContext context =
                SpringApplication.run(App.class);
    }
}
