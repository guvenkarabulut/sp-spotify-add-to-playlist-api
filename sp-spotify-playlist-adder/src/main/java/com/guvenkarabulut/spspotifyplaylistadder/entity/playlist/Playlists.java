package com.guvenkarabulut.spspotifyplaylistadder.entity.playlist;

import lombok.Data;

@Data
public class Playlists {
    private String href;
    private Item[] items;
    private long limit;
    private String next;
    private long offset;
    private Object previous;
    private long total;
}
