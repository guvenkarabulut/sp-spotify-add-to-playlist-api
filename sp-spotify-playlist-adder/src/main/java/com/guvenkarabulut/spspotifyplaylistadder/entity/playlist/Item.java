package com.guvenkarabulut.spspotifyplaylistadder.entity.playlist;

import com.guvenkarabulut.spspotifyplaylistadder.entity.track.ExternalUrls;
import com.guvenkarabulut.spspotifyplaylistadder.entity.track.Image;
import lombok.Data;

@Data
public class Item {
    private boolean collaborative;
    private String description;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private Image[] images;
    private String name;
    private Owner owner;
    private Object primaryColor;
    private Object itemPublic;
    private String snapshotID;
    private Tracks tracks;
    private String type;
    private String uri;
}
