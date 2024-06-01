package com.studentesports.backend.services.impl;

import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.respositories.ApplicationRepository;
import com.studentesports.backend.respositories.applications.*;
import com.studentesports.backend.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationCS2Repository applicationCS2Repository;
    private final ApplicationDOTARepository applicationDOTARepository;
    private final ApplicationLOLRepository applicationLOLRepository;
    private final ApplicationSCRepository applicationSCRepository;
    private final ApplicationTEKKENRepository applicationTEKKENRepository;
    private final ApplicationVLRRepository applicationVLRRepository;


    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository, ApplicationCS2Repository applicationCS2Repository, ApplicationDOTARepository applicationDOTARepository, ApplicationLOLRepository applicationLOLRepository, ApplicationSCRepository applicationSCRepository, ApplicationTEKKENRepository applicationTEKKENRepository, ApplicationVLRRepository applicationVLRRepository) {
        this.applicationRepository = applicationRepository;
        this.applicationCS2Repository = applicationCS2Repository;
        this.applicationDOTARepository = applicationDOTARepository;
        this.applicationLOLRepository = applicationLOLRepository;
        this.applicationSCRepository = applicationSCRepository;
        this.applicationTEKKENRepository = applicationTEKKENRepository;
        this.applicationVLRRepository = applicationVLRRepository;
    }


    @Override
    public void createApplicationCS2(ApplicationCS2 application) {
        this.applicationCS2Repository.save(application);
    }

    @Override
    public void createApplicationDOTA(ApplicationDOTA application) {
        this.applicationDOTARepository.save(application);
    }

    @Override
    public void createApplicationLOL(ApplicationLOL application) {
        this.applicationLOLRepository.save(application);
    }

    @Override
    public void createApplicationVLR(ApplicationVLR application) {
        this.applicationVLRRepository.save(application);
    }

    @Override
    public void createApplicationTEKKEN(ApplicationTEKKEN application) {
        this.applicationTEKKENRepository.save(application);
    }

    @Override
    public void createApplicationSC(ApplicationSC application) {
        this.applicationSCRepository.save(application);
    }
}
