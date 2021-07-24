package com.dpisarenko.camundarepl;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class ClojureRepl {
    @PostConstruct
    public void init() {

        final IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("com.dpisarenko.camundarepl"));
        Clojure.var("clojure.core.server", "start-server").invoke(
                Clojure.read("{:port 5555 :name spring-repl :accept clojure.core.server/repl}")
        );

    }

    @PreDestroy
    public void destroy() {
        Clojure.var("clojure.core.server", "stop-server").invoke(
                Clojure.read("{:name spring-repl}")
        );
    }
}
