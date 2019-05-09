package com.vividseats;

import com.vividseats.google.services.GoogleReportManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        GoogleReportManager reportManager = context.getBean(GoogleReportManager.class);
        try {
            reportManager.writeToReportDb("/Users/oleksandra.holovina/Desktop/VividSeats/testGoogle/report.gzip");
        } catch (IOException e) {
            System.err.println("Something went wrong with report");
        }
    }
}
