package com.dpisarenko.camundarepl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MathController {
    private final ClojureBackedService backend;

    MathController(final ClojureBackedService backend) {
        this.backend = backend;
    }

    @PostMapping
    public BigDecimal add(final BigDecimal a, final BigDecimal b) {
        return backend.add(a, b);
    }
}
