package com.ktm.ktm_refurbished.entity;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import lombok.Data;

@Data
public class User {
  private String username;
  private String passwordHash;

  public void setPasswordHash(String password) {
    this.passwordHash = Hashing.sha256()
        .hashString(password, StandardCharsets.UTF_8)
        .toString();
  }
}
