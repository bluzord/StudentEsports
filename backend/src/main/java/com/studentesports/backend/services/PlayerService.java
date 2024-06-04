package com.studentesports.backend.services;

import com.studentesports.backend.DTO.FreePlayerDTO;
import com.studentesports.backend.DTO.PlayerDTO;
import com.studentesports.backend.DTO.playersGAME.*;
import com.studentesports.backend.models.applications.*;
import com.studentesports.backend.models.players.*;

import java.util.List;

public interface PlayerService {
    List<PlayerDTO> getPlayers();


    public void createPlayerCS2(ApplicationCS2 application);
    public void createPlayerDOTA(ApplicationDOTA application);
    public void createPlayerLOL(ApplicationLOL application);
    public void createPlayerVLR(ApplicationVLR application);
    public void createPlayerTEKKEN(ApplicationTEKKEN application);
    public void createPlayerSC(ApplicationSC application);

    public List<PlayerCS2DTO> getPlayersCS2();
    public List<PlayerDOTADTO> getPlayersDOTA();
    public List<PlayerLOLDTO> getPlayersLOL();
    public List<PlayerVLRDTO> getPlayersVLR();
    public List<PlayerTEKKENDTO> getPlayersTEKKEN();
    public List<PlayerSCDTO> getPlayersSC();

    public List<FreePlayerDTO> getFreePlayersCS2();
    public List<FreePlayerDTO> getFreePlayersDOTA();
    public List<FreePlayerDTO> getFreePlayersLOL();
    public List<FreePlayerDTO> getFreePlayersVLR();
    public List<FreePlayerDTO> getFreePlayersTEKKEN();
    public List<FreePlayerDTO> getFreePlayersSC();
}
