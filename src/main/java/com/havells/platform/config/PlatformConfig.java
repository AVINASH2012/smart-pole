package com.havells.platform.config;

import java.time.Duration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.havells.platform.common.HttpConstants;
import com.havells.platform.exception.HttpResponseErrorHandler;
import com.havells.platform.provider.chirpstack.client.ChirpStackClient;
import com.havells.platform.provider.chirpstack.client.GatewayClient;
import com.havells.platform.provider.chirpstack.client.request.DeviceRequest;

@Configuration
@ComponentScan
public class PlatformConfig {
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder)
    {
        Duration connectTimeout = Duration.ofMillis(HttpConstants.CONNECTION_TIME_OUT) ;
		Duration readTimeout = Duration.ofMillis(HttpConstants.READ_TIME_OUT);
		return restTemplateBuilder
           .setConnectTimeout(connectTimeout)
           .errorHandler((ResponseErrorHandler) new HttpResponseErrorHandler())
           .interceptors(new HttpReqInterceptor())
           .setReadTimeout(readTimeout)
           .build();
    }
	
	@Bean
	public ChirpStackClient chirpstackClient() {
		return new ChirpStackClient();
	}

	@Bean
	public DeviceRequest deviceRequest(){ return new DeviceRequest();}
	
	@Bean
	public GatewayClient gatewayRegistration() {
		return new GatewayClient();
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
