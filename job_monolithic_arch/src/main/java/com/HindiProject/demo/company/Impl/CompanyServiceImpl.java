package com.HindiProject.demo.company.Impl;

import com.HindiProject.demo.company.Company;
import com.HindiProject.demo.company.CompanyService;
import com.HindiProject.demo.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository jpaReposotiry;

    public CompanyServiceImpl(CompanyRepository jpaReposotiry) {
        this.jpaReposotiry = jpaReposotiry;
    }

    @Override
    public List<Company> getAllCompanies() {
        return jpaReposotiry.findAll();
    }

    @Override
    public Boolean updateCompany(Long id, Company updated) {
        return jpaReposotiry.findById(id)
                .map(existing -> {
                    existing.setName(updated.getName());
                    existing.setDescription(updated.getDescription());
                    jpaReposotiry.save(existing);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public void createCompany(Company company) {
        jpaReposotiry.save(company);
    }

    @Override
    public Boolean deleteCompanyById(Long id) {
        if (jpaReposotiry.existsById(id)) {
            jpaReposotiry.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(Long id) {
        return jpaReposotiry.findById(id).orElse(null);
    }
}
