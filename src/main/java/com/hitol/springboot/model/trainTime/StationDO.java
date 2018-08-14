package com.hitol.springboot.model.trainTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "station")
public class StationDO {

    /**
     * @Id 注解声明了实体唯一标识对应的属性。
     */
    @Id
    private Integer id;
    /**
     * 车次ID
     */
    @Column(length = 10)
    private String trainNo;
    /**
     * 列车类型
     */
    @Column(length = 10)
    private String type;
    /**
     * 车站名称
     */
    @Column(length = 20)
    private String station;
    /**
     * 站序
     */
    @Column(length = 10)
    private String sequenceNo;
    /**
     * 天数
     */
    @Column(length = 10)
    private String day;
    /**
     * 到站时间
     */
    @Column(length = 20)
    private String arrivalTime;
    /**
     * 出发时间
     */
    @Column(length = 20)
    private String departureTime;
    /**
     * 停留时间
     */
    @Column(length = 20)
    private String stopTime;
    /**
     * 用时
     */
    @Column(length = 20)
    private String costTime;
    /**
     * 距离
     */
    @Column(length = 10)
    private String distance;
    /**
     * 是否终点
     */
    @Column(length = 1)
    private Integer isend;
    /**
     * 商务座
     */
    @Column(length = 10)
    private String pricesw;
    /**
     * 特等座
     */
    @Column(length = 10)
    private String pricetd;
    /**
     * 高级软卧上
     */
    @Column(length = 10)
    private String pricegr1;
    /**
     * 高级软卧下
     */
    @Column(length = 10)
    private String pricegr2;
    /**
     * 软卧上
     */
    @Column(length = 10)
    private String pricerw1;
    /**
     * 软卧下
     */
    @Column(length = 10)
    private String pricerw2;
    /**
     * 硬卧上
     */
    @Column(length = 10)
    private String priceyw1;
    /**
     * 硬卧中
     */
    @Column(length = 10)
    private String priceyw2;
    /**
     * 硬卧下
     */
    @Column(length = 10)
    private String priceyw3;
    /**
     * 一等座
     */
    @Column(length = 10)
    private String priceyd;
    /**
     * 二等座
     */
    @Column(length = 10)
    private String priceed;


    @Column(length = 10,nullable = false)
    private String createTime;

    @Column(length = 10,nullable = false)
    private String updateTime;

    public String getCreateTime() {
        return createTime;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(String sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getCostTime() {
        return costTime;
    }

    public void setCostTime(String costTime) {
        this.costTime = costTime;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Integer getIsend() {
        return isend;
    }

    public void setIsend(Integer isend) {
        this.isend = isend;
    }

    public String getPricesw() {
        return pricesw;
    }

    public void setPricesw(String pricesw) {
        this.pricesw = pricesw;
    }

    public String getPricetd() {
        return pricetd;
    }

    public void setPricetd(String pricetd) {
        this.pricetd = pricetd;
    }

    public String getPricegr1() {
        return pricegr1;
    }

    public void setPricegr1(String pricegr1) {
        this.pricegr1 = pricegr1;
    }

    public String getPricegr2() {
        return pricegr2;
    }

    public void setPricegr2(String pricegr2) {
        this.pricegr2 = pricegr2;
    }

    public String getPricerw1() {
        return pricerw1;
    }

    public void setPricerw1(String pricerw1) {
        this.pricerw1 = pricerw1;
    }

    public String getPricerw2() {
        return pricerw2;
    }

    public void setPricerw2(String pricerw2) {
        this.pricerw2 = pricerw2;
    }

    public String getPriceyw1() {
        return priceyw1;
    }

    public void setPriceyw1(String priceyw1) {
        this.priceyw1 = priceyw1;
    }

    public String getPriceyw2() {
        return priceyw2;
    }

    public void setPriceyw2(String priceyw2) {
        this.priceyw2 = priceyw2;
    }

    public String getPriceyw3() {
        return priceyw3;
    }

    public void setPriceyw3(String priceyw3) {
        this.priceyw3 = priceyw3;
    }

    public String getPriceyd() {
        return priceyd;
    }

    public void setPriceyd(String priceyd) {
        this.priceyd = priceyd;
    }

    public String getPriceed() {
        return priceed;
    }

    public void setPriceed(String priceed) {
        this.priceed = priceed;
    }
}
