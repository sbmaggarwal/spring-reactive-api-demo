package com.example.demo.controller;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FooController {

    @GetMapping(value = "/foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> foo() {
        Flux<String> randomNumber = Flux.fromStream(Stream.generate(() ->
            "{ Foo: " + BigDecimal.valueOf(Math.abs(new Random().nextLong())) + " }")
        ).delayElements(Duration.ofSeconds(1));

        return randomNumber;
    }
}
