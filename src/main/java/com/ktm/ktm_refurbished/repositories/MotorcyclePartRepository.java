package com.ktm.ktm_refurbished.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcyclePartRepository
    extends MongoRepository<MotorcyclePartRepository, String> {}
