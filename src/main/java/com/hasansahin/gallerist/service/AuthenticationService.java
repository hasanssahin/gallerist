package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.DtoUser;
import com.hasansahin.gallerist.dto.request.AuthRequest;
import com.hasansahin.gallerist.dto.response.AuthResponse;
import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import com.hasansahin.gallerist.jwt.JwtService;
import com.hasansahin.gallerist.model.RefreshToken;
import com.hasansahin.gallerist.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final AuthenticationProvider authenticationProvider;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    public AuthenticationService(UserService userService, AuthenticationProvider authenticationProvider, JwtService jwtService, RefreshTokenService refreshTokenService) {
        this.userService = userService;
        this.authenticationProvider = authenticationProvider;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
    }

    public DtoUser register(AuthRequest authRequest) {
        DtoUser dtoUser = new DtoUser();
        User savedUser = userService.save(authRequest);
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }

    public AuthResponse authenticate(AuthRequest authRequest){
        try {
            UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword());
            authenticationProvider.authenticate(auth);
            User userDetails=userService.findByUsername(authRequest.getUsername());
            String accessToken=jwtService.generateToken(userDetails);
            RefreshToken refreshToken=refreshTokenService.generateRefreshToken(userDetails);
            return new AuthResponse(accessToken,refreshToken.getRefreshToken());
        }catch (Exception e){
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, null));
        }
    }
}
