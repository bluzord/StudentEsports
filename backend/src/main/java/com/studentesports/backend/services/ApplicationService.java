package com.studentesports.backend.services;

import com.studentesports.backend.models.applications.*;

import java.util.List;

public interface ApplicationService {

    public void createApplicationCS2(ApplicationCS2 application);
    public void createApplicationDOTA(ApplicationDOTA application);
    public void createApplicationLOL(ApplicationLOL application);
    public void createApplicationVLR(ApplicationVLR application);
    public void createApplicationTEKKEN(ApplicationTEKKEN application);
    public void createApplicationSC(ApplicationSC application);

    public List<ApplicationCS2> getApplicationsCS2();
    public List<ApplicationDOTA> getApplicationsDOTA();
    public List<ApplicationLOL> getApplicationsLOL();
    public List<ApplicationVLR> getApplicationsVLR();
    public List<ApplicationTEKKEN> getApplicationsTEKKEN();
    public List<ApplicationSC> getApplicationsSC();
}
