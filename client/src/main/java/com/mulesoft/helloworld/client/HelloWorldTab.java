package com.mulesoft.helloworld.client;

import org.mule.galaxy.web.client.plugin.AbstractGwtPlugin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorldTab extends AbstractGwtPlugin {

    private final String url;

    public HelloWorldTab(String token, String tabName, String url) {
        super(token, tabName);
        this.url = url;
    }
    
    public native void register(String token, String className)
    /*-{
        var plugin = this;
        var callback = function() {
           plugin.@com.mulesoft.helloworld.client.HelloWorldTab::loadPlugin()();
        }
        $wnd.registerPlugin(token, this, callback);
    }-*/;
    
    public void load(final RootPanel insertPoint) {
        GWT.log("Loading " + url, null);

        Frame frame = new Frame(url);
        frame.setWidth("100%");
        frame.setHeight("450px");
        insertPoint.add(frame);
    }
}
