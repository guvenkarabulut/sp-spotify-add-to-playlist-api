package com.guvenkarabulut.spspotifyplaylistadder.entity.track;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Album {
    private String albumType;
    private Artist[] artists;
    private String[] availableMarkets;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private Image[] images;
    private String name;
    private LocalDate releaseDate;
    private String releaseDatePrecision;
    private long totalTracks;
    private String type;
    private String uri;
}
