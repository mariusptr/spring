package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person> {


        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setBirth_date(resultSet.getTimestamp("birth_date"));
            person.setLocation(resultSet.getString("location"));
            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonRowMapper());
    }

    public Person findByID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON where id=?", new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete FROM PERSON where id=?", new Object[]{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date)" +
                        "values (?, ?, ?, ?)",
                new Object[]{person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime())});
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person "
                        + " set name = ?, location = ?, birth_date = ? " +
                        " where id = ?",
                new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirth_date().getTime()), person.getId()});
    }

}
