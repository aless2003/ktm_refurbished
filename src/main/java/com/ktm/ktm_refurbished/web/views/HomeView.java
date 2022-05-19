package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.security.SecurityService;
import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import javax.annotation.security.PermitAll;

@PermitAll
@Route()
@RouteAlias("/")
public class HomeView extends StandardLayout {

  public HomeView(SecurityService securityService) {
    super("Home", securityService);
  }
}
