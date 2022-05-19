package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.db.UserRepository;
import com.ktm.ktm_refurbished.entity.User;
import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import java.util.Optional;


@Route
public class LoginView extends StandardLayout {

  private final TextField usernameInput = new TextField("Username");
  private final PasswordField passwordInput = new PasswordField("Password");

  public LoginView(UserRepository repo) {
    super("Login");

    FormLayout loginForm = new FormLayout();
    VerticalLayout content = new VerticalLayout();

    Button login = new Button("Login");
    login.addClickListener(event -> {
      Binder<User> binder = new Binder<>(User.class);
      binder.bind(usernameInput, User::getUsername, User::setUsername);
      binder.bind(passwordInput, User::getPasswordHash, User::setPasswordHash);
      User user = binder.getBean();
      Optional<User> userOptional = repo.findByUsername(user.getUsername());
      if (userOptional.isPresent()) {
        User userFromDb = userOptional.get();
        if (userFromDb.getPasswordHash().equals(user.getPasswordHash())) {
          Notification.show("Login successful");
          UI.getCurrent().navigate(HomeView.class);
        }
      } else {
        Notification.show("User not found");
      }
    });

    loginForm.add(usernameInput, passwordInput);
    content.add(loginForm);
    setContent(content);
  }
}
