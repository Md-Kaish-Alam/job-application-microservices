package com.nuwaish.jobms.job.clients;

import com.nuwaish.jobms.job.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-SERVICE", url = "${company-service.url}")
public interface CompanyClient {

    @GetMapping("/companies/{companyId}")
    Company getCompany(@PathVariable("companyId") Long companyId);
}
