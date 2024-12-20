package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.model.RefreshToken;
import com.hasansahin.gallerist.model.User;
import com.hasansahin.gallerist.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenService {
    @Value("${jwt.refresh.token.expiration}")
    private long refreshTokenExpiration;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshToken generateRefreshToken(User user){
        RefreshToken refreshToken=new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setCreatedDate(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis()+refreshTokenExpiration));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }
}
