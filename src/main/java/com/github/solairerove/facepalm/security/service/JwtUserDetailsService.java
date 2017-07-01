package com.github.solairerove.facepalm.security.service;

import com.github.solairerove.facepalm.security.repository.UserRepository;
import com.github.solairerove.facepalm.security.model.jwt.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findOneByUsername(username))
                .map(JwtUser::fromUser)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with " + username));
    }
}
