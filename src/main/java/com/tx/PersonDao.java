package com.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addPerson(){
        String sql = "INSERT INTO `ggpt`.`ad_person`(`birth`, `email`, `last_name`) VALUES ('2018-10-27', ?, ?)";
        String source = UUID.randomUUID().toString().substring(0, 3);
        String email = source + "@qq.com";
        String lastName = source;
        jdbcTemplate.update(sql,email,lastName);
    }
}
