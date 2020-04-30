package com.iooverflow.jdbc_better;

import java.util.Date;
import java.util.List;

import com.iooverflow.jdbc_better.beans.Person;
import com.iooverflow.jdbc_better.dao.PersonDao;
import com.iooverflow.jdbc_better.dao.impl.PersonDaoImpl;
import com.iooverflow.jdbc_better.jdbc.JdbcManager;
import com.iooverflow.jdbc_better.jdbc.impl.JdbcManagerImpl;

public final class DaoTest {

	public static void main(final String[] args) {
		
		
		final JdbcManager jdbcManager = new JdbcManagerImpl("jdbc:mysql://localhost:3306/betterjdbc", "root", "R@mpa5sword");
		
		final PersonDao personDao = new PersonDaoImpl(jdbcManager);
		
		System.out.println(personDao.find(1L));
		System.out.println("\n# People in NSW");
		final List<Person> peopleInNsw = personDao.findPeopleByState("NSW");
		for (final Person person : peopleInNsw) {
			System.out.println(person);
		}
		System.out.println("\n# All the people in the database");
		List<Person> allPeopleInDb = personDao.getAllPeople();
		for (final Person person : allPeopleInDb) {
			System.out.println(person);
		}

		final long id = jdbcManager.insertAndGetId(
				"INSERT INTO people (surname, given_name, street, city, state, country, postcode, birthday) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				"Kevin", "Lee", "999 ABC Street", "Sydney", "NSW", "Australia", "2000", new Date());
		System.out.println(id);
		System.out.println(jdbcManager.update(
				"INSERT INTO people (surname, given_name, street, city, state, country, postcode, birthday) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
				"Kevin", "Lee", "999 ABC Street", "Sydney", "NSW", "Australia", "2000", new Date()));

		System.out.println("\n# All the people in the database");
		allPeopleInDb = personDao.getAllPeople();
		for (final Person person : allPeopleInDb) {
			System.out.println(person);
		}

		System.exit(0);
	}

}
