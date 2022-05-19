package com.ktm.ktm_refurbished.entity;

import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {
  @Email private String email;
  private String username;
  private String passwordHash;

  public void setPasswordHash(String password, BCryptPasswordEncoder encoder) {
    this.passwordHash = encoder.encode(password);
  }
}
