package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route()
@RouteAlias("/")
public class HomeView extends StandardLayout {

  public HomeView() {
    super("Home");
    Grid<Person> grid = new Grid<>(Person.class, false);
    grid.addColumn(Person::getFirstName).setHeader("First name");
    grid.addColumn(Person::getLastName).setHeader("Last name");
    grid.addColumn(Person::getEmail).setHeader("Email");
    grid.addColumn(Person::getProfession).setHeader("Profession");

    List<Person> people = DataService.getPeople();
    grid.setItems(people);
  }
}
