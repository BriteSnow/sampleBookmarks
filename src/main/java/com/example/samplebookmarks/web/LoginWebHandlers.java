package com.example.samplebookmarks.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.britesnow.snow.web.RequestContext;
import com.britesnow.snow.web.handler.annotation.WebActionHandler;
import com.britesnow.snow.web.param.annotation.WebParam;
import com.example.samplebookmarks.dao.UserDao;
import com.example.samplebookmarks.entity.User;

@Singleton
public class LoginWebHandlers {

    @Inject
    private UserDao userDao;
    
    
    /**
     * NOTE: for production, use stateless login (as shown in http://britesnow.com/snow/authrequest)
     * 
     * @return
     */
    @WebActionHandler(name="api/user-login")
    public WebResponse login(@WebParam("userName")String userName, @WebParam("pwd")String pwd, RequestContext rc){
        User user = userDao.getUserByUserName(userName);
        
        if (user != null && pwd != null && pwd.equals(user.getPassword())){
            rc.getReq().getSession().setAttribute("user", user);
            return WebResponse.success();
        }else{
            List<User> users = userDao.list(0,200,null,null);
            System.out.println("users.size: " + users.size());
            return WebResponse.fail();
        }

    }
    
    @WebActionHandler(name="api/user-logoff")
    public void logoff(RequestContext rc){
        rc.getReq().getSession().removeAttribute("user");
    }
    
    
    
    
}
