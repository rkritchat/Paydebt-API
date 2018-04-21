package com.paydebt.paydebt.service;

import com.paydebt.paydebt.model.UserId;
import com.paydebt.paydebt.repository.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailService implements UserDetailsService{

    @Autowired
    private UserIdRepository userIdRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserId userInfo = getUserIdByUsername(username);
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new User(userInfo.getId(), encoder.encode(userInfo.getPwd()),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }

    public UserId getUserIdByUsername(String username) {
        UserId userId =  userIdRepository.findById(username);
        System.out.println("ID : " + userId.getId() + "PWD : " + userId.getPwd());
        return userId != null ? userId : new UserId();
     }
}
