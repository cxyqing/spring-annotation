package com.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("importClassName: " + importingClassMetadata.getClassName());
        return new String[]{"com.ex.bean.Employee","com.config.AppConfig"};
    }
}
