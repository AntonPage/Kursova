package ua.opnu.practice1_template.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.dto.AuthRequest;
import ua.opnu.practice1_template.dto.AuthResponse;
import ua.opnu.practice1_template.model.AppUser;
import ua.opnu.practice1_template.repository.AppUserRepository;

@Service
public class AuthenticationService {

  private final AppUserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationService(AppUserRepository userRepository,
                               PasswordEncoder passwordEncoder,
                               JwtService jwtService,
                               AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public AuthResponse register(AuthRequest request) {
    AppUser user = new AppUser();
    user.setUsername(request.getUsername());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole("ROLE_USER");
    userRepository.save(user);

    String token = jwtService.generateToken(user.getUsername());
    return new AuthResponse(token);
  }

  public AuthResponse authenticate(AuthRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
    );

    AppUser user = userRepository.findByUsername(request.getUsername())
        .orElseThrow();
    String token = jwtService.generateToken(user.getUsername());
    return new AuthResponse(token);
  }
}
