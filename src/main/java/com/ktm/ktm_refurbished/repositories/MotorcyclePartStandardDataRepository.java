package com.ktm.ktm_refurbished.repositories;

import com.ktm.ktm_refurbished.objects.MotorcyclePartStandardData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcyclePartStandardDataRepository
    extends MongoRepository<MotorcyclePartStandardData, String> {}
