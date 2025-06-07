package ua.opnu.practice1_template.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.model.AppUser;
import ua.opnu.practice1_template.repository.AppUserRepository;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final AppUserRepository userRepository;

  public CustomUserDetailsService(AppUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return new User(user.getUsername(), user.getPassword(),
        Collections.singleton(() -> user.getRole()));
  }
}
