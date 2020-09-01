package com.example.workflow.insulin;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.history.HistoricActivityInstance;
import org.camunda.bpm.engine.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.workflow.insulin.common.InsulinConstants.INSULIN_VALUE;
import static com.example.workflow.insulin.common.InsulinConstants.PATIENT_ID;
import static com.example.workflow.insulin.common.InsulinConstants.REGENERATE_INSULIN;

@Component
public class InsulinProcess implements JavaDelegate {

    ProcessEngine engine;

    @Autowired
    public InsulinProcess(ProcessEngine engine) {
        this.engine = engine;
    }

    @Override
    public void execute(DelegateExecution context) throws Exception {
        boolean regenerate = (boolean) context.getVariable(REGENERATE_INSULIN);
        final List<HistoricActivityInstance> historicTaskInstanceList = engine.getHistoryService()
                .createHistoricActivityInstanceQuery()
                .finished()
                .processDefinitionId(context.getProcessDefinitionId()).finished().orderByHistoricActivityInstanceEndTime()
                .asc().list();

        if (regenerate) {
            System.out.println("Regenerating insulin for patient: " + context.getVariable(PATIENT_ID));
            context.setVariable(INSULIN_VALUE, InsulinGenerator.getInsulinValue(1));
        }

    }

}
