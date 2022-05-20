package com.ktm.ktm_refurbished.repositories;

import com.ktm.ktm_refurbished.objects.SpecificMotorcycle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificMotorcycleRepository extends MongoRepository<SpecificMotorcycle, String> {}
