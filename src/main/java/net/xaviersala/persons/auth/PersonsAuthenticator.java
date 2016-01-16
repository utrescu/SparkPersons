package net.xaviersala.persons.auth;

import org.pac4j.core.exception.CredentialsException;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.core.util.CommonHelper;
import org.pac4j.http.credentials.UsernamePasswordCredentials;
import org.pac4j.http.credentials.authenticator.UsernamePasswordAuthenticator;
import org.pac4j.http.profile.HttpProfile;

public class PersonsAuthenticator implements UsernamePasswordAuthenticator {


  @Override
  public void validate(UsernamePasswordCredentials credentials) {

    if (credentials == null) {
      throwsException("Sense credencials");
    }

    String username = credentials.getUsername();
    String password = credentials.getPassword();

    if (CommonHelper.isBlank(username)) {
      throwsException("Username no pot ser blanc");
    }

    if (CommonHelper.isBlank(password)) {
      throwsException("La contrasenya no pot estar en blanc");
    }

    if (username.equals("xavier")) {

    } else {
      throwsException("incorrect login or password");
    }

    final HttpProfile profile = new HttpProfile();
    profile.setId(username);
    profile.addAttribute(CommonProfile.USERNAME, username);
    credentials.setUserProfile(profile);

  }

  private void throwsException(String message) {
    throw new CredentialsException(message);

  }

}
