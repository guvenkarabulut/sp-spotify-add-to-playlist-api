package com.guvenkarabulut.spspotifyplaylistadder.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.guvenkarabulut.spspotifyplaylistadder.entity.playlist.SpotifyPlaylistModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.guvenkarabulut.spspotifyplaylistadder.entity.track.SpotifyTrackModel;
import com.guvenkarabulut.spspotifyplaylistadder.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;


@Service
@RequiredArgsConstructor
@Slf4j
public class BaseServiceImpl implements BaseService {
    @Value("${spotify.client.id}")
    private String clientId;
    @Value("${spotify.client.secret}")
    private String clientSecret;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public SpotifyTrackModel searchTrack(String q) {
        return search(q,"track",SpotifyTrackModel.class);
    }

    @Override
    public SpotifyPlaylistModel searchPlaylist(String q) {
        return search(q,"playlist",SpotifyPlaylistModel.class);
    }

    @Override
    public void addItemToPlaylist(String trackUri, String playlistId) {
        String url = "https://api.spotify.com/v1/playlists/%s/tracks"
                .formatted(playlistId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getApiKey());
        String requestBody = "{\"uris\": [\"" + trackUri + "\"], \"position\": 0}";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }

    private <T> T search(String q, String type, Class<T> responseType) {
        final String url = "https://api.spotify.com/v1/search";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + getApiKey());
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("q", q)
                .queryParam("type", type)
                .build()
                .toUri();

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<T> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType);

        return responseEntity.getBody();
    }

    private String getApiKey(){
        String url = "https://accounts.spotify.com/api/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("grant_type", "client_credentials");

        ResponseEntity<String> response = restTemplate
                .postForEntity(url, new HttpEntity<>(map, headers), String.class);

        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            return jsonNode.get("access_token").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
