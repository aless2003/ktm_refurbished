package com.ktm.ktm_refurbished.web.layouts;

import com.ktm.ktm_refurbished.web.views.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@CssImport("./css/standard.css")
public class StandardLayout extends VerticalLayout {

  private final VerticalLayout content = new VerticalLayout();

  public StandardLayout(String title) {
    setAlignItems(Alignment.CENTER);
    setPadding(false);
    setId("template");

    content.setId("content");

    HorizontalLayout navBar = createNavbar(title);
    Footer footer = createFooter();

    add(navBar, content, footer);
  }

  private HorizontalLayout createNavbar(String title) {
    HorizontalLayout navBar = new HorizontalLayout();
    navBar.setMinWidth(100, Unit.PERCENTAGE);

    H1 titleLabel = new H1(title);
    titleLabel.setClassName("title");
    navBar.add(titleLabel);

    if (!(this instanceof HomeView)) {
      Button homeButton = new Button("Home", VaadinIcon.HOME.create());
      navBar.add(homeButton);
    }

    navBar.setJustifyContentMode(JustifyContentMode.BETWEEN);

    return navBar;
  }

  private Footer createFooter() {
    Footer footer = new Footer();
    footer.setId("footer");
    footer.setText("Copyright 2022 KTM Sportmotorcycle GmbH, all rights reserved");
    footer.setMinWidth(100, Unit.PERCENTAGE);
    return footer;
  }

  protected void setContent(Component component) {
    this.content.removeAll();
    this.content.add(component);
  }
}
