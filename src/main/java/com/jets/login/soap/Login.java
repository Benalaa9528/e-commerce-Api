package com.jets.login.soap;

import com.jets.login.dto.Credentials;

import jakarta.jws.WebService;
@WebService
public interface Login {
  public String login(Credentials credentials);
}
