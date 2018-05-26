package org.com.entity;

public class TblAdministrator {
    private Integer admId;

    private String admUser;

    private String admPass;

    public Integer getAdmId() {
        return admId;
    }

    public void setAdmId(Integer admId) {
        this.admId = admId;
    }

    public String getAdmUser() {
        return admUser;
    }

    public void setAdmUser(String admUser) {
        this.admUser = admUser == null ? null : admUser.trim();
    }

    public String getAdmPass() {
        return admPass;
    }

    public void setAdmPass(String admPass) {
        this.admPass = admPass == null ? null : admPass.trim();
    }

    @Override
    public String toString() {
        return "TblAdministrator{" +
                "admId=" + admId +
                ", admUser='" + admUser + '\'' +
                ", admPass='" + admPass + '\'' +
                '}';
    }
}