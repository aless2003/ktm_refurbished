package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.objects.SpecificMotorcycle;
import com.ktm.ktm_refurbished.repositories.SpecificMotorcycleRepository;
import com.ktm.ktm_refurbished.security.SecurityService;
import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route()
@RouteAlias("/")
public class HomeView extends StandardLayout {

  public HomeView(SpecificMotorcycleRepository motorcycleRepository, SecurityService service) {
    super("Home", service);
    Grid<SpecificMotorcycle> grid = new Grid<>(SpecificMotorcycle.class);
    grid.setItems(motorcycleRepository.findAll());
    add(grid);
  }
}
