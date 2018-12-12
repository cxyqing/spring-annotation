package com.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String,Object> findMapById(){
        String sql = "select * from ad_person where id = 28";
        return jdbcTemplate.queryForMap(sql);
    }
}
