package com.dpisarenko.camundarepl;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class DynamicDelegate implements JavaDelegate {
    private final ClojureBackedService backend;

    public DynamicDelegate(final ClojureBackedService backend) {
        this.backend = backend;
    }

    @Override
    public void execute(DelegateExecution delEx) throws Exception {
        final String clojureFunctionName = (String) delEx.getVariable("cljfn");
        backend.runClojureCode(delEx, clojureFunctionName);
    }
}
