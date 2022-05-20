package com.ktm.ktm_refurbished.repositories;

import com.ktm.ktm_refurbished.objects.Motorcycle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends MongoRepository<Motorcycle, String> {}
