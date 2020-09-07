package com.example.workflow;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJms
public class Application {


  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

}