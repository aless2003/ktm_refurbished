package com.ktm.ktm_refurbished.db;

import com.ktm.ktm_refurbished.entity.User;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.NonNullApi;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByUsername(String username);
  Optional<User> findByEmail(String email);
}
