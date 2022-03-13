package com.havells.platform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.havells.platform.model.DeviceDB;
import com.havells.platform.model.GatewayRegistration;
import com.havells.platform.request.GatewayRegRequest;

@Repository
public interface GatewayRepository extends JpaRepository<GatewayRegistration, Long> {
}
