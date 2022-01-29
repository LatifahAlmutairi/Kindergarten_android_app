package com.example.kindergarten;

import android.widget.EditText;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ModelInterview implements Serializable {

    String  familyNum;
    String  Arrange;
    String  Brothers;
    String Sisters;
    String  liveWith;
    String peopleAthome;
    String  otherKindergarten;
    String favoGame;
    String playWith;
    String  haveNanny;
    String sleepQuiet;
    String sleepPrivate;
    String expressFeeling;
    String  fear;
    String  favoFood;
    String dependbathroom;
    String needToRemiander;
    String goodbehavior;
    String childMisbehaves;
    String childCharacter;
    String note;
    String chronicDiseases;

    String key;
    String user_key;

    public String getFamilyNum() {
        return familyNum;
    }

    public void setFamilyNum(String familyNum) {
        this.familyNum = familyNum;
    }

    public String getArrange() {
        return Arrange;
    }

    public void setArrange(String arrange) {
        Arrange = arrange;
    }

    public String getBrothers() {
        return Brothers;
    }

    public void setBrothers(String brothers) {
        Brothers = brothers;
    }

    public String getSisters() {
        return Sisters;
    }

    public void setSisters(String sisters) {
        Sisters = sisters;
    }

    public String getLiveWith() {
        return liveWith;
    }

    public void setLiveWith(String liveWith) {
        this.liveWith = liveWith;
    }

    public String getPeopleAthome() {
        return peopleAthome;
    }

    public void setPeopleAthome(String peopleAthome) {
        this.peopleAthome = peopleAthome;
    }

    public String getOtherKindergarten() {
        return otherKindergarten;
    }

    public void setOtherKindergarten(String otherKindergarten) {
        this.otherKindergarten = otherKindergarten;
    }

    public String getFavoGame() {
        return favoGame;
    }

    public void setFavoGame(String favoGame) {
        this.favoGame = favoGame;
    }

    public String getPlayWith() {
        return playWith;
    }

    public void setPlayWith(String playWith) {
        this.playWith = playWith;
    }

    public String getHaveNanny() {
        return haveNanny;
    }

    public void setHaveNanny(String haveNanny) {
        this.haveNanny = haveNanny;
    }

    public String getSleepQuiet() {
        return sleepQuiet;
    }

    public void setSleepQuiet(String sleepQuiet) {
        this.sleepQuiet = sleepQuiet;
    }

    public String getSleepPrivate() {
        return sleepPrivate;
    }

    public void setSleepPrivate(String sleepPrivate) {
        this.sleepPrivate = sleepPrivate;
    }

    public String getExpressFeeling() {
        return expressFeeling;
    }

    public void setExpressFeeling(String expressFeeling) {
        this.expressFeeling = expressFeeling;
    }

    public String getFear() {
        return fear;
    }

    public void setFear(String fear) {
        this.fear = fear;
    }

    public String getFavoFood() {
        return favoFood;
    }

    public void setFavoFood(String favoFood) {
        this.favoFood = favoFood;
    }

    public String getDependbathroom() {
        return dependbathroom;
    }

    public void setDependbathroom(String dependbathroom) {
        this.dependbathroom = dependbathroom;
    }

    public String getNeedToRemiander() {
        return needToRemiander;
    }

    public void setNeedToRemiander(String needToRemiander) {
        this.needToRemiander = needToRemiander;
    }

    public String getGoodbehavior() {
        return goodbehavior;
    }

    public void setGoodbehavior(String goodbehavior) {
        this.goodbehavior = goodbehavior;
    }

    public String getChildMisbehaves() {
        return childMisbehaves;
    }

    public void setChildMisbehaves(String childMisbehaves) {
        this.childMisbehaves = childMisbehaves;
    }

    public String getChildCharacter() {
        return childCharacter;
    }

    public void setChildCharacter(String childCharacter) {
        this.childCharacter = childCharacter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getChronicDiseases() {
        return chronicDiseases;
    }

    public void setChronicDiseases(String chronicDiseases) {
        this.chronicDiseases = chronicDiseases;
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
        result.put("familyNum",familyNum);
        result.put("Arrange",Arrange);
        result.put("Brothers",Brothers);
        result.put("Sisters",Sisters);
        result.put("liveWith",liveWith);
        result.put("PeopleAtHome",peopleAthome);
        result.put("otherKindergarten",otherKindergarten);
        result.put("favoGame",favoGame);
        result.put("playWith",playWith);
        result.put("haveNanny",haveNanny);
        result.put("sleepQuiet",sleepQuiet);
        result.put("sleepPrivate",sleepPrivate);
        result.put("expressFeeling",expressFeeling);
        result.put("fear",fear);
        result.put("favoFood",favoFood);
        result.put("dependbathroom",dependbathroom);
        result.put("needToRemiander",needToRemiander);
        result.put("goodbehavior",goodbehavior);
        result.put("childMisbehaves",childMisbehaves);
        result.put("childCharacter",childCharacter);
        result.put("chronicDiseases",chronicDiseases);
        result.put("note",note);



        result.put("user_key",user_key);

        return result;
    }
}
