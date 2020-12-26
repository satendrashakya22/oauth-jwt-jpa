package com.resource.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resource.server.entity.CompanyConfig;

public interface CompanyConfigDAO extends JpaRepository<CompanyConfig, Long> {

	CompanyConfig findByCompanyId(Long companyId);

}
