package com.havells.platform.provider.chirpstack.commandexecutor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.havells.platform.common.MessageConstants;
import com.havells.platform.model.DeviceDB;
import com.havells.platform.provider.chirpstack.client.request.DeviceQueueItem;
import com.havells.platform.provider.chirpstack.client.request.RootDeviceQueueItem;
import com.havells.platform.provider.chirpstack.client.response.DeviceOperationResponse;
import com.havells.platform.repositories.DeviceRepository;

@Configuration
public class Scheduler {
	
	@Autowired
	private DeviceRepository deviceRepository;

	public Scheduler(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void scheduleFixedDelayTask() {
		List<DeviceDB> deviceDB= deviceRepository.findAll();
		/*
		 * This code block is only for testing purpose
		 */
		//runCommands("00d0859b629bfa32");//deviceDB.get(i).getDevEUI());
		
		/*
		 * The Test block ends here and uncomment the for loop in deployment
		 */
		for(int i=0;i<deviceDB.size();i++) {
			runCommands(deviceDB.get(i).getDevEUI());
		}
	    System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
	}
	
	@Async
	private void runCommands(String deviceEui) {
		Command command= new Command();
		DeviceInfo deviceInfo= new DeviceInfo();
		SolarGraph solarGraph=new SolarGraph();
		SystemConfig systemConfig = new SystemConfig();
		SystemParameter systemParameter = new SystemParameter();
		try {
		deviceInfo.execute(command.getDeviceInfo(), deviceEui);
		solarGraph.execute(command.getSolarGraph(), deviceEui);
		systemConfig.execute(command.getSystemConfig(), deviceEui);
		systemParameter.execute(command.getSystemParameter(), deviceEui);
		
		}
		catch(Exception e) {
			
		}
		
	}
}
