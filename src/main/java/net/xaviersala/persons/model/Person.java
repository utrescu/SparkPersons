package net.xaviersala.persons.model;

public class Person {

  String id;
  String firstName;
  String lastName;

  public Person() {

  }

  public Person(String identity, String first, String last) {
    id = identity;
    firstName = first;
    lastName = last;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public boolean isValid() {
    return (id != null && firstName != null );
  }
}
