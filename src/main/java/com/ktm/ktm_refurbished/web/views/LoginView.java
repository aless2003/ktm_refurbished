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
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import java.util.Optional;


@Route
public class LoginView extends StandardLayout {

  private final TextField username = new TextField("Username");
  private final PasswordField passwordHash = new PasswordField("Password");

  public LoginView(UserRepository repo) {
    super("Login");

    FormLayout loginForm = new FormLayout();
    VerticalLayout content = new VerticalLayout();

    Button login = new Button("Login");
    login.addClickListener(event -> {
      Binder<User> binder = new Binder<>(User.class);
      binder.bind(username, User::getUsername, User::setUsername);
      binder.bind(passwordHash, User::getPasswordHash, User::setPasswordHash);
      User user = new User();
      try {
        binder.writeBean(user);
      } catch (ValidationException e) {
        Notification.show("Could not validate user");
      }
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

    loginForm.add(username, passwordHash, login);
    content.add(loginForm);
    setContent(content);
  }
}
