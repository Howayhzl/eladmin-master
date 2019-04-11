package com.sk.waternetwork.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * AreasInfo
 * @author 
 */
public class AreasInfo implements Serializable {
    @ApiModelProperty(value="区域编码")
    private String areacode;
    @ApiModelProperty(value="区域名称")
    private String areaname;
    @ApiModelProperty(value="公司编码")
    private String companycode;
    @ApiModelProperty(value="父节点")
    private String parentnode;
    @ApiModelProperty(value="负责人")
    private String personliable;
    @ApiModelProperty(value="负责人电话")
    private String phone;
    @ApiModelProperty(value="创建人")
    private String creator;
    @ApiModelProperty(value="创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createtime;
    @ApiModelProperty(value="修改人")
    private String modifier;
    @ApiModelProperty(value="修改时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifytime;
    @ApiModelProperty(value="有效状态")
    private Integer validstatus;

    private static final long serialVersionUID = 1L;

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getParentnode() {
        return parentnode;
    }

    public void setParentnode(String parentnode) {
        this.parentnode = parentnode;
    }

    public String getPersonliable() {
        return personliable;
    }

    public void setPersonliable(String personliable) {
        this.personliable = personliable;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public Integer getValidstatus() {
        return validstatus;
    }

    public void setValidstatus(Integer validstatus) {
        this.validstatus = validstatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AreasInfo other = (AreasInfo) that;
        return (this.getAreacode() == null ? other.getAreacode() == null : this.getAreacode().equals(other.getAreacode()))
            && (this.getAreaname() == null ? other.getAreaname() == null : this.getAreaname().equals(other.getAreaname()))
            && (this.getCompanycode() == null ? other.getCompanycode() == null : this.getCompanycode().equals(other.getCompanycode()))
            && (this.getParentnode() == null ? other.getParentnode() == null : this.getParentnode().equals(other.getParentnode()))
            && (this.getPersonliable() == null ? other.getPersonliable() == null : this.getPersonliable().equals(other.getPersonliable()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifytime() == null ? other.getModifytime() == null : this.getModifytime().equals(other.getModifytime()))
            && (this.getValidstatus() == null ? other.getValidstatus() == null : this.getValidstatus().equals(other.getValidstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAreacode() == null) ? 0 : getAreacode().hashCode());
        result = prime * result + ((getAreaname() == null) ? 0 : getAreaname().hashCode());
        result = prime * result + ((getCompanycode() == null) ? 0 : getCompanycode().hashCode());
        result = prime * result + ((getParentnode() == null) ? 0 : getParentnode().hashCode());
        result = prime * result + ((getPersonliable() == null) ? 0 : getPersonliable().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifytime() == null) ? 0 : getModifytime().hashCode());
        result = prime * result + ((getValidstatus() == null) ? 0 : getValidstatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", areacode=").append(areacode);
        sb.append(", areaname=").append(areaname);
        sb.append(", companycode=").append(companycode);
        sb.append(", parentnode=").append(parentnode);
        sb.append(", personliable=").append(personliable);
        sb.append(", phone=").append(phone);
        sb.append(", creator=").append(creator);
        sb.append(", createtime=").append(createtime);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifytime=").append(modifytime);
        sb.append(", validstatus=").append(validstatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}