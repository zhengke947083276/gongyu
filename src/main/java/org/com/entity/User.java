package org.com.entity;

public class User {
    private int dId;
    private String dName;
    private String dPass;
    private int dAge;
    private String dSex;

    @Override
    public String toString() {
        return "User{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dPass='" + dPass + '\'' +
                ", dAge=" + dAge +
                ", dSex=" + dSex +
                '}';
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdPass() {
        return dPass;
    }

    public void setdPass(String dPass) {
        this.dPass = dPass;
    }

    public int getdAge() {
        return dAge;
    }

    public void setdAge(int dAge) {
        this.dAge = dAge;
    }

    public String getdSex() {
        return dSex;
    }

    public void setdSex(String dSex) {
        this.dSex = dSex;
    }
}
