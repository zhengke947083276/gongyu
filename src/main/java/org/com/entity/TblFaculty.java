package org.com.entity;

import java.util.List;

public class TblFaculty {
    private Integer facId;

    private String facName;
    //多个专业
    private List<TblSpecialty> tblSpecialties;

    public Integer getFacId() {
        return facId;
    }

    public void setFacId(Integer facId) {
        this.facId = facId;
    }

    public String getFacName() {
        return facName;
    }

    @Override
    public String toString() {
        return "TblFaculty{" +
                "facId=" + facId +
                ", facName='" + facName + '\'' +
                ", tblSpecialties=" + tblSpecialties +
                '}';
    }

    public List<TblSpecialty> getTblSpecialties() {
        return tblSpecialties;
    }

    public void setTblSpecialties(List<TblSpecialty> tblSpecialties) {
        this.tblSpecialties = tblSpecialties;
    }

    public void setFacName(String facName) {
        this.facName = facName == null ? null : facName.trim();
    }
}