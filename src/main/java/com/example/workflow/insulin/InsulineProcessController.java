package com.example.workflow.insulin;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.variable.Variables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insulin")
public class InsulineProcessController {

    private ProcessEngine camunda;

    @Autowired
    public InsulineProcessController(ProcessEngine camunda) {
        this.camunda = camunda;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void sayHelloWorldPOST(String text) {
        camunda.getRuntimeService().startProcessInstanceByKey(//
                "checkInsulin");
    }


}
