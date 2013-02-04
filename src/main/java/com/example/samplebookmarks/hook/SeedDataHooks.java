package com.example.samplebookmarks.hook;

import com.britesnow.snow.web.db.hibernate.HibernateDaoHelper;
import com.britesnow.snow.web.db.hibernate.HibernateSessionInViewHandler;
import com.britesnow.snow.web.hook.AppPhase;
import com.britesnow.snow.web.hook.On;
import com.britesnow.snow.web.hook.annotation.WebApplicationHook;
import com.example.samplebookmarks.dao.ItemDao;
import com.example.samplebookmarks.dao.UserDao;
import com.example.samplebookmarks.entity.Item;
import com.example.samplebookmarks.entity.User;
import com.google.inject.Singleton;

@Singleton
public class SeedDataHooks {

    /**
     * This will be called to see the database (for demo only)
     * 
     * @param itemDao
     *            will be injected by Snow with the Guice binding
     * @param userDao
     *            will be injected by Snow with the Guice binding
     * @param inView
     *            will be injected by Snow with the Guice binding (needed to open the connection for this thread to use
     *            daoHelper)
     * 
     */
    @WebApplicationHook(phase = AppPhase.INIT)
    public void seedStore(ItemDao itemDao, UserDao userDao, HibernateSessionInViewHandler inView) {
        inView.openSessionInView();
        for (String[] uvs : seedUsers) {
            String userName = uvs[0];
            if (userDao.getUserByUserName(userName) == null) {
                User newUser = new User(uvs[0], uvs[1], uvs[2], uvs[3]);
                newUser = userDao.save(newUser);
                Long userId = newUser.getId();

                for (String[] ivs : defaultItems) {
                    Item item = new Item(ivs[0], ivs[1], ivs[2]);
                    item.setUser_id(userId);
                    itemDao.save(item);
                }
            }
        }
        inView.closeSessionInView();
    }

    /**
     * Using HSQLDB we need to shutdown the database to be written in the file system.
     * 
     * Note that if you do not shutdown your webapp gracefully, the data won't be written to disk. 
     * 
     * @param inView
     * @param daoHelper
     */
    @WebApplicationHook(phase = AppPhase.SHUTDOWN,on=On.BEFORE)
    public void shutdownDb(HibernateSessionInViewHandler inView, HibernateDaoHelper daoHelper){
        try {
            inView.openSessionInView();
            daoHelper.getConnection().prepareStatement("shutdown compact").execute();
            inView.closeSessionInView();
        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    
    // --------- Some Seed Data --------- //
    private static String[][] seedUsers    = { { "john", "welcome", "John", "Doe" },
            { "jen", "welcome", "Jennifer", "Donavan" } };

    private static String[][] defaultItems = {
            { "Google", "http://google.com", "Search anything and anywhere (Might get some G+ result in the mix)" },
            { "snow", "http://britesnow.com/snow", "Lightweight, highly productive, Java Web Framework" },
            { "brite.js", "http://britesnow.com/brite", "Lightweight, jQuery based MVC, javascript framework" } };
    // --------- Some Seed Data --------- //
            

}
