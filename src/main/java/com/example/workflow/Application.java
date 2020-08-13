package com.example.workflow;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

  @Autowired
  private RuntimeService runtimeService;

  public static void main(String[] args) {
    SpringApplication.run(Application.class);

  }
  @PostConstruct
  public void after()
  {
   // runtimeService.startProcessInstanceByKey("medicalProcess");
  }

}