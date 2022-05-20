package com.ktm.ktm_refurbished.objects;

import com.vaadin.flow.component.template.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "motorcyclePartStandardData")
public class MotorcyclePartStandardData {

  private enum OptimalState {
    HIGHER,
    PRECISELY,
    LOWER
  }

  @Id
  String name;
  OptimalState optimalState;
  Float normalUserValue;
  Float weighting;
  Float kilometerImpact;
  Float kilometerAverage;

}
