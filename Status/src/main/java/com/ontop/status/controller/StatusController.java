package com.ontop.status.controller;

import com.ontop.status.model.Status;
import com.ontop.status.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {

    private IStatusService statusService;
    @GetMapping("/status/{userId}")
    public List<Status> getStatusByUser(@PathVariable Long userId) {

        return statusService.getStatusByUser(userId);
    }

    @PostMapping("/status")
    public void createStatus(@RequestBody Status status) {
        statusService.createStatus(status);
    }


    @PostMapping("/statuses")
    public List<Status> getStatusByAmountDate(
            @RequestBody Status status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {

        return statusService.getStatusByUserAmountTimestamp(status, page, size);
    }

    @Autowired
    public void setStatusService(IStatusService statusService) {
        this.statusService = statusService;
    }
}
