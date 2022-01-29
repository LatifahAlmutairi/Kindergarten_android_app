package com.example.kindergarten;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ModelAdvertisment implements Serializable {

    private String ads;
    private String key;


    public ModelAdvertisment(){}


    public String getAds() {
        return ads;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> toMap() {


        HashMap<String, Object> result = new HashMap<>();
        result.put("ads", ads);
        return result;
    }
}
