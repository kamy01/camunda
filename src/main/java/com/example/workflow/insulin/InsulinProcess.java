package com.example.workflow.insulin;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.example.workflow.insulin.common.InsulinConstants.INSULIN_VALUE;
import static com.example.workflow.insulin.common.InsulinConstants.PATIENT_ID;
import static com.example.workflow.insulin.common.InsulinConstants.REGENERATE_INSULIN;

@Component
public class InsulinProcess implements JavaDelegate {

    @Override
    public void execute(DelegateExecution context) throws Exception {
        boolean regenerate = (boolean) context.getVariable(REGENERATE_INSULIN);
        if (regenerate) {
            System.out.println("Regenerating insulin for patient: " + context.getVariable(PATIENT_ID));
            context.setVariable(INSULIN_VALUE, InsulinGenerator.getInsulinValue(1));
        }

    }

}
