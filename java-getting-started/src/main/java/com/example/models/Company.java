package com.example.models;

import java.util.List;

public class Company {

	private String symbol;
	private String companyName;
	private String exchange;
	private String industry;
	private String website;
	private String description;
	private String CEO;
	private String issueType;
	private String sector;
	private List<String> tags;

	public Company() {
	}

	public Company(String symbol, String companyName, String exchange, String industry, String website,
			String description, String CEO, String issueType, String sector, List<String> tags) {
		this.symbol = symbol;
		this.companyName = companyName;
		this.exchange = exchange;
		this.industry = industry;
		this.website = website;
		this.description = description;
		this.CEO = CEO;
		this.issueType = issueType;
		this.sector = sector;
		this.tags = tags;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExchange() {
		return this.exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCEO() {
		return this.CEO;
	}

	public void setCEO(String CEO) {
		this.CEO = CEO;
	}

	public String getIssueType() {
		return this.issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public List<String> getTags() {
		return this.tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
