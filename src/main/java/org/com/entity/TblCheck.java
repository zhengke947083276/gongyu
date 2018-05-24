package org.com.entity;

import java.util.Date;

public class TblCheck {
    private Integer checkId;

    private Integer dormId;

    //宿舍对象
    private TblDorm tblDorm;

    private Integer stuId;

    //学生对象
    private TblStudent tblStudent;

    private Date checkInTime;

    private Date checkOutTime;

    private Boolean checkState;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Boolean getCheckState() {
        return checkState;
    }

    public TblDorm getTblDorm() {
        return tblDorm;
    }

    public void setTblDorm(TblDorm tblDorm) {
        this.tblDorm = tblDorm;
    }

    public TblStudent getTblStudent() {
        return tblStudent;
    }

    public void setTblStudent(TblStudent tblStudent) {
        this.tblStudent = tblStudent;
    }

    @Override
    public String toString() {
        return "TblCheck{" +
                "checkId=" + checkId +
                ", dormId=" + dormId +
                ", tblDorm=" + tblDorm +
                ", stuId=" + stuId +
                ", tblStudent=" + tblStudent +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                ", checkState=" + checkState +
                '}';
    }

    public void setCheckState(Boolean checkState) {
        this.checkState = checkState;
    }
}