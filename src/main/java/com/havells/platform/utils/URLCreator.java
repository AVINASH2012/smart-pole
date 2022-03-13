package com.havells.platform.utils;

import com.havells.platform.common.MessageConstants;

public class URLCreator {

	public URLCreator() {
	}
	
	public static String generateCommandURL(String deviceId) {
		//api/devices/{device_queue_item.dev_eui}/queue
		return MessageConstants.API_URI.concat("/devices/").concat(deviceId).concat("/queue");
	}

}
