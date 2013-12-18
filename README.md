Tcat helloworld plugin
======================

A template of a Tcat plugin
----------------------

A plugin in Tcat is composed by tree components:

* A GWT Client
* A Spring based backend service
* A plugin distribution that bundles these two together with a property file to configure them

This example shows how to embed a web page into a new Tcat tab.

Installing a plugin is pretty simple, all you have to do is:

* Create a plugins diresctory into the ${tcat.home}/webapps/console/WEB-INF/ folder
* Copy the zip file you generate from the deistribution maven artifact
* Start/restart Tcat

Hot deployemnt are not supported yet