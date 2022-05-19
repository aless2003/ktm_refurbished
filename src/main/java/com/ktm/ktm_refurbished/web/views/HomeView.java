package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.security.SecurityService;
import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route()
@RouteAlias("/")
public class HomeView extends StandardLayout {

  public HomeView(MotorcycleService service, SecurityService secServ) {
    super("Home", secServ);
    Grid<Motorcycle> grid = new Grid<>(Motorcycle.class);
    grid.setItems(service.findAll());
    add(grid);
  }
}
