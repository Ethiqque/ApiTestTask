package org.ethiqque.apitesttask.client;

import org.ethiqque.apitesttask.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "thirdPartyService")
public interface ThirdPartyServiceClient {

    @PostMapping("/submit")
    void submitUserDetails(@RequestBody User user);
}
