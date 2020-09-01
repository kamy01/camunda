package com.example.workflow.insulin.common;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageProcessController {

    private RuntimeService camunda;

    @Autowired
    public MessageProcessController(RuntimeService camunda) {
        this.camunda = camunda;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void sayHelloWorldPOST(String text) {
        camunda.createMessageCorrelation("messageName")
                .processInstanceBusinessKey("businessKey")
                .setVariable("name", "value")
                .correlateStartMessage();
    }
}
