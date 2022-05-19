package com.ktm.ktm_refurbished.objects;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "motorcycleSpecificData")
public class SpecificMotorcycle {

  @Id
  private String vin;
  private Motorcycle motorcycle;
  private MotorcycleSpecificData motorcycleSpecificData;

}
