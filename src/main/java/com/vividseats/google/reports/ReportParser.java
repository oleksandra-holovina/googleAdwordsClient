package com.vividseats.google.reports;

import com.opencsv.bean.CsvToBeanBuilder;
import com.vividseats.google.entities.GoogleKeywordStat;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Component
public class ReportParser {

    public void parseReport(String reportFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(reportFile))))) {
            List<GoogleKeywordStat> treeParser = new CsvToBeanBuilder<GoogleKeywordStat>(br)
                    .withType(GoogleKeywordStat.class)
                    .build()
                    .parse();

            treeParser.forEach(System.out::println);
        }
    }
}
