package com.guvenkarabulut.spspotifyplaylistadder.entity.track;

import lombok.Data;

@Data
public class Item {
    private Album album;
    private Artist[] artists;
    private String[] availableMarkets;
    private long discNumber;
    private long durationMS;
    private boolean explicit;
    private ExternalIDS externalIDS;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private boolean isLocal;
    private String name;
    private long popularity;
    private String previewURL;
    private long trackNumber;
    private String type;
    private String uri;
}

