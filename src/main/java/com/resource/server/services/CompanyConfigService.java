package com.resource.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resource.server.dao.CompanyConfigDAO;
import com.resource.server.entity.CompanyConfig;

@Service
public class CompanyConfigService {

	@Autowired
	private CompanyConfigDAO companyConfigDAO;
	
	public CompanyConfig addCompanyConfig(CompanyConfig companyConfig) {
		return companyConfigDAO.save(companyConfig);
	}

	public Optional<List<CompanyConfig>> getComanyConfig() {
		return Optional.ofNullable(companyConfigDAO.findAll());
	}

	public Optional<CompanyConfig> getComanyConfigByCompanyId(Long companyId) {
		return Optional.ofNullable(companyConfigDAO.findByCompanyId(companyId));
	}
}
