package com.ontop.status.service;

import com.ontop.status.model.Status;

import java.util.List;

public interface IStatusService {

    List<Status> getStatusByUser(Long userId);

    void createStatus(Status status);

    List<Status> getStatusByUserAmountTimestamp(Status status, int pageNumber, int size);
}
