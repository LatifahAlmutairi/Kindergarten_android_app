package com.example.kindergarten;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class parentPledges implements Serializable {

    String parentpladegeName;
    String user_key;
    String key;
    String NO_OR_YES;

    public parentPledges(){}


    public String getParentpladegeName() {
        return parentpladegeName;
    }

    public void setParentpladegeName(String parentpladegeName) {
        this.parentpladegeName = parentpladegeName;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public String getKey() {
        return key;
    }



    public void setKey(String key) {
        this.key = key;
    }

    public String getNO_OR_YES() {
        return NO_OR_YES;
    }

    public void setNO_OR_YES(String NO_OR_YES) {
        this.NO_OR_YES = NO_OR_YES;
    }

    public Map<String, Object> toMap() {


        HashMap<String, Object> result = new HashMap<>();
        result.put("parentpladegeName",parentpladegeName);
        result.put("user_key",user_key);

        return result;
    }
}
