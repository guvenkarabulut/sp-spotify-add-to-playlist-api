package com.guvenkarabulut.spspotifyplaylistadder.services;

import com.guvenkarabulut.spspotifyplaylistadder.entity.playlist.SpotifyPlaylistModel;
import com.guvenkarabulut.spspotifyplaylistadder.entity.track.SpotifyTrackModel;

public interface BaseService {
    SpotifyTrackModel searchTrack(String q);
    SpotifyPlaylistModel searchPlaylist(String q);
    void addItemToPlaylist(String trackUri,String playlistId);

}
