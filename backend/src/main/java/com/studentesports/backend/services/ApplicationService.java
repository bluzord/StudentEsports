package com.studentesports.backend.services;

import com.studentesports.backend.models.applications.*;

public interface ApplicationService {

    public void createApplicationCS2(ApplicationCS2 application);
    public void createApplicationDOTA(ApplicationDOTA application);
    public void createApplicationLOL(ApplicationLOL application);
    public void createApplicationVLR(ApplicationVLR application);
    public void createApplicationTEKKEN(ApplicationTEKKEN application);
    public void createApplicationSC(ApplicationSC application);
}
