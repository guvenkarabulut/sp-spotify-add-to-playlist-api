package com.guvenkarabulut.spspotifyplaylistadder.entity;

import java.io.IOException;

public enum ItemType {
    TRACK;

    public String toValue() {
        switch (this) {
            case TRACK: return "track";
        }
        return null;
    }

    public static ItemType forValue(String value) throws IOException {
        if (value.equals("track")) return TRACK;
        throw new IOException("Cannot deserialize ItemType");
    }
}
