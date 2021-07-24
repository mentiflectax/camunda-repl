package com.dpisarenko.camundarepl;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ClojureRepl {
    @PostConstruct
    public void init() {

        final IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("com.dpisarenko.camundarepl"));

    }
    public void destroy() {

    }
}
