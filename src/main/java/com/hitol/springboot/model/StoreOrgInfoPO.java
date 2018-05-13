package com.hitol.springboot.model;


import java.math.BigDecimal;

public class StoreOrgInfoPO extends BasePO {
    /**
     * 组织id
     */
    private Long orgId;
    /**
     * 组织编码
     */
    private String orgCode;
    /**
     *  '审核状态 0待审核,1通过,2不通过'
     */
    private String auditStatus;
    /**
     * 核算单位id
     */
    private Long accountingUnitId;
    /**
     * 门店类型
     */
    private String storeType;
    /**
     * 店铺logo
     */
    private String logoUrl;
    /**
     * 员工数
     */
    private Integer staffNums;
    /**
     * 国家
     */
    private String countryCode;
    /**
     * 国家名称
     */
    private String countryName;
    /**
     * 省id
     */
    private Long provinceCode;
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 市id
     */
    private Long cityCode;
    /**
     * 市名
     */
    private String cityName;
    /**
     * 区id
     */
    private Long regionCode;
    /**
     * 区名
     */
    private String regionName;
    /**
     * 详细地址
     */
    private String detailAddress;
    /**
     * 门店描述
     */
    private String desc;
    /**
     * 是否接单（是否营业） 1-是
     */
    private Integer businessState;
    /**
     * 营业执照url
     */
    private String businessLicenseUrl;
    /**
     * 门店招牌url
     */
    private String signUrl;
    /**
     * 店铺的经度
     */
    private BigDecimal longitude;
    /**
     * 店铺的纬度
     */
    private BigDecimal latitude;

    private String serviceType;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getAccountingUnitId() {
        return accountingUnitId;
    }

    public void setAccountingUnitId(Long accountingUnitId) {
        this.accountingUnitId = accountingUnitId;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getStaffNums() {
        return staffNums;
    }

    public void setStaffNums(Integer staffNums) {
        this.staffNums = staffNums;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Long provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getBusinessState() {
        return businessState;
    }

    public void setBusinessState(Integer businessState) {
        this.businessState = businessState;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "StoreOrgInfoPO{" +
                "orgId=" + orgId +
                ", orgCode='" + orgCode + '\'' +
                ", auditStatus='" + auditStatus + '\'' +
                ", accountingUnitId=" + accountingUnitId +
                ", storeType='" + storeType + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", staffNums=" + staffNums +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", provinceCode=" + provinceCode +
                ", provinceName='" + provinceName + '\'' +
                ", cityCode=" + cityCode +
                ", cityName='" + cityName + '\'' +
                ", regionCode=" + regionCode +
                ", regionName='" + regionName + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", desc='" + desc + '\'' +
                ", businessState=" + businessState +
                ", businessLicenseUrl='" + businessLicenseUrl + '\'' +
                ", signUrl='" + signUrl + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}