package com.ktm.ktm_refurbished.API;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class part_evaluation {

  private String vin;

  private String partName;

  private int km;

  public part_evaluation(String vin, String partName, int km)
  {
    super();
    this.vin = vin;
    this.km = km;
    this.partName = partName;
  }

  public float evaluation(){
    String[] factor = {"RPM", "Watertemperatur"};
    float[] normalUserValue = {2500, 80, 70};
    String[] whatIsOptimal = {"mid", "mid"};
    float[] weighting = {50, 50};
    float[] spesificValue = {1500, 70};
    int KMimpect = 50;
    int KMaverage = 40000;

    float[] deviation = {1,1};
    float rating = 0;

    for (int i = 0; i < factor.length; i++) {
      if(whatIsOptimal[i].equals("low")) {
        deviation[i] = ((spesificValue[i] - normalUserValue[i]) / normalUserValue[i]) * 100;

        if (deviation[i] > 100)
          deviation[i] = 100;
        else if (deviation[i] < 0)
          deviation[i] = 0;
      }
      var a = ((normalUserValue[i] - spesificValue[i]) / spesificValue[i]) * 100;
      if(whatIsOptimal[i].equals("high")) {
        deviation[i] = a;
        if (deviation[i] > 100)
          deviation[i] = 100;
        else if (deviation[i] < 0)
          deviation[i] = 0;
        deviation[i] = 100 - deviation[i];
      }
      if(whatIsOptimal[i].equals("mid")) {
        deviation[i] = Math.abs(a);
        if (deviation[i] > 100)
          deviation[i] = 100;
        else if (deviation[i] < 0)
          deviation[i] = 0;
        deviation[i] = 100 - deviation[i];
      }
      rating = rating + ((deviation[i] * weighting[i]) / 100);
      System.out.println(deviation[i]);
    }
    rating = rating + ((KMaverage * KMimpect) / 100);
    System.out.println("Gesamt Rating: " + rating);

    return rating;
  }

}
