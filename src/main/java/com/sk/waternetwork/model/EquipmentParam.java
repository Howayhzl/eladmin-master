package com.sk.waternetwork.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * EquipmentParam
 * @author 
 */
public class EquipmentParam implements Serializable {
    @ApiModelProperty(value="主键编码")
    private String code;
    @ApiModelProperty(value="公司编码")
    private String companycode;
    @ApiModelProperty(value="设备编码")
    private String equipmentcode;
    @ApiModelProperty(value="参数字段")
    private String paramfield;
    @ApiModelProperty(value="参数名称")
    private String paramname;
    @ApiModelProperty(value="告警阈值最大值")
    private Double thresholdmax;
    @ApiModelProperty(value="告警阈值最小值")
    private Double thresholdmin;
    @ApiModelProperty(value="单位")
    private String unit;
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

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getEquipmentcode() {
        return equipmentcode;
    }

    public void setEquipmentcode(String equipmentcode) {
        this.equipmentcode = equipmentcode;
    }

    public String getParamfield() {
        return paramfield;
    }

    public void setParamfield(String paramfield) {
        this.paramfield = paramfield;
    }

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname;
    }

    public Double getThresholdmax() {
        return thresholdmax;
    }

    public void setThresholdmax(Double thresholdmax) {
        this.thresholdmax = thresholdmax;
    }

    public Double getThresholdmin() {
        return thresholdmin;
    }

    public void setThresholdmin(Double thresholdmin) {
        this.thresholdmin = thresholdmin;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
        EquipmentParam other = (EquipmentParam) that;
        return (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCompanycode() == null ? other.getCompanycode() == null : this.getCompanycode().equals(other.getCompanycode()))
            && (this.getEquipmentcode() == null ? other.getEquipmentcode() == null : this.getEquipmentcode().equals(other.getEquipmentcode()))
            && (this.getParamfield() == null ? other.getParamfield() == null : this.getParamfield().equals(other.getParamfield()))
            && (this.getParamname() == null ? other.getParamname() == null : this.getParamname().equals(other.getParamname()))
            && (this.getThresholdmax() == null ? other.getThresholdmax() == null : this.getThresholdmax().equals(other.getThresholdmax()))
            && (this.getThresholdmin() == null ? other.getThresholdmin() == null : this.getThresholdmin().equals(other.getThresholdmin()))
            && (this.getUnit() == null ? other.getUnit() == null : this.getUnit().equals(other.getUnit()))
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
        result = prime * result + ((getCompanycode() == null) ? 0 : getCompanycode().hashCode());
        result = prime * result + ((getEquipmentcode() == null) ? 0 : getEquipmentcode().hashCode());
        result = prime * result + ((getParamfield() == null) ? 0 : getParamfield().hashCode());
        result = prime * result + ((getParamname() == null) ? 0 : getParamname().hashCode());
        result = prime * result + ((getThresholdmax() == null) ? 0 : getThresholdmax().hashCode());
        result = prime * result + ((getThresholdmin() == null) ? 0 : getThresholdmin().hashCode());
        result = prime * result + ((getUnit() == null) ? 0 : getUnit().hashCode());
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
        sb.append(", companycode=").append(companycode);
        sb.append(", equipmentcode=").append(equipmentcode);
        sb.append(", paramfield=").append(paramfield);
        sb.append(", paramname=").append(paramname);
        sb.append(", thresholdmax=").append(thresholdmax);
        sb.append(", thresholdmin=").append(thresholdmin);
        sb.append(", unit=").append(unit);
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