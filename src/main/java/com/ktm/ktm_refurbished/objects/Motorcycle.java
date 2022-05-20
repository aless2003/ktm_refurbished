package com.ktm.ktm_refurbished.objects;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "motorcycles")
public class Motorcycle {

  @Id private String type;
  private String name;
  private Integer kilometers;
  private Integer horsePower;
  private Integer displacement;
  private MotorcyclePart[] parts;
}
