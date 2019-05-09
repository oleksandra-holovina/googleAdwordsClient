package com.vividseats;

import com.google.api.ads.adwords.axis.v201809.cm.ApiError;
import com.google.api.ads.adwords.axis.v201809.cm.ApiException;
import com.google.api.ads.adwords.lib.utils.ReportDownloadResponseException;
import com.google.api.ads.adwords.lib.utils.ReportException;
import com.vividseats.google.reports.ReportGenerator;
import com.vividseats.google.reports.ReportParser;
import com.vividseats.google.services.GoogleCampaignService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ReportParser reportParser = context.getBean(ReportParser.class);
        try {
            reportParser.parseReport("/Users/oleksandra.holovina/Desktop/VividSeats/testGoogle/report.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        ReportGenerator reportGenerator = context.getBean(ReportGenerator.class);
//        try {
//            reportGenerator.generateAndSaveKeywordPerformanceReport("/Users/oleksandra.holovina/Desktop/VividSeats/testGoogle/report.csv");
//        } catch (ReportDownloadResponseException | ReportException | IOException e) {
//            System.err.println("Report generation failed");
//        }

//        GoogleCampaignService campaignService = context.getBean(GoogleCampaignService.class);

//        try {
////            campaignService.printAll();
//        } catch (ApiException apiException) {
//            System.err.println("Request failed due to ApiException. Underlying ApiErrors:");
//            if (apiException.getErrors() != null) {
//                int i = 0;
//                for (ApiError apiError : apiException.getErrors()) {
//                    System.err.printf("  Error %d: %s%n", i++, apiError);
//                }
//            }
//        } catch (RemoteException re) {
//            System.err.printf(
//                    "Request failed unexpectedly due to RemoteException: %s%n", re);
//        }
    }
}
