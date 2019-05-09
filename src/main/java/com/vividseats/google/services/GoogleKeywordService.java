package com.vividseats.google.services;

import com.google.api.ads.adwords.axis.utils.v201809.SelectorBuilder;
import com.google.api.ads.adwords.axis.v201809.cm.*;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.selectorfields.v201809.cm.AdGroupCriterionField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.rmi.RemoteException;
import java.util.Arrays;

@Service
public class GoogleKeywordService {

    @Autowired
    private AdWordsServicesInterface adWordsServices;

    @Autowired
    private AdWordsSession session;

    public void printKeywords(Long adGroupId) throws RemoteException {
        SelectorBuilder builder = new SelectorBuilder();
        Selector selector = builder
                .fields(
                        AdGroupCriterionField.Id,
                        AdGroupCriterionField.CriteriaType,
                        AdGroupCriterionField.KeywordMatchType,
                        AdGroupCriterionField.KeywordText)
                .orderAscBy(AdGroupCriterionField.KeywordText)
                .in(AdGroupCriterionField.AdGroupId, String.valueOf(adGroupId))
                .in(AdGroupCriterionField.CriteriaType, "KEYWORD")
                .build();

        AdGroupCriterionServiceInterface adGroupCriterionService = adWordsServices.get(session, AdGroupCriterionServiceInterface.class);
        AdGroupCriterionPage adGroupPage = adGroupCriterionService.get(selector);

        if (isNonEmpty(adGroupPage.getEntries())) {
            System.out.println("Keywords:");

            Arrays.stream(adGroupPage.getEntries())
                    .map(adGroupCriterionResult -> (Keyword) adGroupCriterionResult.getCriterion())
                    .forEach(keyword -> System.out.println(getKeywordFieldValues(keyword)));

        } else {
            System.out.println("No ad group criteria were found.");
        }
    }

    private static boolean isNonEmpty(AdGroupCriterion[] entries) {
        return !CollectionUtils.isEmpty(Arrays.asList(entries));
    }

    private static String getKeywordFieldValues(Keyword keyword) {
        return keyword.getText() + " " + keyword.getMatchType() + " " + keyword.getType() + " " + keyword.getId();
    }
}
