package com.hasansahin.gallerist.service;

import com.hasansahin.gallerist.dto.request.AuthRequest;
import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import com.hasansahin.gallerist.model.User;
import com.hasansahin.gallerist.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()->new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST,username)));
    }

    public User save(AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }
}
