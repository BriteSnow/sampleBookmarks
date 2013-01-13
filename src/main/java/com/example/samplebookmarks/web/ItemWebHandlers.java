package com.example.samplebookmarks.web;


import javax.inject.Inject;

import com.britesnow.snow.web.handler.annotation.WebActionHandler;
import com.britesnow.snow.web.param.annotation.WebParam;
import com.britesnow.snow.web.param.annotation.WebUser;
import com.example.samplebookmarks.dao.ItemDao;
import com.example.samplebookmarks.entity.Item;
import com.example.samplebookmarks.entity.User;
import com.google.inject.Singleton;

@Singleton
public class ItemWebHandlers {

    @Inject
    public ItemDao itemDao;

    @WebActionHandler(name = "api/user-create-item")
    public WebResponse apiUserCreateItem(@WebUser User user, @WebParam("title") String title, @WebParam("url") String url,
                            @WebParam("note") String note) {
        Item item = null;
        if (user != null){
            try{
                item = new Item(title, url, note);
                item.setUser_id( user.getId());
                item = itemDao.save(item);
                return WebResponse.success(item);
            }catch(Throwable t){
                return WebResponse.fail(t);
            }
        }
        return WebResponse.fail("Not logged in, no create.");
    }
    
    @WebActionHandler(name= "api/user-delete-item")
    public WebResponse apiUserDeleteItem(@WebUser User user, @WebParam("id") Long id){
        if (user != null){
            try{
                itemDao.delete(id);
                return WebResponse.success(id);
            }catch(Throwable t){
                return WebResponse.fail(t);
            }
        }
        return WebResponse.fail("Not logged in, no delete.");
    }
    
    /*
    @WebModelHandler(startsWith = "api/user-items")
    public WebResponse apiUserItems(@WebModel Map m, @WebUser User user){
        ///...
    }
    */

}