package com.guvenkarabulut.spspotifyplaylistadder.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Album {
    private AlbumTypeEnum albumType;
    private Artist[] artists;
    private String[] availableMarkets;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private Image[] images;
    private String name;
    private LocalDate releaseDate;
    private ReleaseDatePrecision releaseDatePrecision;
    private long totalTracks;
    private AlbumTypeEnum type;
    private String uri;
}
