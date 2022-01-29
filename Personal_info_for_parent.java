package com.example.kindergarten;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Personal_info_for_parent implements Serializable {

    private String name;
    private String nationality;
    private String relationship;
    private String Id_type;
    private String dateOfId;
    private String sourceOfId;
    private String endOfId;
    //مصدر الهوية ونهايتها
    private String homephone;
    private String mobileNumber;
    private String workphone;


    private String relativeName1_name;
    private String relativeName1_phone;
    private String relativeName1_address;

    private String relativeName2_name;
    private String relativeName2_phone;
    private String relativeName2_address;

    private String user_key;
    private String key;

    String AcknowledgmentThatTheInformationIsCorrect;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getId_type() {
        return Id_type;
    }

    public void setId_type(String id_type) {
        Id_type = id_type;
    }

    public String getDateOfId() {
        return dateOfId;
    }

    public void setDateOfId(String dateOfId) {
        this.dateOfId = dateOfId;
    }

    public String getSourceOfId() {
        return sourceOfId;
    }

    public void setSourceOfId(String sourceOfId) {
        this.sourceOfId = sourceOfId;
    }

    public String getEndOfId() {
        return endOfId;
    }

    public void setEndOfId(String endOfId) {
        this.endOfId = endOfId;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getRelativeName1_name() {
        return relativeName1_name;
    }

    public void setRelativeName1_name(String relativeName1_name) {
        this.relativeName1_name = relativeName1_name;
    }

    public String getRelativeName1_phone() {
        return relativeName1_phone;
    }

    public void setRelativeName1_phone(String relativeName1_phone) {
        this.relativeName1_phone = relativeName1_phone;
    }

    public String getRelativeName1_address() {
        return relativeName1_address;
    }

    public void setRelativeName1_address(String relativeName1_address) {
        this.relativeName1_address = relativeName1_address;
    }

    public String getRelativeName2_name() {
        return relativeName2_name;
    }

    public void setRelativeName2_name(String relativeName2_name) {
        this.relativeName2_name = relativeName2_name;
    }

    public String getRelativeName2_phone() {
        return relativeName2_phone;
    }

    public void setRelativeName2_phone(String relativeName2_phone) {
        this.relativeName2_phone = relativeName2_phone;
    }

    public String getRelativeName2_address() {
        return relativeName2_address;
    }

    public void setRelativeName2_address(String relativeName2_address) {
        this.relativeName2_address = relativeName2_address;
    }

    public String getAcknowledgmentThatTheInformationIsCorrect() {
        return AcknowledgmentThatTheInformationIsCorrect;
    }

    public void setAcknowledgmentThatTheInformationIsCorrect(String acknowledgmentThatTheInformationIsCorrect) {
        AcknowledgmentThatTheInformationIsCorrect = acknowledgmentThatTheInformationIsCorrect;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public Map<String, Object> toMap() {


        HashMap<String, Object> result = new HashMap<>();
        result.put("name",name);
        result.put("nationality",nationality);
        result.put("relationship",relationship);

        result.put("Id_type",Id_type);
        result.put("dateOfId",dateOfId);
        result.put("endOfId",endOfId);
        result.put("sourceOfId",sourceOfId);

        result.put("homephone",homephone);
        result.put("mobileNumber",mobileNumber);
        result.put("workphone",workphone);
        result.put("relativeName1_name",relativeName1_name);
        result.put("relativeName1_phone",relativeName1_phone);
        result.put("relativeName1_address",relativeName1_address);

        result.put("relativeName2_name",relativeName2_name);
        result.put("relativeName2_phone",relativeName2_phone);
        result.put("relativeName2_address",relativeName2_address);




        result.put("user_key",user_key);



        return result;
    }



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
