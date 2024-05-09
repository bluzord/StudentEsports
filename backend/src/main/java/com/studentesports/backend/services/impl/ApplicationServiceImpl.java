package com.studentesports.backend.services.impl;

import com.studentesports.backend.models.Application;
import com.studentesports.backend.respositories.ApplicationRepository;
import com.studentesports.backend.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }


    @Override
    public void createApplication(Application application) {
        this.applicationRepository.save(application);
    }
}
