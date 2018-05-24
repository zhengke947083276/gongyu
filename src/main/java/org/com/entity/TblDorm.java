package org.com.entity;

import java.util.List;

public class TblDorm {
    private Integer dormId;

    private String dormName;

    private Integer dormState;

    //入住信息集合
    private List<TblCheck> tblChecks;

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public String getDormName() {
        return dormName;
    }

    public void setDormName(String dormName) {
        this.dormName = dormName == null ? null : dormName.trim();
    }

    public Integer getDormState() {
        return dormState;
    }

    public List<TblCheck> getTblChecks() {
        return tblChecks;
    }

    @Override
    public String toString() {
        return "TblDorm{" +
                "dormId=" + dormId +
                ", dormName='" + dormName + '\'' +
                ", dormState=" + dormState +
                ", tblChecks=" + tblChecks +
                '}';
    }

    public void setTblChecks(List<TblCheck> tblChecks) {
        this.tblChecks = tblChecks;
    }

    public void setDormState(Integer dormState) {
        this.dormState = dormState;
    }
}