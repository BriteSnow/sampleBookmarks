package com.example.samplebookmarks.dao;

import java.util.List;
import java.util.Map;

import com.britesnow.snow.util.MapUtil;
import com.example.samplebookmarks.entity.Item;
import com.google.inject.Singleton;

@Singleton
public class ItemDao extends BaseHibernateDao<Item> {

    public List<Item> getItemsForUser(Long userId){
        Map matchProp = MapUtil.mapIt("user_id",userId);
        return list(0,300,matchProp,"title",null);
    }
}


