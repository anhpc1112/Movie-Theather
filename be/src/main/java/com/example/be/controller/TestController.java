package com.example.be.controller;

import com.example.be.service.impl.GoogleApiServiceHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    public Object authenticationGoogle(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        // http://localhost:3000/oauth2/redirect
        return oAuth2AuthenticationToken.getPrincipal().getAttributes();
    }
}
