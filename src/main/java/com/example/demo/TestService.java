package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class TestService {

    public Mono<Void> test() {
        log.info("test");
        return Mono.empty();
    }
}
