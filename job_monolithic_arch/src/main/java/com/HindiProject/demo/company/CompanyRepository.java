package com.HindiProject.demo.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    //JpaReposotiry getAllReviewsByCompanyId(Long companyId);
}
