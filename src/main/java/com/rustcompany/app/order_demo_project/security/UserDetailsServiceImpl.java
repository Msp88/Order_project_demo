package com.rustcompany.app.order_demo_project.security;

import com.rustcompany.app.order_demo_project.domain.User;
import com.rustcompany.app.order_demo_project.mappers.UserDetailsMapper;
import com.rustcompany.app.order_demo_project.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserDetailsMapper userDetailsMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
        return userDetailsMapper.fromUserToSecurityUser(user);
    }
}
