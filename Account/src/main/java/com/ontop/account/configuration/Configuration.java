package com.ontop.account.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("transaction")
@org.springframework.context.annotation.Configuration
public class Configuration {

    private int fee;

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
