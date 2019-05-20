package com.vividseats.google.reports;

import com.opencsv.bean.CsvToBeanBuilder;
import com.vividseats.google.dto.GoogleKeywordDTO;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.zip.GZIPInputStream;

@Component
public class ReportParser {

    public List<GoogleKeywordDTO> parseReport(String reportFile) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(reportFile))))) {
            return new CsvToBeanBuilder<GoogleKeywordDTO>(br)
                    .withType(GoogleKeywordDTO.class)
                    .build()
                    .parse();
        }
    }

    public List<GoogleKeywordDTO> parseReport(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(inputStream)))) {
            return new CsvToBeanBuilder<GoogleKeywordDTO>(br)
                    .withType(GoogleKeywordDTO.class)
                    .build()
                    .parse();
        }
    }
}
