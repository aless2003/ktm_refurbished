package com.ktm.ktm_refurbished.API;

import java.util.ArrayList;
import java.util.List;

public class part_evaluation {

  private String vin;

  private String partName;

  public part_evaluation(
      String vin, String partName)
  {
    super();

    this.vin = vin;

    this.partName = partName;
  }

  public String evaluation(){
    String[] factor = {"RPM", "Watertemperatur"};
    float[] normalUserValue = {2500, 80};
    String[] whatIsOptimal = {"mid", "mid"};
    float[] weighting = {50, 50};
    float[] spesificValue = {1500, 70};

    float[] deviation = {1,1};

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

      System.out.println(deviation[i]);
    }
    return "test";
  }

}
