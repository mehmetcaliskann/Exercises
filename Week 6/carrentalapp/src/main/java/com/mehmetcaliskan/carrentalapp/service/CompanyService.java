package com.mehmetcaliskan.carrentalapp.service;

import com.mehmetcaliskan.carrentalapp.entity.Company;
import com.mehmetcaliskan.carrentalapp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company getCompanyByName(String name) {
        return companyRepository.findByName(name);
    }

    public Company updateCompany(Long id, Company company) {
        Company company1 = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        company1.setCity(company.getCity());
        company1.setName(company.getName());
        company1.setUsername(company.getUsername());
        company1.setPassword(company.getPassword());
        return companyRepository.save(company1);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
