package com.havells.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havells.platform.model.DeviceDB;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceDB, Long> {

}
