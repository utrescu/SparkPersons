package net.xaviersala.persons.auth;

import org.pac4j.core.authorization.Authorizer;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.profile.UserProfile;
import org.pac4j.http.profile.HttpProfile;

public class PersonsAuthorizer implements Authorizer {

  @Override
  public boolean isAuthorized(WebContext context, UserProfile profile) {


    if (profile == null) {
      return false;
    }
    if (!(profile instanceof HttpProfile)) {
      return false;
    }

    final HttpProfile httpProfile = (HttpProfile) profile;
    final String username = httpProfile.getUsername();
    return username.equals("xavier");
  }

}
