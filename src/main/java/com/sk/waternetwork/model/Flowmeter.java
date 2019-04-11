package com.sk.waternetwork.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Flowmeter
 * @author 
 */
public class Flowmeter implements Serializable {
    @ApiModelProperty(value="流量计编码")
    private String code;
    @ApiModelProperty(value="流量计名称")
    private String name;
    @ApiModelProperty(value="公司编码")
    private String companycode;
    @ApiModelProperty(value="设备编码")
    private String devicecode;
    @ApiModelProperty(value="厂家")
    private String manufactor;
    @ApiModelProperty(value="型号")
    private String modelnumber;
    @ApiModelProperty(value="口径")
    private String caliber;
    @ApiModelProperty(value="管材")
    private String material;
    @ApiModelProperty(value="Gis")
    private String gis;
    @ApiModelProperty(value="地址")
    private String address;
    @ApiModelProperty(value="状态")
    private Integer state;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getModelnumber() {
        return modelnumber;
    }

    public void setModelnumber(String modelnumber) {
        this.modelnumber = modelnumber;
    }

    public String getCaliber() {
        return caliber;
    }

    public void setCaliber(String caliber) {
        this.caliber = caliber;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getGis() {
        return gis;
    }

    public void setGis(String gis) {
        this.gis = gis;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        Flowmeter other = (Flowmeter) that;
        return (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCompanycode() == null ? other.getCompanycode() == null : this.getCompanycode().equals(other.getCompanycode()))
            && (this.getDevicecode() == null ? other.getDevicecode() == null : this.getDevicecode().equals(other.getDevicecode()))
            && (this.getManufactor() == null ? other.getManufactor() == null : this.getManufactor().equals(other.getManufactor()))
            && (this.getModelnumber() == null ? other.getModelnumber() == null : this.getModelnumber().equals(other.getModelnumber()))
            && (this.getCaliber() == null ? other.getCaliber() == null : this.getCaliber().equals(other.getCaliber()))
            && (this.getMaterial() == null ? other.getMaterial() == null : this.getMaterial().equals(other.getMaterial()))
            && (this.getGis() == null ? other.getGis() == null : this.getGis().equals(other.getGis()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
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
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCompanycode() == null) ? 0 : getCompanycode().hashCode());
        result = prime * result + ((getDevicecode() == null) ? 0 : getDevicecode().hashCode());
        result = prime * result + ((getManufactor() == null) ? 0 : getManufactor().hashCode());
        result = prime * result + ((getModelnumber() == null) ? 0 : getModelnumber().hashCode());
        result = prime * result + ((getCaliber() == null) ? 0 : getCaliber().hashCode());
        result = prime * result + ((getMaterial() == null) ? 0 : getMaterial().hashCode());
        result = prime * result + ((getGis() == null) ? 0 : getGis().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
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
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", companycode=").append(companycode);
        sb.append(", devicecode=").append(devicecode);
        sb.append(", manufactor=").append(manufactor);
        sb.append(", modelnumber=").append(modelnumber);
        sb.append(", caliber=").append(caliber);
        sb.append(", material=").append(material);
        sb.append(", gis=").append(gis);
        sb.append(", address=").append(address);
        sb.append(", state=").append(state);
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