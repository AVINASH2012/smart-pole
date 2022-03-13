package com.havells.platform.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.havells.platform.model.DeviceDto;
import com.havells.platform.model.DeviceStatus;
import com.havells.platform.model.DeviceStatusDto;
import com.havells.platform.model.DeviceStatusResponse;
import com.havells.platform.model.GatewayAndDevicesStatus;
import com.havells.platform.repositories.DeviceStatusRepository;
import com.havells.platform.utils.*;

@Transactional
@Service
public class DeviceStatusService{
	
	  @Autowired
	    private DeviceStatusRepository deviceStatusRepository;
	  
		
		@Autowired
		private ModelMapper modelMapper;

	public DeviceStatusService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void createRecord(String deviceId,String type) {
		System.out.println(" saving device status "+deviceId);
		DeviceStatus deviceStatus = new DeviceStatus(deviceId, true, false, "inactive",type);
		deviceStatusRepository.save(deviceStatus);
	}
	public GatewayAndDevicesStatus getStatus() {
		DeviceStatusResponse devices=getStatusByType("light");
		DeviceStatusResponse gateway=getStatusByType("gateway");
		GatewayAndDevicesStatus gatewayAndDevicesStatus= new GatewayAndDevicesStatus();
		gatewayAndDevicesStatus.setDevices(devices);
		gatewayAndDevicesStatus.setGateway(gateway);
		return gatewayAndDevicesStatus;
	}
	public DeviceStatusResponse getStatusByType(String type) {
		List<DeviceStatusDto>  devices=deviceStatusRepository.getActiveStatusByType(type);
		devices.forEach((obj)->{
			System.out.println(obj.getDeviceId());
			updateStatus(obj);});
		DeviceStatusResponse deviceStatusResponse= new DeviceStatusResponse();
		deviceStatusResponse.setActive(deviceStatusRepository.countActiveDevices(type));
		deviceStatusResponse.setConnected(deviceStatusRepository.countConnectedDevices(type));
		deviceStatusResponse.setInactive(deviceStatusRepository.countInactiveDevices(type));
		deviceStatusResponse.setMaintainance(deviceStatusRepository.countDeviceUnderMaintainance(type));
		deviceStatusResponse.setShutdown(deviceStatusRepository.countShutdownDevices(type));
		deviceStatusResponse.setType(type);
		System.out.println(deviceStatusResponse.toString());
		return deviceStatusResponse;
	}
	public void updateStatus(DeviceStatusDto device) {
//		SimpleDateFormat sdf = new SimpleDateFormat("YYY-MM-DD HH:mm:ss.SS");
//		String currentDate=sdf.format(new Date());
		LocalDateTime datetime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
		String currentDate = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(datetime);
		String deviceLastUpdatedTime=device.getUpdated().toString();
		System.out.println(currentDate);
		System.out.println(deviceLastUpdatedTime);
		
		long differenceInMinutes=DateDifference.findDifferenceInMinutes(deviceLastUpdatedTime,currentDate);
		long differenceInDays=DateDifference.findDifferenceInDays(deviceLastUpdatedTime,currentDate);
		long differenceInYears=DateDifference.findDifferenceInYears(deviceLastUpdatedTime,currentDate);
		long differenceInHours=DateDifference.findDifferenceInHours(deviceLastUpdatedTime,currentDate);
		System.out.println(differenceInMinutes);
		if(differenceInMinutes >5) {
			Optional<DeviceStatus> deviceStatus = deviceStatusRepository.findById(device.getDeviceId());
			deviceStatus.get().setConnected(false);
			deviceStatus.get().setCurrent("inactive");
			deviceStatusRepository.save(deviceStatus.get());
		}
		else if(differenceInHours >0 || differenceInDays>0 || differenceInYears>0) {
			Optional<DeviceStatus> deviceStatus = deviceStatusRepository.findById(device.getDeviceId());
			deviceStatus.get().setConnected(false);
			deviceStatus.get().setCurrent("inactive");
			deviceStatusRepository.save(deviceStatus.get());
		}
	}
}
