package com.vividseats.google.dto;

import com.opencsv.bean.CsvBindByName;

public class GoogleKeywordDTO {
    @CsvBindByName(column = "Ad group ID")
    private long adgroupId;
    @CsvBindByName(column = "Keyword ID")
    private long keywordId;
    @CsvBindByName(column = "Keyword")
    private String keyword;
    @CsvBindByName(column = "Max. CPC")
    private double maxCpc;
    @CsvBindByName(column = "Impressions")
    private double impressions;
    @CsvBindByName(column = "Clicks")
    private double clicks;
    @CsvBindByName(column = "Cost")
    private double cost;
    @CsvBindByName(column = "Avg. position")
    private double averagePosition;
    @CsvBindByName(column = "Network (with search partners)")
    private String network;
    @CsvBindByName(column = "First page CPC")
    private double firstPageCpc;
    @CsvBindByName(column = "Conversions")
    private double salesCount;
    @CsvBindByName(column = "Total conv. value")
    private double revenue;
    @CsvBindByName(column = "Quality score")
    private String qualityScore;
    @CsvBindByName(column = "Device")
    private String device;

    public long getAdgroupId() {
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

    public double getMaxCpc() {
        return maxCpc;
    }

    public void setMaxCpc(double maxCpc) {
        this.maxCpc = maxCpc;
    }

    public double getImpressions() {
        return impressions;
    }

    public void setImpressions(double impressions) {
        this.impressions = impressions;
    }

    public double getClicks() {
        return clicks;
    }

    public void setClicks(double clicks) {
        this.clicks = clicks;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAveragePosition() {
        return averagePosition;
    }

    public void setAveragePosition(double averagePosition) {
        this.averagePosition = averagePosition;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public double getFirstPageCpc() {
        return firstPageCpc;
    }

    public void setFirstPageCpc(double firstPageCpc) {
        this.firstPageCpc = firstPageCpc;
    }

    public double getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(double salesCount) {
        this.salesCount = salesCount;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(String qualityScore) {
        this.qualityScore = qualityScore;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
