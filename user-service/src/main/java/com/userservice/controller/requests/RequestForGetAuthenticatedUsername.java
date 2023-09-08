package com.userservice.controller.requests;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "api-gateway", url = "localhost:8080/")
public interface RequestForGetAuthenticatedUsername {
    @GetMapping("getdata/get/username")
	String getUsername();
}
