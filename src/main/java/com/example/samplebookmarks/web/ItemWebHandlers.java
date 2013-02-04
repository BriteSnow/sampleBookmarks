package com.example.samplebookmarks.web;

import java.util.List;

import javax.inject.Inject;

import com.britesnow.snow.web.param.annotation.PathVar;
import com.britesnow.snow.web.param.annotation.WebParam;
import com.britesnow.snow.web.param.annotation.WebUser;
import com.britesnow.snow.web.rest.annotation.WebDelete;
import com.britesnow.snow.web.rest.annotation.WebGet;
import com.britesnow.snow.web.rest.annotation.WebPost;
import com.example.samplebookmarks.dao.ItemDao;
import com.example.samplebookmarks.entity.Item;
import com.example.samplebookmarks.entity.User;
import com.google.inject.Singleton;

@Singleton
public class ItemWebHandlers {

    @Inject
    public ItemDao itemDao;

    @WebPost("/api/user-create-item")
    public WebResponse apiUserCreateItem(@WebUser User user, @WebParam("title") String title,
                            @WebParam("url") String url, @WebParam("note") String note) {
        if (user != null) {
            try {
                Item item = new Item(title, url, note);
                item.setUser_id(user.getId());
                item = itemDao.save(item);
                return WebResponse.success(item);
            } catch (Throwable t) {
                return WebResponse.fail(t);
            }
        }
        return WebResponse.fail("Not logged in, no create.");
    }

    @WebDelete("/api/user-item-{id}")
    public WebResponse apiUserDeleteItem(@WebUser User user, @PathVar("id") Long id) {
        if (user != null) {
            try {
                itemDao.delete(id);
                return WebResponse.success(id);
            } catch (Throwable t) {
                return WebResponse.fail(t);
            }
        }
        return WebResponse.fail("Not logged in, no delete.");
    }

    @WebGet("/api/user-items")
    public WebResponse apiUserItems(@WebUser User user) {
        if (user != null) {
            try {
                List<Item> items = itemDao.getItemsForUser(user.getId());
                return WebResponse.success(items);
            } catch (Throwable t) {
                return WebResponse.fail(t);
            }
        }
        return WebResponse.fail("Not logged in, no item list.");
    }

}