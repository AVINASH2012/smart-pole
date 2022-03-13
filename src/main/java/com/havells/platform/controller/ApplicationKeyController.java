package com.havells.platform.controller;

import com.havells.platform.model.ApplicationKeyModel;
import com.havells.platform.request.ApplicationKeys;
import com.havells.platform.service.ApplicationKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.havells.platform.provider.chirpstack.client.response.DeviceOperationResponse;
import com.havells.platform.request.ApplicationKeys;
import com.havells.platform.request.DeviceOperations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/keys")
public class ApplicationKeyController {

	private Logger logger = LoggerFactory.getLogger(ApplicationKeyController.class);
	
    @Autowired
    private ApplicationKeyService applicationKeyService;
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<ApplicationKeyModel> addKey(@RequestBody ApplicationKeys applicationKeys){
        //try{
            System.out.println(" CHECK "+ applicationKeys);
            System.out.println(applicationKeys.getApplicationKeyList().size());
            List<ApplicationKeyModel> applicationKeyModel= applicationKeyService.saveApplicationKeys(applicationKeys);
            return new ResponseEntity(applicationKeyModel, HttpStatus.resolve(201));
           //return responseEntity;
//        }
//        catch(Exception e){
//            System.out.println(e);
//            return null;
//        }
    }
    
    @DeleteMapping("")
	public String deleteAll() {
    	applicationKeyService.deleteAllKeys();
		return "Deleted";
	}

}
