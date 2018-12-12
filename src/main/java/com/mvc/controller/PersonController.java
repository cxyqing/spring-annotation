package com.mvc.controller;

import com.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private PersonService personService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        Arrays.stream(ctx.getParent().getBeanDefinitionNames()).forEach(System.out::println);
        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("is contains  service: " + ctx.containsBean("personService"));
        System.out.println(ctx.getBean(DataSource.class));
        return LocalDateTime.now().toString();
    }
//    @ResponseBody
    @GetMapping("/person")
    public void getMapById(Writer writer) throws IOException {
        Map<String, Object> mapById = personService.findMapById();
        writer.write(mapById.toString());
    }

    @ResponseBody
    @GetMapping("/persons")
    public List<Map<String,Object>> getAll(){
        String sql = "select * from ad_person";

        return jdbcTemplate.queryForList(sql);
    }
}
