package com.vividseats.google.converters;

import com.vividseats.google.dto.GoogleKeywordDTO;
import com.vividseats.google.entities.GoogleKeywordStat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoogleKeywordConverter {

    public List<GoogleKeywordStat> convert(List<GoogleKeywordDTO> googleKeywordDTO) {
        List<GoogleKeywordStat> keywordStats = new ArrayList<>();

        googleKeywordDTO.forEach(keyword -> {
            GoogleKeywordStat stat = new GoogleKeywordStat();
            stat.setAdgroupId(keyword.getAdgroupId());
            stat.setKeywordId(keyword.getKeywordId());
            stat.setKeyword(getKeyword(keyword.getKeyword()));
            stat.setImps(keyword.getImpressions());
            stat.setClicks(keyword.getClicks());
            stat.setCost(normalize(keyword.getCost()));
            stat.setPosition(keyword.getAveragePosition());
            stat.setMaxCpc(normalize(getMaxCpc(keyword.getMaxCpc())));
            stat.setFirstPageCpc(normalize(keyword.getFirstPageCpc()));
            stat.setSalesCount(new BigDecimal(keyword.getSalesCount()).intValue());
            stat.setRevenue(keyword.getRevenue());
            stat.setQualityScore(getQualityScore(keyword.getQualityScore()));
            stat.setMobile(isMobile(keyword.getDevice()));
            stat.setNetwork(keyword.getNetwork());

            keywordStats.add(stat);
        });

        return keywordStats;
    }

    private static double getMaxCpc(String maxCpc) {
        try {
            return Double.parseDouble(maxCpc);
        } catch (Exception e) {
            return 0;
        }
    }

    private static boolean isMobile(String device) {
        return device.toUpperCase().contains("MOBILE");
    }

    private static int getQualityScore(String score) {
        try {
            return Integer.parseInt(score);
        } catch (Exception e) {
            return 0;
        }
    }

    private static double normalize(double value) {
        return value / 1_000_000;
    }

    private static String getKeyword(String keyword) {
        return keyword.startsWith("'") ?
                keyword.substring(1) :
                keyword;
    }
}
