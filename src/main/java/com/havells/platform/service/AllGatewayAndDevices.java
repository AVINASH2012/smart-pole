package com.havells.platform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.havells.platform.model.DeviceDto;
import com.havells.platform.model.DeviceDB;
import com.havells.platform.model.DeviceStatus;
import com.havells.platform.model.DeviceStatusResponse;
import com.havells.platform.model.GatewayDto;
import com.havells.platform.model.GatewayRegistration;
import com.havells.platform.repositories.DeviceRepository;
import com.havells.platform.repositories.DeviceStatusRepository;
import com.havells.platform.repositories.GatewayRepository;
import com.havells.platform.response.GatewayAndDevices;

@Service
public class AllGatewayAndDevices {
	
	@Autowired
	private GatewayRepository gatewayRepository;

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private DeviceStatusRepository deviceStatusRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public GatewayAndDevices getGatewayAndDevices() {
		List<DeviceDB> devices = deviceRepository.findAll();
		List<DeviceDto> allDevices = new ArrayList<>();
		System.out.println(devices.size());
		devices.forEach((obj)->{
			DeviceDto deviceDto= modelMapper.map(obj, DeviceDto.class);
			String deviceId=obj.getDevEUI();
			Optional<DeviceStatus> deviceStatus=deviceStatusRepository.findById(deviceId);
			deviceDto.setConnected(deviceStatus.get().isConnected());
			String currentStatus=deviceStatus.get().getCurrent();
			deviceDto.setCurrentStatus(currentStatus);
			if(currentStatus.equals("active")) {
				deviceDto.setOn(true);
			}
			else {
				deviceDto.setOn(false);
			}
			allDevices.add(deviceDto);
		});
		System.out.println(allDevices.size());
		List<GatewayRegistration> gateways = gatewayRepository.findAll();
		List<GatewayDto> allGateway = new ArrayList<>();
		gateways.forEach((obj)->{
			GatewayDto gatewayDto= modelMapper.map(obj, GatewayDto.class);
			String deviceId=obj.getGatewayProfileID();
			Optional<DeviceStatus> deviceStatus=deviceStatusRepository.findById(deviceId);
			gatewayDto.setConnected(deviceStatus.get().isConnected());
			gatewayDto.setCurrentStatus(deviceStatus.get().getCurrent());
			allGateway.add(gatewayDto);
		});
		GatewayAndDevices gatewayAndDevices = new GatewayAndDevices();
		gatewayAndDevices.setDevices(allDevices);
		gatewayAndDevices.setGateway(allGateway);
		return gatewayAndDevices;		
	}
	
}
