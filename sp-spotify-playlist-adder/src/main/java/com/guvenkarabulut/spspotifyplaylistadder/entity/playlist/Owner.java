package com.guvenkarabulut.spspotifyplaylistadder.entity.playlist;

import com.guvenkarabulut.spspotifyplaylistadder.entity.track.ExternalUrls;
import lombok.Data;

@Data
public class Owner {
    private String displayName;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private String type;
    private String uri;
}
