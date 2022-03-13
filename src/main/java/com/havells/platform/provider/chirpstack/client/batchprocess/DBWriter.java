package com.havells.platform.provider.chirpstack.client.batchprocess;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<String> {


    public DBWriter() {
    }

    @Override
    public void write(List<? extends String> list) throws Exception {
        System.out.println("Inside Writer");
    }
}
