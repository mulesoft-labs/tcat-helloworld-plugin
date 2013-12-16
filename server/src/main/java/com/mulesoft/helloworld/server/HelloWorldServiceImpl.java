package com.mulesoft.helloworld.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mule.galaxy.web.GwtFacet;
import org.mule.galaxy.web.WebManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mulesoft.helloworld.client.HelloWorldInfo;
import com.mulesoft.helloworld.client.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    public static final String PLUGIN_PROPERTIES = "helloworld.properties";
    public static final String PLUGIN_PROPERTIES_FILENAME = "helloworld.properties";
    private List<HelloWorldInfo> portals = new ArrayList<HelloWorldInfo>();
    private WebManager webManager;
    private Logger log = LoggerFactory.getLogger(getClass());
    private String configFolder;
    public void initialize() throws IOException {
        Properties props = new Properties();
        //Loading properties order is: System property -> config folder
        File propertiesFile;
        if(System.getProperty(PLUGIN_PROPERTIES) != null){
            propertiesFile = new File(System.getProperty(PLUGIN_PROPERTIES));
        } else{
            propertiesFile = new File(configFolder,PLUGIN_PROPERTIES_FILENAME);
            log.debug("Trying to load the plugin from path "+ propertiesFile.getAbsolutePath());
        }
        if(!propertiesFile.exists()){
            log.warn("Plugin properties not found, the plugin won't be loaded");
            return;
        }
        InputStream inputStream = new FileInputStream(propertiesFile);
        props.load(inputStream);

        for (int i = 0; true; i++) {
            String name = (String) props.get("portal." + i + ".tabName");
            if (name == null) break;

            String url = (String) props.get("portal." + i + ".url");
            String token = (String) props.get("portal." + i + ".token");

            if (url == null) {
                throw new IOException("portal." + i + ".url property is missing");
            }

            if (token == null) {
                throw new IOException("portal." + i + ".token property is missing");
            }

            portals.add(new HelloWorldInfo(name, url, token));

            // this is only null when testing
            if (webManager != null) {
                GwtFacet facet = new GwtFacet();
                facet.setName(name);
                facet.setToken(token);
                webManager.addGwtFacet(facet);
            }
        }
    }


    public void setWebManager(WebManager webManager) {
        this.webManager = webManager;
    }
    
    public void setConfigFolder(String configFolder) {
        this.configFolder = configFolder;
    }

    public List<HelloWorldInfo> getHelloWorld() {
        return portals;
    }

    public void setPortals(List<HelloWorldInfo> portals) {
        this.portals = portals;
    }
}
