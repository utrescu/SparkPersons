package net.xaviersala.persons.auth;

import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.core.config.ConfigFactory;
import org.pac4j.http.client.direct.DirectBasicAuthClient;

public class PersonsConfigFactory implements ConfigFactory {

  @Override
  public Config build() {

    final DirectBasicAuthClient directBasicAuthClient = new DirectBasicAuthClient(new PersonsAuthenticator());
    // Amb el segon paràmetre va bé però està deprecated
//                                                                                   new UsernameProfileCreator());


    // ... SimpleTextUsernamePasswordAuthenticator: usuari i contrasenya han de ser iguals
    // final DirectBasicAuthClient directBasicAuthClient = new DirectBasicAuthClient(new SimpleTestUsernamePasswordAuthenticator());

    final Clients clients = new Clients(directBasicAuthClient);

    final Config config = new Config(clients);
    config.addAuthorizer("custom", new PersonsAuthorizer());
    config.setHttpActionAdapter(new PersonsHttpActionAdapter());
    return config;
  }



}
