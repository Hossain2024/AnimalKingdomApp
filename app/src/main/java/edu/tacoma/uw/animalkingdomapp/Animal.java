package edu.tacoma.uw.animalkingdomapp;

import java.io.Serializable;

public class Animal implements Serializable {
    private int mId;
    private String nName;
    private String mKind;

    public final static String ID = "id";

    public final static String KIND = "kind";

    public final static String NAME = "name";

    public Animal(int id, String name, String kind){
        this.mId = id;
        this.nName = name;
        this.mKind = kind;
    }


    public int  getId(){
        return mId;
    }

    public void setId(int id){
        this.mId = id;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public String getKind(){
        return mKind;
    }

    public void setKind(String kind){
        this.mKind = kind;
    }


}
