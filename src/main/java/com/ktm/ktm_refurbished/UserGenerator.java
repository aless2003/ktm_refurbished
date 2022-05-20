package com.ktm.ktm_refurbished;

import com.ktm.ktm_refurbished.db.UserRepository;
import com.ktm.ktm_refurbished.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserGenerator implements CommandLineRunner {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserGenerator(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public void run(String... args) {
    User user = new User();
    user.setUsername("test1");
    user.setPasswordHash(bCryptPasswordEncoder.encode("admin"));
    userRepository.save(user);

    User user2 = new User();
    user2.setUsername("test2");
    user2.setPasswordHash(bCryptPasswordEncoder.encode("test"));
    userRepository.save(user2);
  }
}
