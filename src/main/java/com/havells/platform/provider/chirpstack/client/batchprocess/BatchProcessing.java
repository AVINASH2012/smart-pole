package com.havells.platform.provider.chirpstack.client.batchprocess;

import com.havells.platform.model.DeviceDB;
import com.havells.platform.repositories.DeviceRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class BatchProcessing {

//    @Autowired
//    private DeviceRepository deviceRepository;
//
//    @Bean
//    public Job job(JobBuilderFactory jobBuilderFactory,
//                   StepBuilderFactory stepBuilderFactory,
//                   ItemReader<String> itemReader,
//                   ItemProcessor<String,String> itemProcessor,
//                   ItemWriter<String> itemWriter
//    ) {
//
//        Step step = stepBuilderFactory.get("Device-Health-Processing")
//                .<String, String>chunk(0)
//                .reader(itemReader)
//                .processor(itemProcessor)
//                .writer(itemWriter)
//                .build();
//
//
//        return jobBuilderFactory.get("Device-Health-Load")
//                .incrementer(new RunIdIncrementer())
//                .start(step)
//                .build();
//    }
}
