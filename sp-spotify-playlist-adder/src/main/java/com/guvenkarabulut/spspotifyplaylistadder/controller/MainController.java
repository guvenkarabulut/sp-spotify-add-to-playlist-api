package com.guvenkarabulut.spspotifyplaylistadder.controller;

import com.guvenkarabulut.spspotifyplaylistadder.entity.playlist.SpotifyPlaylistModel;
import com.guvenkarabulut.spspotifyplaylistadder.entity.track.SpotifyTrackModel;
import com.guvenkarabulut.spspotifyplaylistadder.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/spotify")
public class MainController {
    private final BaseService baseService;

    @GetMapping("/track")
    ResponseEntity<SpotifyTrackModel> searchTrack(@RequestParam(name = "q") String q){
        return ResponseEntity.ok(baseService.searchTrack(q));
    }
    @GetMapping("/playlist")
    ResponseEntity<SpotifyPlaylistModel> searchPlaylist(@RequestParam(name = "q") String q){
        return ResponseEntity.ok(baseService.searchPlaylist(q));
    }
    @PostMapping
    ResponseEntity<Void> addItemPlaylist(
            @RequestParam(name = "playlistId") String playlistId,
            @RequestParam(name = "trackuri") String trackUri){
        baseService.addItemToPlaylist(trackUri,playlistId);
        return (ResponseEntity<Void>) ResponseEntity.ok();
    }

}
