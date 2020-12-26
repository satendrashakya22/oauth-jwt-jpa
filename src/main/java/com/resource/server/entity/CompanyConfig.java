package com.resource.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_config")
public class CompanyConfig {

	@Id
	@Column(name="company_id")
	private Long companyId;
	
	@Column(name="popup_type")
	private String popupType;
	
	@Column(name="seconds")
	private int seconds;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="phone")
	private String phone;


	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getPopupType() {
		return popupType;
	}

	public void setPopupType(String popupType) {
		this.popupType = popupType;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "CompanyConfig [companyId=" + companyId + ", popupType=" + popupType + ", seconds=" + seconds + ", emailId=" + emailId
				+ ", phone=" + phone + "]";
	}
	
	
	
}
