package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.objects.Motorcycle;
import com.ktm.ktm_refurbished.services.MotorcycleService;
import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route()
@RouteAlias("/")
public class HomeView extends StandardLayout {

  private SpecificMotorcycleRepository motorcycleRepository;

  public HomeView(SpecificMotorcycleRepository motorcycleRepository) {
    super("Home");
    this.motorcycleRepository = motorcycleRepository;

    Grid<SpecificMotorcycle> grid = new Grid<>(SpecificMotorcycle.class);
    grid.setItems(motorcycleRepository.findAll());
    add(grid);
  }
}
