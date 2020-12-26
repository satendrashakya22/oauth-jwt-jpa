package com.resource.server.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resource.server.config.model.AccessTokenMapper;
import com.resource.server.controllers.exceptions.NoDataFoundException;
import com.resource.server.controllers.exceptions.RequiredFieldException;
import com.resource.server.entity.CompanyConfig;
import com.resource.server.services.CompanyConfigService;

@RestController
@RequestMapping("/admin")
public class CompanyConfigController {

	@Autowired
	private CompanyConfigService companyConfigService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addConfig")
	public CompanyConfig addConfig(@RequestBody CompanyConfig companyConfig) {
		if(null==companyConfig.getCompanyId()) {
			throw new RequiredFieldException("Company Id is Required");
		}
		return companyConfigService.addCompanyConfig(companyConfig);
	}
	

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/getConfig")
	public List<CompanyConfig> getAllConfig() {
		Optional<List<CompanyConfig>> confilgList=companyConfigService.getComanyConfig();
		return confilgList.orElseThrow(()-> new NoDataFoundException("No Data Found"));
	}
	

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/getConfig/{companyId}")
	public CompanyConfig getCompanyConfig(@PathVariable("companyId") Long companyId) {
		return companyConfigService.getComanyConfigByCompanyId(companyId).orElseThrow(()->new NoDataFoundException("No Data Found"));
	}
	
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/getTokenDetails")
	public AccessTokenMapper getToken() {
		AccessTokenMapper accessTokenMapper = (AccessTokenMapper)
						((OAuth2AuthenticationDetails) SecurityContextHolder
						.getContext()
						.getAuthentication()
						.getDetails())
				.getDecodedDetails();
		
		return accessTokenMapper;
	}
	
}
