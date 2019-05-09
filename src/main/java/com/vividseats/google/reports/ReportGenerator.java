package com.vividseats.google.reports;

import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.client.reporting.ReportingConfiguration;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.jaxb.v201809.DownloadFormat;
import com.google.api.ads.adwords.lib.jaxb.v201809.ReportDefinitionDateRangeType;
import com.google.api.ads.adwords.lib.jaxb.v201809.ReportDefinitionReportType;
import com.google.api.ads.adwords.lib.utils.ReportDownloadResponse;
import com.google.api.ads.adwords.lib.utils.ReportDownloadResponseException;
import com.google.api.ads.adwords.lib.utils.ReportException;
import com.google.api.ads.adwords.lib.utils.v201809.ReportDownloaderInterface;
import com.google.api.ads.adwords.lib.utils.v201809.ReportQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ReportGenerator {

    @Autowired
    private AdWordsServicesInterface adWordsServices;

    @Autowired
    private AdWordsSession session;

    public void generateAndSaveCriteriaPerformanceReport(String reportFile) throws ReportDownloadResponseException, ReportException, IOException {
        ReportQuery query =
                new ReportQuery.Builder()
                        .fields(
                                "CampaignId",
                                "AdGroupId",
                                "Id",
                                "Criteria",
                                "CriteriaType",
                                "Impressions",
                                "Clicks",
                                "Cost",
                                "AbsoluteTopImpressionPercentage")
                        .from(ReportDefinitionReportType.CRITERIA_PERFORMANCE_REPORT)
                        .where("Status").in("ENABLED", "PAUSED")
                        .during(ReportDefinitionDateRangeType.LAST_7_DAYS)
                        .build();

        downloadReport(reportFile, query);
    }

    public void generateAndSaveKeywordPerformanceReport(String reportFile) throws ReportDownloadResponseException, ReportException, IOException {
        ReportQuery query =
                new ReportQuery.Builder()
                        .fields(
                                "AdGroupId", "Id", "Criteria", "Impressions", "Clicks", "Cost", "AveragePosition",
                                "CpcBid", "FirstPageCpc", "Conversions", "ConversionValue", "QualityScore", "Device", "AdNetworkType2")
                        .from(ReportDefinitionReportType.KEYWORDS_PERFORMANCE_REPORT)
                        .where("Status").in("ENABLED", "PAUSED")
                        .during(ReportDefinitionDateRangeType.LAST_7_DAYS)
                        .build();

        downloadReport(reportFile, query);
    }

    private void downloadReport(String reportFile, ReportQuery query) throws ReportException, ReportDownloadResponseException, IOException {
        ReportingConfiguration reportingConfiguration =
                new ReportingConfiguration.Builder()
                        .skipReportHeader(true)
                        .skipColumnHeader(false)
                        .skipReportSummary(true)
                        // Set to false to exclude rows with zero impressions.
                        .includeZeroImpressions(true)
                        .build();
        session.setReportingConfiguration(reportingConfiguration);

        ReportDownloaderInterface reportDownloader =
                adWordsServices.getUtility(session, ReportDownloaderInterface.class);

        ReportDownloadResponse response =
                reportDownloader.downloadReport(query.toString(), DownloadFormat.GZIPPED_CSV);
        response.saveToFile(reportFile);

        System.out.printf("Report successfully downloaded to: %s%n", reportFile);
    }
}
