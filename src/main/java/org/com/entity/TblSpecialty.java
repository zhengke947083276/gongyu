package org.com.entity;

import java.util.List;

public class TblSpecialty {
    private Integer speId;

    private Integer facId;
    //学院对象
    private TblFaculty tblFaculty;
    private String speName;
    //学生集合
    private List<TblStudent> tblStudents;

    public Integer getSpeId() {
        return speId;
    }

    public TblFaculty getTblFaculty() {
        return tblFaculty;
    }

    public void setTblFaculty(TblFaculty tblFaculty) {
        this.tblFaculty = tblFaculty;
    }

    @Override
    public String toString() {
        return "TblSpecialty{" +
                "speId=" + speId +
                ", facId=" + facId +
                ", tblFaculty=" + tblFaculty +
                ", speName='" + speName + '\'' +
                ", tblStudents=" + tblStudents +
                '}';
    }

    public List<TblStudent> getTblStudents() {
        return tblStudents;
    }

    public void setTblStudents(List<TblStudent> tblStudents) {
        this.tblStudents = tblStudents;
    }

    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    public Integer getFacId() {
        return facId;
    }

    public void setFacId(Integer facId) {
        this.facId = facId;
    }

    public String getSpeName() {
        return speName;
    }

    public void setSpeName(String speName) {
        this.speName = speName == null ? null : speName.trim();
    }
}