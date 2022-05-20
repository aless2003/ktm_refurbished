package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.entity.User;
import com.ktm.ktm_refurbished.security.SecurityService;
import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import javax.annotation.security.PermitAll;

@PermitAll
@Route()
@RouteAlias("/market")
// @CssImport("./css/sec.css")
public class MarktView extends StandardLayout {
  Grid<User> grid = new Grid<>(User.class);
  TextField filterText = new TextField();

  public MarktView(SecurityService securityService) {
    super("Market", securityService);
    setSizeFull();
    configureGrid();

    FlexLayout content = new FlexLayout(grid);
    content.setFlexGrow(2, grid);
    content.addClassNames("content");
    content.setSizeFull();

    add(getToolbar(), content);
    updateList();
  }

  private void configureGrid() {
    grid.addClassNames("Market");
    grid.setSizeFull();
    // grid.setColumns("firstName", "lastName", "email");
    // grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
    // grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
    // grid.addColumn(contact -> contact.getPay().getPay()).setHeader("Payment");
    // grid.getColumns().forEach(col -> col.setAutoWidth(true));
  }

  private HorizontalLayout getToolbar() {
    filterText.setPlaceholder("Filter by name...");
    filterText.setClearButtonVisible(true);
    filterText.setValueChangeMode(ValueChangeMode.LAZY);
    filterText.addValueChangeListener(e -> updateList());

    HorizontalLayout toolbar = new HorizontalLayout(filterText);
    toolbar.addClassName("toolbar");
    return toolbar;
  }

  private void updateList() {
    // grid.setItems(service.findAllContacts(filterText.getValue()));
  }
}
