package com.rtds.RTDS.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class RTDIS {

    @Value("${api_url}")
    private  String API_URL;
    @Value("${topic_name}")
    private  String KAFKA_TOPIC;


    @Autowired
    private KafkaTemplate<String,String> kafkaProducer;

    private ScheduledExecutorService scheduler;

    public void startStreaming() {
        scheduler = Executors.newSingleThreadScheduledExecutor();

       scheduler.scheduleAtFixedRate(this::stream, 0, 10, TimeUnit.SECONDS);
    }

    public void stopStreaming() {
        scheduler.shutdown();
    }

    public void stream() {
        WebClient webClient = WebClient.create();



        webClient.get()
                .uri(API_URL)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(data -> {
                    System.out.println("Received msg: " + data);
                    kafkaProducer.send(KAFKA_TOPIC, data);
                    System.out.println("Event sent to Kafka: " + data);
                });
    }


}
