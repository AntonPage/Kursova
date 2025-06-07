package ua.opnu.practice1_template.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.dto.AuthRequest;
import ua.opnu.practice1_template.dto.AuthResponse;
import ua.opnu.practice1_template.security.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationService authService;

  public AuthController(AuthenticationService authService) {
    this.authService = authService;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
    return ResponseEntity.ok(authService.authenticate(request));
  }
}
