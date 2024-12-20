package com.hasansahin.gallerist.jwt;

import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import com.hasansahin.gallerist.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails=userService.findByUsername(username);
        if(userDetails==null){
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_NOT_FOUND,username));
        }
        return userDetails;
    }
}
