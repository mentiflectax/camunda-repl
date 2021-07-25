package com.dpisarenko.camundarepl;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DynamicDelegateTest {
    @Test
    public void givenClojureFunctionName_whenExecute_thenSetVariable() throws Exception {
        // Given
        final ClojureRepl clojureRepl = new ClojureRepl();
        clojureRepl.init();

        final DynamicDelegate dynamicDelegate = new DynamicDelegate(new ClojureBackedService());
        final DelegateExecution delEx = mock(DelegateExecution.class);
        when(delEx.getVariable("cljfn")).thenReturn("test");

        // When
        dynamicDelegate.execute(delEx);

        // Then
        verify(delEx).setVariable("Heyo", "This was set in Clojure");
    }
}