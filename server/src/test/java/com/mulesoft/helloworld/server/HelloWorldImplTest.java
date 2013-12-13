package com.mulesoft.helloworld.server;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.xmlbeans.impl.tool.XSTCTester.TestCase;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mulesoft.helloworld.client.HelloWorldInfo;

public class HelloWorldImplTest {
    
    @BeforeClass
    public static void setSystemProperties(){
        System.setProperty("helloworld.properties", "./src/test/resources/helloworld.properties");
    }
    
    @Test
    public void testProps() throws Exception {
       
        HelloWorldServiceImpl svc = new HelloWorldServiceImpl();
        svc.initialize();

        List<HelloWorldInfo> portals = svc.getHelloWorld();
        assertNotNull(portals);
        assertEquals(1, portals.size());

        HelloWorldInfo p = portals.iterator().next();
        assertEquals("google", p.getToken());
    }
}
