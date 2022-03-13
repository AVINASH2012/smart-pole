package com.havells.platform.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.havells.platform.common.MessageConstants;
import com.havells.platform.exception.ChirpStackClientException;
import com.havells.platform.model.DeviceDB;
import com.havells.platform.request.DeviceOperations;
import com.havells.platform.response.DeviceOprationResponse;
import com.havells.platform.response.GatewayAndDevices;
import com.havells.platform.service.AllGatewayAndDevices;
import com.havells.platform.service.DeviceServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/devices")
public class DeviceController {

	@Autowired
	private DeviceServiceImpl deviceServiceImpl;

	@Autowired
	private AllGatewayAndDevices allGatewayAndDevices;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	final String deviceURI = MessageConstants.API_URI + MessageConstants.DEVICES_PRIMARY;

	private HttpHeaders header = new HttpHeaders();

	@ApiResponses({
			@ApiResponse(code = 200, message = "Get all device details success response", response = Object.class),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "API service not found") })
	@ApiOperation(value = "All device details", notes = "API to get list of device details based on application ID")

	@GetMapping("")
	public GatewayAndDevices getAllDevices(@RequestParam String limit, @RequestParam String applicationID) {
		logger.info(this.getClass().getName() + "Limit -> " + limit + "Application id- >" + applicationID);
		// devices = deviceServiceImpl.getAllDevicesByApplicationID(limit,
		// applicationID);
		System.out.println("HELLO METRICS");
		return allGatewayAndDevices.getGatewayAndDevices();
		// return null;

	}
	@DeleteMapping("")
	public String deleteAll() {
		deviceServiceImpl.deleteAllDevice();
		return "Deleted";
	}
	
	@ApiResponses({ @ApiResponse(code = 200, message = "Register devices success response", response = Object.class),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "API service not found") })
	@ApiOperation(value = "Register multiple devices", notes = "API to register multiple devices")
	@CrossOrigin(origins = "*")
	@PostMapping("/register")
	public String registerDevice(@Valid @RequestBody List<DeviceDB> request) throws ChirpStackClientException {
		logger.debug(request.toString());
		System.out.println(request.size());
//			CompletableFuture.runAsync(()->{
//				try {
		deviceServiceImpl.addDevice(request);
//				} catch (ChirpStackClientException e) {
//					e.printStackTrace();
//				}
//			});
		// CompletableFuture<List<DeviceDB>> devices =
		// deviceServiceImpl.saveDeviceByThread(request);
		return "Device Onboarding Started";
	}
	
	@PostMapping("/addtodb")
	public List<DeviceDB> addtodb(@Valid @RequestBody List<DeviceDB> request) {
		logger.debug(request.toString());
		System.out.println(request.size());
		return deviceServiceImpl.addDeviceToDB(request);
	}

	@ApiResponses({
			@ApiResponse(code = 200, message = "Device operations success response", response = DeviceOprationResponse.class),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "API service not found") })
	@ApiOperation(value = "Device ON and OFF Oprations", notes = "API to switch ON and OFF the device")
	@PostMapping("/operation")
	public HttpStatus deviceOperation(@Valid @RequestBody DeviceOperations request) {

//		final String deviceOperationURL = deviceURI + "/" + request.getDeviceQueueItem().getDevEUI() + "/queue";
//		HttpEntity<DeviceOperations> entityReq = new HttpEntity<DeviceOperations>(request, setHeader());
//		try {
//			ResponseEntity<DeviceOperationResponse> deviceOperationsResponse = restTemplate.exchange(deviceOperationURL,
//					HttpMethod.POST, entityReq, DeviceOperationResponse.class);
//			return deviceOperationsResponse;
//		} catch (RestClientException e) {
//			logger.error(e.getLocalizedMessage(), e);
//
//		}
		return deviceServiceImpl.deviceOprations(request);
	}

	private HttpHeaders setHeader() {
		header.add("Grpc-Metadata-Authorization", MessageConstants.APIKey);
		return header;
	}

	@ApiResponses({ @ApiResponse(code = 200, message = "Register devices success response", response = Object.class),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "API service not found") })
	@ApiOperation(value = "Register multiple devices", notes = "API to register multiple devices")

	@GetMapping("/status")
	public String registerDevices() {
		return "Hello World";

	}

}
