package com.vividseats.google.services;

import com.google.api.ads.adwords.axis.utils.v201809.SelectorBuilder;
import com.google.api.ads.adwords.axis.v201809.cm.AdGroup;
import com.google.api.ads.adwords.axis.v201809.cm.AdGroupPage;
import com.google.api.ads.adwords.axis.v201809.cm.AdGroupServiceInterface;
import com.google.api.ads.adwords.axis.v201809.cm.Selector;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.selectorfields.v201809.cm.AdGroupField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Arrays;

@Service
public class GoogleAdgroupService {

    @Autowired
    private GoogleKeywordService keywordService;

    @Autowired
    private AdWordsServicesInterface adWordsServices;

    @Autowired
    private AdWordsSession session;

    public void printAdgroups(Long campaignId) throws RemoteException {
        AdGroupServiceInterface adGroupService = adWordsServices.get(session, AdGroupServiceInterface.class);

        SelectorBuilder builder = new SelectorBuilder();
        Selector selector = builder
                .fields(AdGroupField.Id, AdGroupField.Name, AdGroupField.Status)
                .equals(AdGroupField.CampaignId, String.valueOf(campaignId))
                .build();

        AdGroupPage adGroups = adGroupService.get(selector);
        if (adGroups.getEntries() != null) {
            System.out.println("Adgroups:");
            Arrays.stream(adGroups.getEntries()).forEach(this::printAdGroupDetails);
        } else {
            System.out.println("No adgroups were found.");
        }
        System.out.println();
    }

    private void printAdGroupDetails(AdGroup adGroup) {
        System.out.println(getAdGroupFieldValues(adGroup));
        System.out.println();

        try {
            keywordService.printKeywords(adGroup.getId());
        } catch (RemoteException e) {
            System.err.println("Something went wrong with keywords");
        }
    }

    private static String getAdGroupFieldValues(AdGroup adGroup) {
        return String.format("AdGroup id:%d, name:%s, status:%s, campaign id:%d",
                adGroup.getId(), adGroup.getName(), adGroup.getStatus(), adGroup.getCampaignId());
    }
}
