package com.example.demo;

import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.reactivestreams.client.ChangeStreamPublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import org.bson.Document;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ReactiveChangeStreamOperation;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TestController {

    private final MongoClient client;
    private final ReactiveMongoTemplate template;

    public TestController(MongoClient client, ReactiveMongoTemplate template) {
        this.client = client;
        this.template = template;
    }

    @GetMapping
    public Flux<ChangeStreamEvent<TestModel>> getStream() {
        ReactiveChangeStreamOperation.ReactiveChangeStream<TestModel>
                testModelReactiveChangeStream = template.changeStream(TestModel.class);
        Flux<ChangeStreamEvent<TestModel>> listen = testModelReactiveChangeStream.listen();
        ChangeStreamPublisher<Document> watch = client.watch();
        watch.subscribe(new Subscriber<ChangeStreamDocument<Document>>() {

            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(ChangeStreamDocument<Document> documentChangeStreamDocument) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });
        return listen;
    }

    @GetMapping("create")
    public void createMessage() {

    }
}
