package com.guvenkarabulut.spspotifyplaylistadder.entity.track;

import lombok.Data;

@Data
public class Tracks {
    private String href;
    private Item[] items;
    private long limit;
    private String next;
    private long offset;
    private Object previous;
    private long total;
}