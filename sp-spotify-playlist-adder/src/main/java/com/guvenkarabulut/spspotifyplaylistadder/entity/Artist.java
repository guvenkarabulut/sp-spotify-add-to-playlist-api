package com.guvenkarabulut.spspotifyplaylistadder.entity;

import lombok.Data;

@Data
public class Artist {
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private String name;
    private ArtistType type;
    private String uri;
}