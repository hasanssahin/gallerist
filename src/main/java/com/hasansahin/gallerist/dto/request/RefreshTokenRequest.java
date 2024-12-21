package com.hasansahin.gallerist.dto.request;

import jakarta.validation.constraints.NotEmpty;

public class RefreshTokenRequest {
    @NotEmpty
    private String refreshToken;

    public RefreshTokenRequest() {
    }

    public RefreshTokenRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
