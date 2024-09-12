package com.nuwaish.companyms.company;

import com.nuwaish.companyms.company.dto.ReviewMessage;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean updateCompanyById(Company company, Long id);

    boolean deleteCompanyById(Long id);

    public void updateCompanyRating(ReviewMessage reviewMessage);
}
