package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route()
@RouteAlias("/")
public class HomeView extends StandardLayout {

  public HomeView() {
    super("Home");
  }
}
