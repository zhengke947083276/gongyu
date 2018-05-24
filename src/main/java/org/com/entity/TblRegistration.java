package org.com.entity;

import java.util.Date;

public class TblRegistration {
    private Integer regId;

    private Integer stuId;
    //学生对象
    private TblStudent tblStudent;

    private Date regTime;

    private Boolean regState;

    public TblStudent getTblStudent() {
        return tblStudent;
    }

    public void setTblStudent(TblStudent tblStudent) {
        this.tblStudent = tblStudent;
    }

    @Override
    public String toString() {
        return "TblRegistration{" +
                "regId=" + regId +
                ", stuId=" + stuId +
                ", tblStudent=" + tblStudent +
                ", regTime=" + regTime +
                ", regState=" + regState +
                '}';
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Boolean getRegState() {
        return regState;
    }

    public void setRegState(Boolean regState) {
        this.regState = regState;
    }
}