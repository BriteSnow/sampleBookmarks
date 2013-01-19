package com.example.samplebookmarks.test;

import java.util.Map;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.britesnow.snow.testsupport.SnowTestSupport;
import com.britesnow.snow.testsupport.mock.RequestContextMock;
import com.britesnow.snow.testsupport.mock.RequestContextMockFactory.RequestMethod;
import com.britesnow.snow.util.MapUtil;

public class SampleWebRequestTests  extends SnowTestSupport {
    
    
    @BeforeClass
    public static void initTestClass() throws Exception {
        // Here we override one property to use the in memory DB
        Map props = MapUtil.mapIt("hibernate.connection.url","jdbc:hsqldb:mem:testdb");
        SnowTestSupport.initWebApplication("src/main/webapp",props);
    }    
    
    
    @Test
    public void quickHSQLTest(){
        RequestContextMock rc;
        Map result;
        
        rc = requestContextFactory.createRequestContext(RequestMethod.POST, "/api/user-login");
        rc.setParamMap(MapUtil.mapIt("userName", "john","pwd","welcome"));
        webController.service(rc);
        result = rc.getResponseAsJson();
        System.out.println(result);
        Assert.assertTrue((Boolean) result.get("success"));        
    }

}
