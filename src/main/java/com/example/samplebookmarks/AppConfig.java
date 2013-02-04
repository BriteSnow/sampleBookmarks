package com.example.samplebookmarks;

import java.io.IOException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.britesnow.snow.web.auth.AuthRequest;
import com.britesnow.snow.web.binding.EntityClasses;
import com.example.samplebookmarks.entity.BaseEntity;
import com.example.samplebookmarks.web.AppAuthRequest;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.metapossum.utils.scanner.reflect.ClassesInPackageScanner;

/**
 * TODO: Rename the package and the class name to fit your application naming convention and 
 * update /webapp/WEB-INF/snow.properties "snow.webApplicationModules" accordingly 
 * 
 * TODO: add/remove bindings to fit your application's need
 * 
 */
public class AppConfig extends AbstractModule {
    private static Logger log = LoggerFactory.getLogger(AppConfig.class);
    
    @Override
    protected void configure() {
        bind(AuthRequest.class).to(AppAuthRequest.class);
    }

    
    // Used by the Snow Hibernate helpers to inject the entity class
    // Just need to provide the @EntityClasses
    @Provides
    @Singleton
    @EntityClasses
    public Class[] provideEntityClasses() {
        // The simplest implementation, would be to harcode like
        // return new Class[]{com.example.samplebookmarks.entity.User.class,
        //                    com.example.samplebookmarks.entity.Item.class};
        
        // However, with few more line of code, we can have a maintenance free implementation 
        // by scanning the application entity.* java package.
        Set<Class<?>> entitySet;
        try {
            entitySet = new ClassesInPackageScanner().findAnnotatedClasses(BaseEntity.class.getPackage().getName(), javax.persistence.Entity.class);
            Class[] entityClasses = new Class[entitySet.size()];
            entitySet.toArray(entityClasses);
            return entityClasses;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Cannot get all the enity class: " + e.getMessage());
        }

    }
}
