package org.authenticationservice.config;

import lombok.extern.slf4j.Slf4j;
import org.authenticationservice.dto.VoterCredentials;
import org.authenticationservice.utils.VoterFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class CustomeUserDetailsService implements UserDetailsService {

    @Autowired
    private VoterFeignClient voterClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading user by username: " + username);
        Optional<VoterCredentials> voterCredentials = Optional.ofNullable(this.voterClient.findByEmail(username).getBody());
        log.info("Voter credentials: ");
        return voterCredentials.map(CustomeUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));
    }
}
