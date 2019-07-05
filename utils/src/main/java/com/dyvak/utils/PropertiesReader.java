package com.dyvak.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;


public class PropertiesReader {

    private static ResourceBundle properties;

    static {
        loadResourceBundle();
    }

    public PropertiesReader() {
    }

    public static String getProperty(String name) {
        return properties.getString(name);
    }

    private static void loadResourceBundle() {
        try {
            File propFile = new File("/opt/oracle/applconfig/");
            URL[] urls = {propFile.toURI().toURL()};
            ClassLoader loader = new URLClassLoader(urls);
            properties = ResourceBundle.getBundle("customproperties", Locale.getDefault(), loader);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}