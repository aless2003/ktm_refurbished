package com.ktm.ktm_refurbished.web.views;

import com.ktm.ktm_refurbished.db.UserRepository;
import com.ktm.ktm_refurbished.entity.User;
import com.ktm.ktm_refurbished.security.SecurityService;
import com.ktm.ktm_refurbished.web.layouts.StandardLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import javax.annotation.security.PermitAll;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@PermitAll
@AnonymousAllowed
@Route()
@CssImport("./css/sec.css")
public class SignUpView extends StandardLayout {

  private final PasswordField passwordField;

  public SignUpView(
      UserRepository repo, BCryptPasswordEncoder encoder, SecurityService securityService) {
    super("Sign-Up", securityService);

    H3 title = new H3("Signup form");

    TextField userName = new TextField("User name");

    EmailField emailField = new EmailField("Email");

    passwordField = new PasswordField("Password");

    Span errorMessage = new Span();

    Button submitButton = new Button("Sign-UP");
    submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

    // Build Layout
    FormLayout formLayout =
        new FormLayout(title, userName, passwordField, emailField, errorMessage, submitButton);

    // Responsive
    formLayout.setResponsiveSteps(
        new FormLayout.ResponsiveStep("0", 1, FormLayout.ResponsiveStep.LabelsPosition.TOP),
        new FormLayout.ResponsiveStep("490px", 2, FormLayout.ResponsiveStep.LabelsPosition.TOP));

    formLayout.setColspan(title, 2);
    formLayout.setColspan(errorMessage, 2);
    formLayout.setColspan(submitButton, 2);

    // ErrorMessage styling
    errorMessage.getStyle().set("color", "var(--lumo-error-text-color)");
    errorMessage.getStyle().set("padding", "15px 0");

    // Add the form to page
    add(formLayout);

    submitButton.addClickListener(
        event -> {
          User user = new User();
          Binder<User> binder = new Binder<>(User.class);
          binder.setStatusLabel(errorMessage);
          binder.bind(userName, User::getUsername, User::setUsername);
          binder.bind(emailField, User::getEmail, User::setEmail);
          binder.bind(
              passwordField,
              User::getPasswordHash,
              (user1, password) -> user1.setPasswordHash(password, encoder));
          try {
            binder.writeBean(user);
          } catch (ValidationException e) {
            Notification notification = new Notification("Validation error", 3000);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.open();
            return;
          }

          var repoUser = repo.findByUsername(user.getUsername());
          if (repoUser.isPresent()) {
            Notification notification = new Notification("Username already exists", 3000);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.open();
            return;
          }

          repoUser = repo.findByEmail(user.getEmail());
          if (repoUser.isPresent()) {
            Notification notification = new Notification("Email already exists", 3000);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.open();
            return;
          }

          if (user.getUsername() == null
              || user.getPasswordHash() == null
              || user.getEmail() == null) {
            Notification notification = new Notification("Please fill out all the fields", 3000);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            notification.open();
            return;
          }

          repo.save(user);
          UI.getCurrent().navigate(LoginView.class);
        });
  }
}
