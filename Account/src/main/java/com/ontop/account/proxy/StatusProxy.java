package com.ontop.account.proxy;

import com.ontop.account.model.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="status")
public interface StatusProxy {

    @PostMapping("/status")
    ResponseEntity<Void> saveStatus(@RequestBody Status status);

}
