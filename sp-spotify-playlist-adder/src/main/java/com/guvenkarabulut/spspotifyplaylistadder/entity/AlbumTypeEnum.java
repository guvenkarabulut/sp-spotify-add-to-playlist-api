package com.guvenkarabulut.spspotifyplaylistadder.entity;

import java.io.IOException;

public enum AlbumTypeEnum {
    ALBUM, SINGLE;

    public String toValue() {
        switch (this) {
            case ALBUM: return "album";
            case SINGLE: return "single";
        }
        return null;
    }

    public static AlbumTypeEnum forValue(String value) throws IOException {
        if (value.equals("album")) return ALBUM;
        if (value.equals("single")) return SINGLE;
        throw new IOException("Cannot deserialize AlbumTypeEnum");
    }
}