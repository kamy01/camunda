package com.example.workflow.transaction;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import static com.example.workflow.insulin.common.InsulinConstants.INSULIN_VALUE;
import static com.example.workflow.insulin.common.InsulinConstants.PATIENT_ID;

@Component
public class TransactionProcess implements JavaDelegate {
    @Override
    public void execute(DelegateExecution context) throws Exception {
        int patientId = (int) context.getVariable(PATIENT_ID);
        int insulinValue = (int) context.getVariable(INSULIN_VALUE);
        System.out.format("Closing transaction with the insulin value  %d for patient %d  ",
                insulinValue,
                patientId);
        System.out.println();
    }
}
