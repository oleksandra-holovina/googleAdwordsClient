package com.vividseats.google.entities;

import java.util.Date;

public class GoogleKeywordStat {
    private long adgroupId;
    private long keywordId;
    private String keyword;
    private double maxCpc;
    private double imps;
    private double clicks;
    private double ctr;
    private double cost;
    private double position;
    private double convRate;
    private Date reportDate;
    private double lastPosition;
    private int lastImps;
    private String network;
    private double firstPageCpc;
    private int salesCount;
    private double revenue;
    private int qualityScore;
    private boolean mobile;

    private int hourOfDay;
    /**
     * Creates a new instance of GoogleKeywordStat
     */
    public GoogleKeywordStat() {
    }

    public static GoogleKeywordStat copy(GoogleKeywordStat stat) {
        GoogleKeywordStat copied = new GoogleKeywordStat();
        copied.setAdgroupId(stat.getAdGroupId());
        copied.setKeywordId(stat.getKeywordId());
        copied.setKeyword(stat.getKeyword());
        copied.setImps(stat.getImps());
        copied.setClicks(stat.getClicks());
        copied.setCost(stat.getCost());
        copied.setPosition(stat.getPosition());
        copied.setMaxCpc(stat.getMaxCpc());
        copied.setFirstPageCpc(stat.getFirstPageCpc());
        copied.setSalesCount(stat.getSalesCount());
        copied.setRevenue(stat.getRevenue());
        copied.setNetwork(stat.getNetwork());
        copied.setQualityScore(stat.getQualityScore());
        copied.setMobile(stat.isMobile());
        return copied;
    }

    public long getAdGroupId() {
        return adgroupId;
    }

    public void setAdgroupId(long adgroupId) {
        this.adgroupId = adgroupId;
    }

    public long getKeywordId() {
        return keywordId;
    }

    public void setKeywordId(long keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public double getCtr() {
        return ctr;
    }

    public void setCtr(double ctr) {
        this.ctr = ctr;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public double getConvRate() {
        return convRate;
    }

    public void setConvRate(double convRate) {
        this.convRate = convRate;
    }



    public double getImps() {
        return imps;
    }

    public void setImps(double imps) {
        this.imps = imps;
    }

    public double getClicks() {
        return clicks;
    }

    public void setClicks(double clicks) {
        this.clicks = clicks;
    }

    /**
     * @return the reportDate
     */
    public Date getReportDate() {
        return reportDate;
    }

    /**
     * @param reportDate the reportDate to set
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * @return the lastPosition
     */
    public double getLastPosition() {
        return lastPosition;
    }

    /**
     * @param lastPosition the lastPosition to set
     */
    public void setLastPosition(double lastPosition) {
        this.lastPosition = lastPosition;
    }

    /**
     * @return the lastImps
     */
    public int getLastImps() {
        return lastImps;
    }

    /**
     * @param lastImps the lastImps to set
     */
    public void setLastImps(int lastImps) {
        this.lastImps = lastImps;
    }



    /**
     * @return the firstPageCpc
     */
    public double getFirstPageCpc() {
        return firstPageCpc;
    }

    /**
     * @param firstPageCpc the firstPageCpc to set
     */
    public void setFirstPageCpc(double firstPageCpc) {
        this.firstPageCpc = firstPageCpc;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * @return the maxCpc
     */
    public double getMaxCpc() {
        return maxCpc;
    }

    /**
     * @param maxCpc the maxCpc to set
     */
    public void setMaxCpc(double maxCpc) {
        this.maxCpc = maxCpc;
    }



    /**
     * @return the revenue
     */
    public double getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    /**
     * @return the network
     */
    public String getNetwork() {
        return network;
    }

    /**
     * @param network the network to set
     */
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * @return the qualityScore
     */
    public int getQualityScore() {
        return qualityScore;
    }

    /**
     * @param qualityScore the qualityScore to set
     */
    public void setQualityScore(int qualityScore) {
        this.qualityScore = qualityScore;
    }

    /**
     * @return the salesCount
     */
    public int getSalesCount() {
        return salesCount;
    }

    /**
     * @param salesCount the salesCount to set
     */
    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    /**
     * @return the mobile
     */
    public boolean isMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }


    public int getHourOfDay() {
        return hourOfDay;
    }

    public void setHourOfDay(int hourOfDay) {
        this.hourOfDay = hourOfDay;
    }

    @Override
    public String toString() {
        return "GoogleKeywordStat{" +
                "adgroupId=" + adgroupId +
                ", keywordId=" + keywordId +
                ", keyword='" + keyword + '\'' +
                ", maxCpc=" + maxCpc +
                ", imps=" + imps +
                ", clicks=" + clicks +
                ", ctr=" + ctr +
                ", cost=" + cost +
                ", position=" + position +
                ", convRate=" + convRate +
                ", reportDate=" + reportDate +
                ", lastPosition=" + lastPosition +
                ", lastImps=" + lastImps +
                ", network='" + network + '\'' +
                ", firstPageCpc=" + firstPageCpc +
                ", salesCount=" + salesCount +
                ", revenue=" + revenue +
                ", qualityScore=" + qualityScore +
                ", mobile=" + mobile +
                ", hourOfDay=" + hourOfDay +
                '}';
    }
}
