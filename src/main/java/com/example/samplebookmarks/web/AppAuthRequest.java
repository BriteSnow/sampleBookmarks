package com.example.samplebookmarks.web;

import com.britesnow.snow.web.RequestContext;
import com.britesnow.snow.web.auth.AuthRequest;
import com.britesnow.snow.web.auth.AuthToken;
import com.example.samplebookmarks.entity.User;

public class AppAuthRequest implements AuthRequest<User> {

    @Override
    public AuthToken<User> authRequest(RequestContext rc) {
        // Note for this sample app, we store the user in the session, 
        // but for production application, use stateless authentication mechanism for 
        // better sclability.
        
        // RequestContext is a convenient Snow wrapper on top of HttpServletRequest, 
        //  and HttpServletResponse
        // rc.getReq() return the HttpServletRequest 
        User user = (User) rc.getReq().getSession().getAttribute("user");
        
        if (user != null){
            AuthToken<User> authToken = new AuthToken<User>();
            authToken.setUser(user);
            return authToken;
        }else{
            return null;
        }
    }

}
