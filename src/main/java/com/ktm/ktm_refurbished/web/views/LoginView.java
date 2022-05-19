package com.ktm.ktm_refurbished.web.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route
@CssImport("./css/sec.css")
public class LoginView extends VerticalLayout {


  private final LoginForm loginForm = new LoginForm();

  public LoginView() {
    setSizeFull();
    setAlignItems(Alignment.CENTER);
    setJustifyContentMode(JustifyContentMode.CENTER);

    loginForm.setAction("login");

    add(loginForm);
  }
}
