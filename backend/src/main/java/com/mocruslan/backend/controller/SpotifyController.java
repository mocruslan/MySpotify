package com.mocruslan.backend.controller;

import com.mocruslan.backend.shared.spotify.SpotifyConfig;
import com.mocruslan.backend.shared.spotify.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyController {
    @Autowired
    SpotifyConfig spotifyConfig;

    @GetMapping("/spotify")
    public String index() {
        SpotifyService service = new SpotifyService(spotifyConfig.spotifyApi());
        service.clientCredentials_Sync();

        return spotifyConfig.spotifyApi().getAccessToken();
    }
}
