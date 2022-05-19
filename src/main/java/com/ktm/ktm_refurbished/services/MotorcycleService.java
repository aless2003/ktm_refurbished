package com.ktm.ktm_refurbished.services;

import com.ktm.ktm_refurbished.objects.Motorcycle;
import com.ktm.ktm_refurbished.repositories.MotorcycleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motorcycles")
public class MotorcycleService{

  @Autowired
  private final MotorcycleRepository repository;

  public MotorcycleService(MotorcycleRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<Motorcycle> findAll(){
    return repository.findAll();
  }

  @PostMapping
  public Motorcycle add(@RequestBody Motorcycle motorcycle) {return repository.insert(motorcycle);
  }

  public Motorcycle update(Motorcycle motorcycle) {
    return repository.save(motorcycle);
  }

  @DeleteMapping
  public void delete(@RequestBody Motorcycle motorcycle) {
    repository.delete(motorcycle);
  }
}
