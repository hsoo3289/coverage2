package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Autowired
    private TestService service;

    @Test
    void contextLoads() throws InterruptedException {
        Mono<Void> test = service.test();
        StepVerifier.create(test).verifyComplete();
    }

    @Test
    void failTest() {
        Mono<Void> test = service.test();
        StepVerifier.create(test).verifyComplete();
    }
}
