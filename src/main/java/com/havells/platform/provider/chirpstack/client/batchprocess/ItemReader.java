package com.havells.platform.provider.chirpstack.client.batchprocess;

import com.havells.platform.repositories.DeviceRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ItemRead implements ItemReader {
    @Autowired
    DeviceRepository deviceRepository;
    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println(deviceRepository.count());
        return "Hello";
    }
}
