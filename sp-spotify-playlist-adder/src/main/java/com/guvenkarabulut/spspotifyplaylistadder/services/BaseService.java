package com.guvenkarabulut.spspotifyplaylistadder.services;

import com.guvenkarabulut.spspotifyplaylistadder.entity.SpotifyTrackModel;

import java.time.DateTimeException;
import java.time.ZoneId;

public interface BaseService {
    SpotifyTrackModel searchTracks(String trackName);
}
