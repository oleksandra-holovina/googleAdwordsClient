package com.vividseats.google.reports;

import com.opencsv.bean.CsvToBeanBuilder;
import com.vividseats.google.entities.GoogleKeywordStat;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Component
public class ReportParser {

    public void parseReport(String reportFile) throws FileNotFoundException {
        List<GoogleKeywordStat> treeParser = new CsvToBeanBuilder(new FileReader(reportFile)).withType(GoogleKeywordStat.class)
                .build()
                .parse();

        treeParser.forEach(System.out::println);
    }
}
