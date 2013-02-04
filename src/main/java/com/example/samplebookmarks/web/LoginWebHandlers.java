package com.example.samplebookmarks.web;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;

import com.britesnow.snow.web.RequestContext;
import com.britesnow.snow.web.param.annotation.WebParam;
import com.britesnow.snow.web.rest.annotation.WebPost;
import com.example.samplebookmarks.dao.UserDao;
import com.example.samplebookmarks.entity.User;

@Singleton
public class LoginWebHandlers {

    @Inject
    private UserDao userDao;
    
    
    /**
     * Note 1: for production, use stateless login (as shown in http://britesnow.com/snow/authrequest)
     * Note 2: Here the RequestContext will be injected 
     *          (could have Injected HttpServletRequest directly as well)
     */
    @WebPost("/api/user-login")
    public WebResponse login(@WebParam("userName")String userName, @WebParam("pwd")String pwd, RequestContext rc){
        User user = userDao.getUserByUserName(userName);
        
        if (user != null && pwd != null && pwd.equals(user.getPassword())){
            rc.getReq().getSession().setAttribute("user", user);
            return WebResponse.success();
        }else{
            return WebResponse.fail("Wrong username or password.");
        }

    }
    
    /**
     * Note: Here we show how we can inject HttpServletRequest directly
     * @param req
     */
    @WebPost("/api/user-logoff")
    public void logoff(HttpServletRequest req){
        req.getSession().removeAttribute("user");
    }
    
    
    
    
}
