package com.havells.platform.repositories;

import com.havells.platform.model.ApplicationKeyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationKeyRepository extends JpaRepository<ApplicationKeyModel, Long> {
	ApplicationKeyModel findByDeviceId(String deviceId);

}