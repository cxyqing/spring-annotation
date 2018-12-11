package com.servlet3.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.time.LocalDateTime;

public class UserListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public UserListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("UserListener...contextInitialized " + LocalDateTime.now());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("UserListener...contextDestroyed " + LocalDateTime.now());

    }


}
