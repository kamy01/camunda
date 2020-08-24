package com.example.workflow.insulin;

import org.apache.commons.lang3.RandomUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import static com.example.workflow.insulin.common.InsulinConstants.INSULIN_VALUE;
import static com.example.workflow.insulin.common.InsulinConstants.PATIENT_ID;
import static com.example.workflow.insulin.common.InsulinConstants.REGENERATE_INSULIN;

public class GenerateInsulinProcess implements JavaDelegate {
    @Override
    public void execute(DelegateExecution context) throws Exception {
        Object patientId = context.getVariable(PATIENT_ID);
        if (patientId == null) {
            System.out.println("Patient not found, generating new");
            patientId = RandomUtils.nextInt(101, 200);
        } else {
            System.out.format("Patient %d exists", patientId);
            System.out.println();
        }
        int insulinValue = InsulinGenerator.getInsulinValue((Integer) patientId);
        context.setVariable(INSULIN_VALUE, insulinValue);
        context.setVariable(PATIENT_ID, patientId);
        context.setVariable(REGENERATE_INSULIN, false);
    }

}
