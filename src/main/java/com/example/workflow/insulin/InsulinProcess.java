package com.example.workflow.insulin;

import org.apache.commons.lang3.RandomUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.example.workflow.insulin.common.InsulinConstants.INSULIN_VALUE;
import static com.example.workflow.insulin.common.InsulinConstants.PATIENT_ID;

@Component
public class InsulinProcess implements JavaDelegate {

    @Override
    public void execute(DelegateExecution context) throws Exception {
        Object patientId = context.getVariable(PATIENT_ID);
        if (patientId == null) {
            System.out.println("Patient not found, generating new");
            patientId = RandomUtils.nextInt(101, 200);
        }
        int insulinValue = getInsulinValue((int) patientId);
        context.setVariable(INSULIN_VALUE, insulinValue);
        context.setVariable(PATIENT_ID, patientId);
    }

    private int getInsulinValue(int patientId) {
        return RandomUtils.nextInt(1, 100);
    }
}
