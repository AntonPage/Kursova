package ua.opnu.practice1_template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuth2SuccessController {

  @GetMapping("/success")
  public String success() {
    return "✅ Login with Google successful!";
  }
}