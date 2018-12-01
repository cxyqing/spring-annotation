package com.ex.bean;

import org.springframework.beans.factory.FactoryBean;

public class DepartmentFactoryBean implements FactoryBean<Department> {
    @Override
    public Department getObject() throws Exception {
        return new Department();
    }

    @Override
    public Class<?> getObjectType() {
        return Department.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
