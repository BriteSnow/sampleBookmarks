package com.example.samplebookmarks.dao;

import com.example.samplebookmarks.entity.User;
import com.google.inject.Singleton;

@Singleton
public class UserDao extends BaseHibernateDao<User> {
    
    
    public User getUserByUserName(String userName){
        return (User) daoHelper.findFirst("from " + entityClass.getSimpleName() + " where userName = ?", userName);
    }
}
