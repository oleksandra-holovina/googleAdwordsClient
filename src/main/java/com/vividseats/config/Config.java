package com.vividseats.config;

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public AdWordsServicesInterface adWordsServicesInterface() {
        return AdWordsServices.getInstance();
    }

    @Bean
    public Credential oAuth2Credential() throws ConfigurationLoadException, ValidationException, OAuthException {
        return new OfflineCredentials.Builder()
                .forApi(OfflineCredentials.Api.ADWORDS)
                .fromFile()
                .build()
                .generateCredential();
    }

    @Bean
    public AdWordsSession session() throws ConfigurationLoadException, OAuthException, ValidationException {
        return new AdWordsSession.Builder()
                .fromFile()
                .withOAuth2Credential(oAuth2Credential())
                .build();
    }
}
