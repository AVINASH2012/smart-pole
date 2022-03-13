 

package com.havells.platform.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havells.platform.model.GatewayAndDevicesStatus;
import com.havells.platform.service.DeviceStatusService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/status")
public class DeviceStatusController {

	@Autowired
	private DeviceStatusService deviceStatusService;


	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@ApiResponses({
			@ApiResponse(code = 200, message = "Get all device status details success response", response = Object.class),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "API service not found") })
	@ApiOperation(value = "All device status details", notes = "API to get device status details")

	@GetMapping("")
	public GatewayAndDevicesStatus getAllDevices() {
		return deviceStatusService.getStatus();
	}

}
