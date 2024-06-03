package com.studentesports.backend.services;

import com.studentesports.backend.DTO.PlayerDTO;
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

    public List<PlayerCS2> getPlayersCS2();
    public List<PlayerDOTA> getPlayersDOTA();
    public List<PlayerLOL> getPlayersLOL();
    public List<PlayerVLR> getPlayersVLR();
    public List<PlayerTEKKEN> getPlayersTEKKEN();
    public List<PlayerSC> getPlayersSC();

    public List<PlayerCS2> getFreePlayersCS2();
    public List<PlayerDOTA> getFreePlayersDOTA();
    public List<PlayerLOL> getFreePlayersLOL();
    public List<PlayerVLR> getFreePlayersVLR();
    public List<PlayerTEKKEN> getFreePlayersTEKKEN();
    public List<PlayerSC> getFreePlayersSC();
}
