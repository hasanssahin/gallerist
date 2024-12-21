package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.DtoUser;
import com.hasansahin.gallerist.dto.request.AuthRequest;
import com.hasansahin.gallerist.dto.request.RefreshTokenRequest;
import com.hasansahin.gallerist.dto.response.AuthResponse;
import com.hasansahin.gallerist.service.AuthenticationService;
import com.hasansahin.gallerist.utils.RootEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController extends BaseController{
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest authRequest) {
        DtoUser dtoUser=authenticationService.register(authRequest);
        return ok(dtoUser);
    }

    @PostMapping("/authenticate")
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest authRequest) {
        return ok(authenticationService.authenticate(authRequest));
    }

    @PostMapping("/refreshToken")
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
        return ok(authenticationService.refreshToken(refreshTokenRequest));
    }
}
