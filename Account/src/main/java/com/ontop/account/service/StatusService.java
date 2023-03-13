package com.ontop.account.service;

import com.ontop.account.model.Status;
import com.ontop.account.proxy.StatusProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusService{

    StatusProxy proxy;

    @Override
    public void saveStatus(Status status) {
        proxy.saveStatus(status);
    }

    @Autowired
    public void setProxy(StatusProxy proxy) {
        this.proxy = proxy;
    }
}
