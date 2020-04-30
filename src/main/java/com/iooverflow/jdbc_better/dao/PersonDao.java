package com.iooverflow.jdbc_better.dao;

import java.util.List;

import com.iooverflow.jdbc_better.beans.Person;

public interface PersonDao
{
  Person find(Long id);

  List<Person> findPeopleByState(String state);
  
  //public <T> T finPeopleByState(String state);

  List<Person> getAllPeople();

}