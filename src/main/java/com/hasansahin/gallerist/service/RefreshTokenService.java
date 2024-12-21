package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.request.RefreshTokenRequest;
import com.hasansahin.gallerist.dto.response.AuthResponse;
import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import com.hasansahin.gallerist.jwt.JwtService;
import com.hasansahin.gallerist.model.RefreshToken;
import com.hasansahin.gallerist.model.User;
import com.hasansahin.gallerist.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class RefreshTokenService {
    private final JwtService jwtService;
    @Value("${jwt.refresh.token.expiration}")
    private long refreshTokenExpiration;

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, JwtService jwtService) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtService = jwtService;
    }

    public RefreshToken generateRefreshToken(User user){
        RefreshToken refreshToken=new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setCreatedDate(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis()+refreshTokenExpiration));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        return refreshTokenRepository.save(refreshToken);
    }

    public boolean isValidRefreshToken(Date expiredDate){
        return expiredDate.after(new Date());
    }

    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        RefreshToken refreshToken = refreshTokenRepository.findByRefreshToken(refreshTokenRequest.getRefreshToken()).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_NOT_FOUND, refreshTokenRequest.getRefreshToken())));
        if (!isValidRefreshToken(refreshToken.getExpiredDate())){
            throw new BaseException(new ErrorMessage(MessageType.REFRESH_TOKEN_EXPIRED, refreshToken.getRefreshToken()));
        }
        User user = refreshToken.getUser();
        String accessToken=jwtService.generateToken(user);
        String newRefreshToken=generateRefreshToken(user).getRefreshToken();
        return new AuthResponse(accessToken,newRefreshToken);
    }
}
