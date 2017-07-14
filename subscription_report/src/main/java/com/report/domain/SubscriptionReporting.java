package com.report.domain;

import java.io.Serializable;

public class SubscriptionReporting implements Serializable{
	
	/**
	 * 
	 */
	
	private int id;
	private String TenantId;
	private String ProviderName;
	private String ServiceName;
	private String UserId;
	private String NowDateString;
	private String Platform;
	private String ContentId;
	private String SolutionOfferId;
	private String SubscriptionId;
	private String State;
	private String Subscription_Activation_Date;
	private String Subscription_Deactivation_Date;
	private String ContentType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenantId() {
		return TenantId;
	}
	public void setTenantId(String tenantId) {
		TenantId = tenantId;
	}
	public String getProviderName() {
		return ProviderName;
	}
	public void setProviderName(String providerName) {
		ProviderName = providerName;
	}
	public String getServiceName() {
		return ServiceName;
	}
	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getNowDateString() {
		return NowDateString;
	}
	public void setNowDateString(String nowDateString) {
		NowDateString = nowDateString;
	}
	public String getPlatform() {
		return Platform;
	}
	public void setPlatform(String platform) {
		Platform = platform;
	}
	public String getContentId() {
		return ContentId;
	}
	public void setContentId(String contentId) {
		ContentId = contentId;
	}
	public String getSolutionOfferId() {
		return SolutionOfferId;
	}
	public void setSolutionOfferId(String solutionOfferId) {
		SolutionOfferId = solutionOfferId;
	}
	public String getSubscriptionId() {
		return SubscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		SubscriptionId = subscriptionId;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getSubscription_Activation_Date() {
		return Subscription_Activation_Date;
	}
	public void setSubscription_Activation_Date(String subscription_Activation_Date) {
		Subscription_Activation_Date = subscription_Activation_Date;
	}
	public String getSubscription_Deactivation_Date() {
		return Subscription_Deactivation_Date;
	}
	public void setSubscription_Deactivation_Date(
			String subscription_Deactivation_Date) {
		Subscription_Deactivation_Date = subscription_Deactivation_Date;
	}
	public String getContentType() {
		return ContentType;
	}
	public void setContentType(String contentType) {
		ContentType = contentType;
	}
		
	}
