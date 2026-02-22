package com.HindiProject.demo.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Boolean updateCompany(Long id, Company updated);
    void createCompany(Company company);
    Boolean deleteCompanyById(Long Id);
    Company getCompanyById(Long Id);

}
