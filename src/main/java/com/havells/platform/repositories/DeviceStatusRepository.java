package com.havells.platform.repositories;

import com.havells.platform.model.DeviceStatus;
import com.havells.platform.model.DeviceStatusDto;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



public interface DeviceStatusRepository extends JpaRepository<DeviceStatus, String> {
	
//	@Query(value = "Update devicestatus set connected = case when 5 < ( SELECT (DATE_PART('day', created::timestamp - now()::timestamp) * 24 + DATE_PART('hour', created::timestamp - now()::timestamp)) * 60 +DATE_PART('minute', created::timestamp - now()::timestamp) FROM devicestatus where device_id = ?1) THEN false END, current = case when 5 < (SELECT (DATE_PART('day', created::timestamp - now()::timestamp) * 24 + DATE_PART('hour', created::timestamp - now()::timestamp)) * 60 + DATE_PART('minute', created::timestamp - now()::timestamp) FROM devicestatus where device_id = ?1) THEN 'inactive' END where device_id = ?1 RETURNING *")
//	DeviceStatus updateStatusOnCurrentTime(String deviceId);
	
	@Query(value="from DeviceStatus where current =  'active'")
	List<DeviceStatus> getActiveDevicesDetails();
	
	@Query(value="Select new com.havells.platform.model.DeviceStatusDto(ds.deviceId, ds.onboard,ds.connected,ds.current,ds.type,ds.created,ds.updated) from DeviceStatus ds where ds.current =  'active' and ds.type = :type")
	List<DeviceStatusDto> getActiveStatusByType(String type);
	
	@Query(value="Select count(*) from DeviceStatus where connected=true  and type = :type")
	int countConnectedDevices(String type);
	
	@Query(value="Select count(*) from DeviceStatus where current='active'  and type = :type")
	int countActiveDevices(String type);
	
	@Query(value="Select count(*) from DeviceStatus where current='inactive'  and type = :type")
	int countInactiveDevices(String type);
	
	@Query(value="Select count(*) from DeviceStatus where current='shutdown'  and type = :type")
	int countShutdownDevices(String type);
	
	@Query(value="Select count(*) from DeviceStatus where current='maintainance'  and type = :type")
	int countDeviceUnderMaintainance(String type);
	
}