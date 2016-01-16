package net.xaviersala.persons.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.xaviersala.persons.model.Person;

public class MemoryPersonDAO implements PersonDAO {

  Map<String, Person> persons;

  public MemoryPersonDAO() {
     persons = new HashMap<String, Person>();
  }

  @Override
  public List<Person> getPersons() {
    return new ArrayList<Person>(persons.values());
  }

  @Override
  public Person getPerson(String id) {
    if (persons.containsKey(id)) {
      return persons.get(id);
    }
    return null;
  }

  @Override
  public boolean addPerson(Person person) {
    if (persons.containsKey(person.getId())) {
       return false;
    }
    persons.put(person.getId(), person);
    return true;
  }

}
