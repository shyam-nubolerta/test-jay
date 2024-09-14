package com.example.springtest.feignclient;

import com.example.springtest.dto.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "thirdPartyServiceClient", url = "http://example.com")
public interface ThirdPartyServiceClient {

    @PostMapping
    ResponseEntity<String> submitToThirdParty(@RequestHeader(value = "url") String url, @RequestBody UserRequest userRequest);
}
