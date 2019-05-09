package com.vividseats.google.services;

import com.google.api.ads.adwords.axis.utils.v201809.SelectorBuilder;
import com.google.api.ads.adwords.axis.v201809.cm.Campaign;
import com.google.api.ads.adwords.axis.v201809.cm.CampaignPage;
import com.google.api.ads.adwords.axis.v201809.cm.CampaignServiceInterface;
import com.google.api.ads.adwords.axis.v201809.cm.Selector;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.selectorfields.v201809.cm.CampaignField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Arrays;

@Service
public class GoogleCampaignService {

    @Autowired
    private GoogleAdgroupService adgroupService;

    @Autowired
    private AdWordsServicesInterface adWordsServices;

    @Autowired
    private AdWordsSession session;

    public void printAll() throws RemoteException {
        CampaignServiceInterface campaignService = adWordsServices.get(session, CampaignServiceInterface.class);

        SelectorBuilder builder = new SelectorBuilder();
        Selector selector = builder
                .fields(CampaignField.Id, CampaignField.Name)
                .orderAscBy(CampaignField.Name)
                .build();

        CampaignPage page = campaignService.get(selector);

        if (page.getEntries() != null) {
            System.out.println("Campaigns:");
            Arrays.stream(page.getEntries()).forEach(this::printCampaignDetails);
        } else {
            System.out.println("No campaigns were found.");
        }
    }

    private void printCampaignDetails(Campaign campaign) {
        System.out.println(campaign.getName() + " " + campaign.getId());
        System.out.println();

        try {
            adgroupService.printAdgroups(campaign.getId());
        } catch (RemoteException e) {
            System.err.println("Something went wrong with adGroups");
        }

        System.out.println("---------------------------");
    }
}
