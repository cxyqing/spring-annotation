package com.mvc.service;

import com.mvc.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public Map<String,Object> findMapById(){
        return personDao.findMapById();
    }
}
