package com.example.samplebookmarks.web;

import java.util.Map;

import javax.inject.Inject;

import com.britesnow.snow.web.handler.annotation.WebModelHandler;
import com.britesnow.snow.web.param.annotation.WebModel;
import com.britesnow.snow.web.param.annotation.WebUser;
import com.example.samplebookmarks.dao.ItemDao;
import com.example.samplebookmarks.entity.User;
import com.google.inject.Singleton;


@Singleton
public class MultiPageWebHandlers {

    @Inject
    private ItemDao itemDao;
    
    @WebModelHandler(startsWith="/")
    public void allPages(@WebModel Map m){
        m.put("version", "1.1.0");
    }
    
    /**
     * 
     * @param m (@WebModel) will be injected by Snow, and it is the WebModel for the page 
     * @param user (@WebUser) will be injected by Snow, and represents the Authenticate user. Null if nobody authenticated.
     */
    @WebModelHandler(startsWith="/bookmarks")
    public void bookmarksPage(@WebModel Map m, @WebUser User user){
        if (user != null){
            m.put("items", itemDao.getItemsForUser(user.getId()));
        }
    }
}
