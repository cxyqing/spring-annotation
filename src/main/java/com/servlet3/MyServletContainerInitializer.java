package com.servlet3;

import com.servlet3.filter.UserFilter;
import com.servlet3.listener.UserListener;
import com.servlet3.service.StudentService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

@HandlesTypes({StudentService.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        c.forEach(System.out::println);
        ctx.addListener(UserListener.class);
        ServletRegistration.Dynamic userServlet = ctx.addServlet("userServlet", "com.servlet3.servlet.UserServlet");
        userServlet.addMapping("/userServlet");
        FilterRegistration.Dynamic userFilter = ctx.addFilter("userFilter", new UserFilter());
        userFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
    }
}
