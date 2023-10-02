package com.guvenkarabulut.spspotifyplaylistadder.services.impl;

import org.springframework.web.client.RestTemplate;
import com.guvenkarabulut.spspotifyplaylistadder.entity.SpotifyTrackModel;
import com.guvenkarabulut.spspotifyplaylistadder.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JavaServiceImpl implements BaseService {
    private final RestTemplate restTemplate;
    @Override
    public SpotifyTrackModel searchTracks(String trackName) {

        return null;
    }
}
