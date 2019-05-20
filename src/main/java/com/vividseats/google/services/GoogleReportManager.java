package com.vividseats.google.services;

import com.google.api.ads.adwords.lib.utils.ReportDownloadResponseException;
import com.google.api.ads.adwords.lib.utils.ReportException;
import com.vividseats.google.converters.GoogleKeywordConverter;
import com.vividseats.google.dto.GoogleKeywordDTO;
import com.vividseats.google.entities.GoogleKeywordStat;
import com.vividseats.google.reports.ReportGenerator;
import com.vividseats.google.reports.ReportParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GoogleReportManager {

    @Autowired
    private ReportParser parser;

    @Autowired
    private ReportGenerator reportGenerator;

    @Autowired
    private GoogleKeywordConverter converter;

    public void printKeywordReport() throws IOException, ReportDownloadResponseException, ReportException {
        List<GoogleKeywordDTO> googleKeywordDTO = parser.parseReport(reportGenerator.generateAndSaveKeywordPerformanceReport());
        List<GoogleKeywordStat> keywordStats = converter.convert(googleKeywordDTO);

        System.out.println(keywordStats);
    }

    public void saveKeywordReportToFile(String filename) throws ReportDownloadResponseException, ReportException, IOException {
        reportGenerator.generateAndSaveKeywordPerformanceReport(filename);
    }

}
