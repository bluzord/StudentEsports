package com.studentesports.backend.services.impl;

import com.studentesports.backend.exceptions.ApplicationsNotFoundException;
import com.studentesports.backend.exceptions.NewsElementNotFoundException;
import com.studentesports.backend.models.News;
import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.respositories.ApplicationRepository;
import com.studentesports.backend.respositories.applications.*;
import com.studentesports.backend.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ApplicationCS2> getApplicationsCS2() {
        List<ApplicationCS2> applications = applicationCS2Repository.findAll();
        if (applications.isEmpty()) throw new ApplicationsNotFoundException("Заявки не найдены");
        return applications;
    }

    @Override
    public List<ApplicationDOTA> getApplicationsDOTA() {
        List<ApplicationDOTA> applications = applicationDOTARepository.findAll();
        if (applications.isEmpty()) throw new ApplicationsNotFoundException("Заявки не найдены");
        return applications;
    }

    @Override
    public List<ApplicationLOL> getApplicationsLOL() {
        List<ApplicationLOL> applications = applicationLOLRepository.findAll();
        if (applications.isEmpty()) throw new ApplicationsNotFoundException("Заявки не найдены");
        return applications;
    }

    @Override
    public List<ApplicationVLR> getApplicationsVLR() {
        List<ApplicationVLR> applications = applicationVLRRepository.findAll();
        if (applications.isEmpty()) throw new ApplicationsNotFoundException("Заявки не найдены");
        return applications;
    }

    @Override
    public List<ApplicationTEKKEN> getApplicationsTEKKEN() {
        List<ApplicationTEKKEN> applications = applicationTEKKENRepository.findAll();
        if (applications.isEmpty()) throw new ApplicationsNotFoundException("Заявки не найдены");
        return applications;
    }

    @Override
    public List<ApplicationSC> getApplicationsSC() {
        List<ApplicationSC> applications = applicationSCRepository.findAll();
        if (applications.isEmpty()) throw new ApplicationsNotFoundException("Заявки не найдены");
        return applications;
    }

    @Override
    public void deleteApplicationById(int id) {
        Application application = applicationRepository.findById(id).orElseThrow();
        String game = application.getGame();
        switch (game) {
            case "CS2" -> {
                ApplicationCS2 applicationCS2 = applicationCS2Repository.findById(id).orElseThrow(() -> new ApplicationsNotFoundException("Заявка не найдена"));
                applicationCS2Repository.delete(applicationCS2);
            }
            case "DOTA" -> {
                ApplicationDOTA applicationDOTA = applicationDOTARepository.findById(id).orElseThrow(() -> new ApplicationsNotFoundException("Заявка не найдена"));
                applicationDOTARepository.delete(applicationDOTA);
            }
            case "LOL" -> {
                ApplicationLOL applicationLOL = applicationLOLRepository.findById(id).orElseThrow(() -> new ApplicationsNotFoundException("Заявка не найдена"));
                applicationLOLRepository.delete(applicationLOL);
            }
            case "VLR" -> {
                ApplicationVLR applicationVLR = applicationVLRRepository.findById(id).orElseThrow(() -> new ApplicationsNotFoundException("Заявка не найдена"));
                applicationVLRRepository.delete(applicationVLR);
            }
            case "SC" -> {
                ApplicationSC applicationSC = applicationSCRepository.findById(id).orElseThrow(() -> new ApplicationsNotFoundException("Заявка не найдена"));
                applicationSCRepository.delete(applicationSC);
            }
            case "TEKKEN" -> {
                ApplicationTEKKEN applicationTEKKEN = applicationTEKKENRepository.findById(id).orElseThrow(() -> new ApplicationsNotFoundException("Заявка не найдена"));
                applicationTEKKENRepository.delete(applicationTEKKEN);
            }
        }
    }

}
