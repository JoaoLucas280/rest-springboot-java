package com.JoaoLucas.spring_boot_application.Aula03.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(TestLogController.class);

    @GetMapping("/test")
    public String logMessage(){
        logger.debug("logMessage - DEBUG");
        logger.info("logMessage - INFO");
        logger.warn("logMessage - WARN");
        logger.error("logMessage - ERROR");
        return "Logs Generated Successfully";
    }

}
