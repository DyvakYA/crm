package com.dyvak.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationUtils {

    private static final String MSG_PROPERTIES_BASE_PATH = "messages";
    private static final String LABEL_PROPERTIES_BASE_PATH = "labels";

    public String getLocalizedMessage(Locale locale, String resourceName) {
        return getString(locale, resourceName, MSG_PROPERTIES_BASE_PATH);
    }

    public String getLocalizedLabel(Locale locale, String resourceName) {
        return getString(locale, resourceName, LABEL_PROPERTIES_BASE_PATH);
    }

    public String getString(Locale locale, String resourceName, String propertiesPath) {
        return ResourceBundle.getBundle(propertiesPath, locale).getString(resourceName);
    }
}
