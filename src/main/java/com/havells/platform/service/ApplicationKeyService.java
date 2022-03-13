package com.havells.platform.service;

import com.havells.platform.model.ApplicationKeyModel;
import com.havells.platform.repositories.ApplicationKeyRepository;
import com.havells.platform.request.ApplicationKey;
import com.havells.platform.request.ApplicationKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ApplicationKeyService {

    @Autowired
    private ApplicationKeyRepository applicationKeyRepository;


    public ApplicationKeyService() {
    }

    public ApplicationKeyService(ApplicationKeyRepository applicationKeyRepository) {
        this.applicationKeyRepository = applicationKeyRepository;
    }

    public List<ApplicationKeyModel> saveApplicationKeys(ApplicationKeys applicationKeys) {
        List<ApplicationKeyModel> applicationKeyModels = new ArrayList<ApplicationKeyModel>();
        List<ApplicationKey> keys= applicationKeys.getApplicationKeyList();
        for (ApplicationKey key : keys) {
            ApplicationKeyModel applicationKeyModel = new ApplicationKeyModel();
        	applicationKeyModel.setDeviceId(key.getDeviceId());
            applicationKeyModel.setApplicationKey(key.getApplicationKey());
            applicationKeyModels.add(applicationKeyModel);
        }
        return applicationKeyRepository.saveAll(applicationKeyModels);
    }

	public void deleteAllKeys() {
		applicationKeyRepository.deleteAll();
		// TODO Auto-generated method stub
		
	}

}
