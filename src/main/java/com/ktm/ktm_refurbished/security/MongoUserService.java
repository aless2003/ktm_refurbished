package com.ktm.ktm_refurbished.security;

import com.ktm.ktm_refurbished.db.UserRepository;
import com.ktm.ktm_refurbished.entity.User;
import java.util.HashSet;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MongoUserService implements UserDetailsService {

  UserRepository repo;

  public MongoUserService(UserRepository repo) {
    this.repo = repo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = repo.findByUsername(username);

    HashSet<GrantedAuthority> authorities = new HashSet<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    if (user.isPresent()) {
      return new org.springframework.security.core.userdetails.User(
          user.get().getUsername(), user.get().getPasswordHash(), authorities);
    }

    throw new UsernameNotFoundException("User not found");
  }
}
