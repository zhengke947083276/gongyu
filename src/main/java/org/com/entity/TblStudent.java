package org.com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class TblStudent {
    private Integer stuId;

    private String stuNo;

    private String stuPeriod;

    private String stuName;

    private Integer speId;

    //专业
    private TblSpecialty tblSpecialty;

    //出入信息集合
    private List<TblRegistration> tblRegistrations;

    private TblCheck tblCheck;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date stuBirthday;

    private Boolean stuSex;

    private String stuPhone;

    private String stuPicture;

    private String stuAddress;

    private Integer stuState;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public TblSpecialty getTblSpecialty() {
        return tblSpecialty;
    }

    public void setTblSpecialty(TblSpecialty tblSpecialty) {
        this.tblSpecialty = tblSpecialty;
    }

    @Override
    public String toString() {
        return "TblStudent{" +
                "stuId=" + stuId +
                ", stuNo='" + stuNo + '\'' +
                ", stuPeriod='" + stuPeriod + '\'' +
                ", stuName='" + stuName + '\'' +
                ", speId=" + speId +
                ", tblSpecialty=" + tblSpecialty +
                ", tblRegistrations=" + tblRegistrations +
                ", tblCheck=" + tblCheck +
                ", stuBirthday=" + stuBirthday +
                ", stuSex=" + stuSex +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuPicture='" + stuPicture + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuState=" + stuState +
                '}';
    }

    public List<TblRegistration> getTblRegistrations() {
        return tblRegistrations;
    }

    public void setTblRegistrations(List<TblRegistration> tblRegistrations) {
        this.tblRegistrations = tblRegistrations;
    }

    public TblCheck getTblCheck() {
        return tblCheck;
    }

    public void setTblCheck(TblCheck tblCheck) {
        this.tblCheck = tblCheck;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public String getStuPeriod() {
        return stuPeriod;
    }

    public void setStuPeriod(String stuPeriod) {
        this.stuPeriod = stuPeriod == null ? null : stuPeriod.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public Integer getSpeId() {
        return speId;
    }

    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public Boolean getStuSex() {
        return stuSex;
    }

    public void setStuSex(Boolean stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone == null ? null : stuPhone.trim();
    }

    public String getStuPicture() {
        return stuPicture;
    }

    public void setStuPicture(String stuPicture) {
        this.stuPicture = stuPicture == null ? null : stuPicture.trim();
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress == null ? null : stuAddress.trim();
    }

    public Integer getStuState() {
        return stuState;
    }

    public void setStuState(Integer stuState) {
        this.stuState = stuState;
    }
}