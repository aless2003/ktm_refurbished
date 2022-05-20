package com.ktm.ktm_refurbished;

import com.ktm.ktm_refurbished.repositories.MotorcyclePartRepository;
import com.ktm.ktm_refurbished.repositories.MotorcycleRepository;
import java.nio.file.Path;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

@Configuration
public class DataInput implements CommandLineRunner {

  private MotorcycleRepository motorcycleRepository;
  private MotorcyclePartRepository motorcyclePartRepository;

  public DataInput(MotorcycleRepository motorcycleRepository, MotorcyclePartRepository motorcyclePartRepository) {
    this.motorcycleRepository = motorcycleRepository;
    this.motorcyclePartRepository = motorcyclePartRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Path file = ResourceUtils.getFile("../../resources.motorcycle_data.json").toPath();
    System.out.println(file);
    for(int i = 0; i <100; i++){
      System.out.println("skldflkasjlkf");
    }
  }
}
