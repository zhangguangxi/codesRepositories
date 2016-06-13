package com.clinic.model;

import java.io.Serializable;

/**
 * Patient
 * 
 * @version 2016年5月18日上午11:17:06
 * @author guangxi.zhang
 */
public class User extends Model<Long> implements Serializable {
    
    /**
     * 类的版本号
     */
    private static final long serialVersionUID = 4724335939683910092L;
    
    private String chineseName;
    
    private String englishName;
    
    private String pinyingName;
    
    private String idCard;
    
    private Integer sex;
    
    private String nation;
    
    private String birthday;
    
    private Integer isMarry;
    
    private String phone;
    
    private String createTime;
    
    private String updateTime;
    
    public String getChineseName() {
        return chineseName;
    }
    
    public String getEnglishName() {
        return englishName;
    }
    
    public String getPinyingName() {
        return pinyingName;
    }
    
    public Integer getSex() {
        return sex;
    }
    
    public String getNation() {
        return nation;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public Integer getIsMarry() {
        return isMarry;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getCreateTime() {
        return createTime;
    }
    
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }
    
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
    
    public void setPinyingName(String pinyingName) {
        this.pinyingName = pinyingName;
    }
    
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public void setIsMarry(Integer isMarry) {
        this.isMarry = isMarry;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    
    public String getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getIdCard() {
        return idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    @Override
    public String toString() {
        return "User [chineseName=" + chineseName + ", englishName=" + englishName + ", pinyingName=" + pinyingName
                + ", idCard=" + idCard + ", sex=" + sex + ", nation=" + nation + ", birthday=" + birthday + ", isMarry="
                + isMarry + ", phone=" + phone + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
    }
}
