package com.dpisarenko.camundarepl;

import clojure.java.api.Clojure;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ClojureBackedService {
    BigDecimal add(BigDecimal a, BigDecimal b) {
        return (BigDecimal) Clojure.var("com.dpisarenko.camundarepl", "add").invoke(a, b);
    }
}
