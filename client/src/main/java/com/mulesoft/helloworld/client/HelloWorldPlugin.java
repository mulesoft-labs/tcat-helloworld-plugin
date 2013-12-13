package com.mulesoft.helloworld.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class HelloWorldPlugin implements EntryPoint {

    public HelloWorldPlugin() {
    }
    
    public void onModuleLoad() {
        GWT.log("Loading portal plugin.", null);
        HelloWorldServiceAsync portalSvc = (HelloWorldServiceAsync) GWT.create(HelloWorldService.class);

        ServiceDefTarget target = (ServiceDefTarget) portalSvc;
        String baseUrl = GWT.getModuleBaseURL();
        target.setServiceEntryPoint(baseUrl + "../handler/portal.rpc");
        
        // Load in all the listeners for portals
        portalSvc.getHelloWorld(new AsyncCallback<List<HelloWorldInfo>>() {

            public void onFailure(Throwable arg0) {
                GWT.log("Error getting portal information.", arg0);
            }

            public void onSuccess(List<HelloWorldInfo> portals) {
                for (HelloWorldInfo p : portals) {
                    GWT.log("Loading portal: " + p.getTabName(), null);
                    HelloWorldTab tab = new HelloWorldTab(p.getToken(), p.getTabName(), p.getUrl());
                    tab.onModuleLoad();
                }
            }
        });
    }
    
}
