package com.example.kindergarten;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Personal_information_for_child implements Serializable {

    private String class1;
    private String semester;
    private String nationality;
    private String ID;
    private String firstname;
    private String fathername;
    private String grandfathername;
    private String familyname;
    private String passportnumber;
    private String birthDate;
    private String placeOfbirthCountry;
    private String placeOfbirthCity;
    private String bloodtype;
    private String houseOwnership;
    private String theAdministrativeRegion;
    private String city;
    private String district;
    private String street;
    private String mainStreet;
    private String housenumber;
    private String street2;
    private String mainStreet2;
    private String housenumber2;
    private String key ;
    private String user_key;

    private String imageId;

    public Personal_information_for_child() {
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getGrandfathername() {
        return grandfathername;
    }

    public void setGrandfathername(String grandfathername) {
        this.grandfathername = grandfathername;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(String passportnumber) {
        this.passportnumber = passportnumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPlaceOfbirthCountry() {
        return placeOfbirthCountry;
    }

    public void setPlaceOfbirthCountry(String placeOfbirthCountry) {
        this.placeOfbirthCountry = placeOfbirthCountry;
    }

    public String getPlaceOfbirthCity() {
        return placeOfbirthCity;
    }

    public void setPlaceOfbirthCity(String placeOfbirthCity) {
        this.placeOfbirthCity = placeOfbirthCity;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getHouseOwnership() {
        return houseOwnership;
    }

    public void setHouseOwnership(String houseOwnership) {
        this.houseOwnership = houseOwnership;
    }

    public String getTheAdministrativeRegion() {
        return theAdministrativeRegion;
    }

    public void setTheAdministrativeRegion(String theAdministrativeRegion) {
        this.theAdministrativeRegion = theAdministrativeRegion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getMainStreet() {
        return mainStreet;
    }

    public void setMainStreet(String mainStreet) {
        this.mainStreet = mainStreet;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getMainStreet2() {
        return mainStreet2;
    }

    public void setMainStreet2(String mainStreet2) {
        this.mainStreet2 = mainStreet2;
    }

    public String getHousenumber2() {
        return housenumber2;
    }

    public void setHousenumber2(String housenumber2) {
        this.housenumber2 = housenumber2;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }


    public Map<String, Object> toMap() {


        HashMap<String, Object> result = new HashMap<>();
        result.put("class1",class1);
        result.put("semester",semester);
        result.put("nationality", nationality);

        result.put("ID",ID);
        result.put("firstname", firstname);
        result.put("fathername", fathername);
        result.put("grandfathername", grandfathername);
        result.put("familyname", familyname);
        result.put("passportnumber", passportnumber);
        result.put("birthDate",birthDate);
        result.put("placeOfbirthCountry",placeOfbirthCountry);
        result.put("placeOfbirthCity",placeOfbirthCity);
        result.put("bloodtype",bloodtype);
        result.put("houseOwnership",houseOwnership);
        result.put("theAdministrativeRegion",theAdministrativeRegion);
        result.put("city",city);
        result.put("district",district);
        result.put("street",street);
        result.put("housenumber",housenumber);
        result.put("mainStreet",mainStreet);
        result.put("street2",street2);
        result.put("mainStreet2",mainStreet2);
        result.put("housenumber2",housenumber2);
        result.put("imageId",imageId);


        result.put("user_key",user_key);



        return result;
    }
}
