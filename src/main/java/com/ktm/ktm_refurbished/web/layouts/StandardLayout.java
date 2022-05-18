package com.ktm.ktm_refurbished.web.layouts;

import com.ktm.ktm_refurbished.web.views.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class StandardLayout extends VerticalLayout {

  private final VerticalLayout content = new VerticalLayout();

  public StandardLayout(String title) {
    setJustifyContentMode(JustifyContentMode.CENTER);
    setAlignItems(Alignment.CENTER);

    HorizontalLayout navBar = createNavbar();
    Footer footer = createFooter();

    add(navBar, content, footer);
  }

  private Footer createFooter() {
    Footer footer = new Footer();
    footer.setId("footer");
    footer.setText("Copyright 2022 KTM Sportmotorcycle GmbH, all rights reserved");
    footer.setMinWidth(100, Unit.PERCENTAGE);
    return footer;
  }

  private HorizontalLayout createNavbar() {
    HorizontalLayout navBar = new HorizontalLayout();
    if (!(this instanceof HomeView)) {
      Button homeButton = new Button("Home", VaadinIcon.HOME.create());
      navBar.add(homeButton);
    }

    navBar.setMinWidth(100, Unit.PERCENTAGE);
    return navBar;
  }

  protected void setContent(Component component) {
    this.content.removeAll();
    this.content.add(component);
  }
}
