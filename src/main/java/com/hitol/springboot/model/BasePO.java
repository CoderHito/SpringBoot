package com.hitol.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Timestamp;

public class BasePO implements Serializable {

    private Long id;
    /**
     * 是否可用:默认0否;1是
     */
    @JsonIgnore
    private Integer isAvailable;
    /**
     * 是否逻辑删除:默认0未删除;1已删除
     */
    @JsonIgnore
    private Integer isDeleted;
    /**
     * 版本号:默认0,每次更新+1
     */
    @JsonIgnore
    private Integer versionNo;
    /**
     * 创建人ID
     */
    @JsonIgnore
    private Long createUserId;
    /**
     * 创建人姓名
     */
    @JsonIgnore
    private String createUserName;
    /**
     * 创建人IP
     */
    @JsonIgnore
    private String createUserIp;
    /**
     * 创建人MAC地址
     */
    @JsonIgnore
    private String createUserMac;
    /**
     * 创建时间-应用操作时间
     */
    @JsonIgnore
    private Timestamp createTime;
    /**
     * 创建时间-数据库操作时间
     */
    @JsonIgnore
    private Timestamp createTimeDb;
    /**
     * 服务器IP
     */
    @JsonIgnore
    private String serverIp;
    /**
     * 最后修改人ID
     */
    @JsonIgnore
    private Long updateUserId;
    /**
     * 最后修改人姓名
     */
    @JsonIgnore
    private String updateUserName;
    /**
     * 最后修改人IP
     */
    @JsonIgnore
    private String updateUserIp;
    /**
     * 最后修改人MAC
     */
    @JsonIgnore
    private String updateUserMac;
    /**
     * 最后修改时间
     */
    @JsonIgnore
    private Timestamp updateTime;
    /**
     * 最后修改时间-数据库默认写入时间
     */
    @JsonIgnore
    private Timestamp updateTimeDb;
    /**
     * 客户端程序的版本号
     */
    @JsonIgnore
    private String clientVersiono;
    /**
     * 公司id
     */
    @JsonIgnore
    private Long companyId;

    public Integer getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Integer isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateUserIp() {
        return createUserIp;
    }

    public void setCreateUserIp(String createUserIp) {
        this.createUserIp = createUserIp;
    }

    public String getCreateUserMac() {
        return createUserMac;
    }

    public void setCreateUserMac(String createUserMac) {
        this.createUserMac = createUserMac;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCreateTimeDb() {
        return createTimeDb;
    }

    public void setCreateTimeDb(Timestamp createTimeDb) {
        this.createTimeDb = createTimeDb;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public String getUpdateUserIp() {
        return updateUserIp;
    }

    public void setUpdateUserIp(String updateUserIp) {
        this.updateUserIp = updateUserIp;
    }

    public String getUpdateUserMac() {
        return updateUserMac;
    }

    public void setUpdateUserMac(String updateUserMac) {
        this.updateUserMac = updateUserMac;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getUpdateTimeDb() {
        return updateTimeDb;
    }

    public void setUpdateTimeDb(Timestamp updateTimeDb) {
        this.updateTimeDb = updateTimeDb;
    }

    public String getClientVersiono() {
        return clientVersiono;
    }

    public void setClientVersiono(String clientVersiono) {
        this.clientVersiono = clientVersiono;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}