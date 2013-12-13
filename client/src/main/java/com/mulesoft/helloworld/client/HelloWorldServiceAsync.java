package com.mulesoft.helloworld.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HelloWorldServiceAsync {
    void getHelloWorld(AsyncCallback<List<HelloWorldInfo>> callback);
}
