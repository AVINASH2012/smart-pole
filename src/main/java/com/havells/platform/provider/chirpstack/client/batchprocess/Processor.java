package com.havells.platform.provider.chirpstack.client.batchprocess;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<String, String> {


    public Processor() {
    }

    @Override
    public String process(String user) throws Exception {
        System.out.println("Hello from processor");
        return "Hello processor";
    }
}