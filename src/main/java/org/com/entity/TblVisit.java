package org.com.entity;

import java.util.Date;

public class TblVisit {
    private Integer visId;

    private String visName;

    private String visCard;

    private Date visTime;

    private Integer stuId;

    private String visDescription;

    private TblCheck tblCheck;

    public TblCheck getTblCheck() {
        return tblCheck;
    }

    public void setTblCheck(TblCheck tblCheck) {
        this.tblCheck = tblCheck;
    }

    public Integer getVisId() {
        return visId;
    }

    public void setVisId(Integer visId) {
        this.visId = visId;
    }

    public String getVisName() {
        return visName;
    }

    public void setVisName(String visName) {
        this.visName = visName == null ? null : visName.trim();
    }

    public String getVisCard() {
        return visCard;
    }

    public void setVisCard(String visCard) {
        this.visCard = visCard == null ? null : visCard.trim();
    }

    public Date getVisTime() {
        return visTime;
    }

    public void setVisTime(Date visTime) {
        this.visTime = visTime;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getVisDescription() {
        return visDescription;
    }

    public void setVisDescription(String visDescription) {
        this.visDescription = visDescription == null ? null : visDescription.trim();
    }
}