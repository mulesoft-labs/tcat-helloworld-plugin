package com.mulesoft.helloworld.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;

public interface HelloWorldService extends RemoteService  {
    List<HelloWorldInfo> getHelloWorld();
}
