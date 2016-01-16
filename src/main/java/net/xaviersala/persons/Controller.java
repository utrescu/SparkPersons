package net.xaviersala.persons;

import com.google.gson.Gson;

import net.xaviersala.persons.DAO.PersonDAO;
import net.xaviersala.persons.model.Person;

public class Controller {
  PersonDAO dao;
  Gson gson;

  public Controller(PersonDAO dao) {
    super();
    this.dao = dao;
    gson = new Gson();
  }

  public String getAllPersons() {
    return gson.toJson(dao.getPersons());
  }

  public String getPerson(String id) {
    Person person = dao.getPerson(id);
    if (person == null) {

    }
    return gson.toJson(person);
  }

  public Object addPerson(String body) {
    Person person = gson.fromJson(body, Person.class);
    if (person.isValid() && dao.addPerson(person)) {
      return "{\"response\": \"" + person.getId() + "\"}";
    }
    return "{\"response\": \"error\" }";
  }



}
