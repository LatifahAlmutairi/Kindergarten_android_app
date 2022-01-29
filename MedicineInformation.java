package com.example.kindergarten;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MedicineInformation implements Serializable {
    String takingMedicine;
    String medicineName;
    String medicineTime;
    String ISheORsheHadAllergicis;

    String allergicType;
    String allergyFood;

    String DoesYourChildSufferAnAllergyToAnyKindOfFood;

    String HospitalName;
    String hospitalFileNumber;

    String DoesYourChildHavAfileInAHospital;

    String AcknowledgmentThatTheInformationIsCorrect;

    String key;
    String user_key;

    public  MedicineInformation(){}

    public String getTakingMedicine() {
        return takingMedicine;
    }

    public void setTakingMedicine(String takingMedicine) {
        this.takingMedicine = takingMedicine;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineTime() {
        return medicineTime;
    }

    public void setMedicineTime(String medicineTime) {
        this.medicineTime = medicineTime;
    }

    public String getAllergicType() {
        return allergicType;
    }

    public void setAllergicType(String allergicType) {
        this.allergicType = allergicType;
    }

    public String getAllergyFood() {
        return allergyFood;
    }

    public void setAllergyFood(String allergyFood) {
        this.allergyFood = allergyFood;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public String getHospitalFileNumber() {
        return hospitalFileNumber;
    }

    public void setHospitalFileNumber(String hospitalFileNumber) {
        this.hospitalFileNumber = hospitalFileNumber;
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

    public String getISheORsheHadAllergicis() {
        return ISheORsheHadAllergicis;
    }

    public void setISheORsheHadAllergicis(String ISheORsheHadAllergicis) {
        this.ISheORsheHadAllergicis = ISheORsheHadAllergicis;
    }

    public String getDoesYourChildSufferAnAllergyToAnyKindOfFood() {
        return DoesYourChildSufferAnAllergyToAnyKindOfFood;
    }

    public void setDoesYourChildSufferAnAllergyToAnyKindOfFood(String doesYourChildSufferAnAllergyToAnyKindOfFood) {
        DoesYourChildSufferAnAllergyToAnyKindOfFood = doesYourChildSufferAnAllergyToAnyKindOfFood;
    }

    public String getDoesYourChildHavAfileInAHospital() {
        return DoesYourChildHavAfileInAHospital;
    }

    public void setDoesYourChildHavAfileInAHospital(String doesYourChildHavAfileInAHospital) {
        DoesYourChildHavAfileInAHospital = doesYourChildHavAfileInAHospital;
    }

    public String getAcknowledgmentThatTheInformationIsCorrect() {
        return AcknowledgmentThatTheInformationIsCorrect;
    }

    public void setAcknowledgmentThatTheInformationIsCorrect(String acknowledgmentThatTheInformationIsCorrect) {
        AcknowledgmentThatTheInformationIsCorrect = acknowledgmentThatTheInformationIsCorrect;
    }

    public Map<String, Object> toMap() {


        HashMap<String, Object> result = new HashMap<>();
        result.put("takingMedicine",takingMedicine);
        result.put("medicineName",medicineName);
        result.put("medicineTime",medicineTime);
        result.put("allergicType",allergicType);
        result.put("allergyFood",allergyFood);
        result.put("HospitalName",HospitalName);
        result.put("hospitalFileNumber",hospitalFileNumber);

        result.put("user_key",user_key);

        return result;
    }
}
