package com.vividseats.google.services;

import com.vividseats.google.converters.GoogleKeywordConverter;
import com.vividseats.google.dto.GoogleKeywordDTO;
import com.vividseats.google.entities.GoogleKeywordStat;
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
    private GoogleKeywordConverter converter;

    public void writeToReportDb(String reportFile) throws IOException {
        List<GoogleKeywordDTO> googleKeywordDTO = parser.parseReport(reportFile);
        List<GoogleKeywordStat> keywordStats = converter.convert(googleKeywordDTO);


        System.out.println(keywordStats);

        //do rest
    }

}
