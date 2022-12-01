package com.example.demo.controller;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FooControllerTests {

    @Test
    void foo() {
        FooController controller = new FooController();
        StepVerifier.create(controller.foo())
            .expectNextMatches(str -> str.contains("Foo"))
            .expectNoEvent(Duration.ofMillis(1000))
            .expectNextMatches(str -> str.contains("Foo"))
            .expectNoEvent(Duration.ofMillis(1000))
            .thenCancel()
            .verify();
    }
}
