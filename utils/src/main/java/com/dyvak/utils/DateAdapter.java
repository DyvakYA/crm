package com.dyvak.utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> implements Serializable {

    public String marshal(Date date) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return dateFormat.format(date);
    }

    public Date unmarshal(String string) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return dateFormat.parse(string);
    }
}

