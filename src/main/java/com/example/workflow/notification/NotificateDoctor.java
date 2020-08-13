package com.example.workflow.notification;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import static com.example.workflow.insulin.common.InsulinConstants.INSULIN_VALUE;
import static com.example.workflow.insulin.common.InsulinConstants.PATIENT_ID;

public class NotificateDoctor implements JavaDelegate {
    @Override
    public void execute(DelegateExecution context) throws Exception {
        int patientId = (int) context.getVariable(PATIENT_ID);
        int insulinvALUE = (int) context.getVariable(INSULIN_VALUE);
        System.out.format("Notificating doctor for patient %d because insulin value is %d",
                patientId,
                insulinvALUE);
        System.out.println();

    }
}
