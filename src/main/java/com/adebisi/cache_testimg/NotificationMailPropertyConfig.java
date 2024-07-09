package com.adebisi.cache_testimg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

/**
 * @author Oluwatobi Ogunwuyi
 * @createdOn Jan-25(Wed)-2023
 */

@Getter
@Setter
@ToString
@Component
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "omni.notification.mail")
public class NotificationMailPropertyConfig {

    private String defaultSender;

    private String sender ;
    private  String emailKey;
    private String emailApiUrl ;
    private String postMarkHeaderType ;



}
