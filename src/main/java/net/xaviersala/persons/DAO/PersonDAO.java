package net.xaviersala.persons.DAO;

import java.util.List;

import net.xaviersala.persons.model.Person;

public interface PersonDAO {

  public List<Person> getPersons();
  public Person getPerson(String id);
  public boolean addPerson(Person person);

}
