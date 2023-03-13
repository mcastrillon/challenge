package com.ontop.status.service;

import com.ontop.status.model.Status;
import com.ontop.status.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements IStatusService{

    private StatusRepository statusRepository;

    public List<Status> getStatusByUser(Long userId){

        return statusRepository.findAllByUserId(userId);

    }

    @Override
    public void createStatus(Status status) {

        statusRepository.save(status);
    }

    public List<Status> getStatusByUserAmountTimestamp(Status status, int pageNumber, int size){

        Pageable paging = PageRequest.of(pageNumber, size, Sort.by("timestamp").descending());
        Page<Status> page = statusRepository.findByUserIdAndAmountAndTimestamp(
                status.getUserId(),status.getAmount(), status.getTimestamp(), paging);

        return page.getContent();
    }

    @Autowired
    public void setStatusRepository(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
}
