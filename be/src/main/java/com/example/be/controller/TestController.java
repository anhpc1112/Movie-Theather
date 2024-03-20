package com.example.be.controller;

import com.example.be.service.impl.GoogleApiServiceHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final GoogleApiServiceHandler googleApiServiceHandlerl;

    @GetMapping("/test")
    public String authenticationGoogle() {
        return googleApiServiceHandlerl.callGoogleApi();
    }
}
