package com.havells.platform.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.havells.platform.exception.ChirpStackClientException;
import com.havells.platform.model.GatewayRegistration;
import com.havells.platform.response.GatewayResponse;
import com.havells.platform.service.GatewayService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/gateways")
@CrossOrigin(origins = "*")
public class GatewayController {

	@Autowired
	private GatewayService gatewayService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@ApiResponses({
			@ApiResponse(code = 200, message = "Gateway registration success response", response = Object.class),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "API service not found") })
	@ApiOperation(value = "Gateway registration", notes = "API to register gateway")

	@PostMapping("/register")
	public GatewayResponse registerGateway(@Valid @RequestBody GatewayRegistration request)
			throws ChirpStackClientException {
		logger.debug(request.toString());

		return gatewayService.registerGateway(request);

	}
	
	   @DeleteMapping("")
		public String deleteAll() {
		   gatewayService.deleteAllKeys();
			return "Deleted";
		}

}
