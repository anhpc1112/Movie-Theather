package com.example.be.service.impl;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.calendar.CalendarScopes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@Slf4j
@Service
public class GoogleApiServiceHandler extends AbstractAuthorizationCodeServlet {

    @Value("${google.api.endpoint}")
    private String googleApiEndpoint;

    @Value("${google.scope}")
    private String scope;

    @Value("${google.access-type}")
    private String accessType;

    @Value("${google.include-granted-scopes}")
    private String includeGrantedScopes;

    @Value("${google.response-type}")
    private String responseType;

    @Value("${google.redirect-uri}")
    private String redirectUri;

    @Value("${google.client-id}")
    private String clientId;

    @Value("${google.client-secret}")
    private String clientSecret;


    @Override
    protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
        return new GoogleAuthorizationCodeFlow.Builder(
                new NetHttpTransport(), GsonFactory.getDefaultInstance(),
                clientId, clientSecret,
                Collections.singleton(CalendarScopes.CALENDAR)).setDataStoreFactory(
                DATA_STORE_FACTORY).setAccessType("offline").build();
    }

    @Override
    protected String getRedirectUri(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        return null;
    }

    @Override
    protected String getUserId(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        return null;
    }
}
