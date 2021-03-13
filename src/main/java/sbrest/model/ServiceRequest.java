package sbrest.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import sbrest.signapi.Agreements;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer requestNumber;

	private String createDate;
	private String submitDate;
	private boolean isEmployee;
	private String requestStatus;
	private boolean isComplete;
	private boolean newRegistration;
	private boolean deletePriorRegistration;
	private boolean updatePriorRegistration;
	private boolean replaceLostToken;
	private boolean addLogonId;
	private boolean changeLogonId;
	private boolean deleteLogonId;
	private String lastName;
	private String firstName;
	private String middleInitial;
	private String employeeNumber;
	private String hostedId;
	private String departmentName;
	private String departmentNumber;
	private String companyName;
	private String companyEmailAddress;
	private String countyEmailAddress;
	private String employeeEmailAddress;
	private String businessStreetAddress;
	private String businessCity;
	private String businessState;
	private String businessZip;
	private String businessPhoneNumber;
	private String workMailingAddress;
	private String companyStreetAddress;
	private String companyCity;
	private String companyState;
	private String companyZip;
	private String companyPhoneNumber;
	private String countyPhoneNumber;
	private String contractWorkOrderNumber;
	private String contractExpirationDate;
	private String ibmLogOnId;
	private String majorGroupCode;
	private String lsoGroupCode;
	private String securityAuthorization;
	private boolean tsoAccess;
	private String tsoGroupCode;
	private String binNumber;
	private String subGroup1;
	private String subGroup2;
	private String subGroup3;
	private boolean onlineAccess;
	private String systemApplication;
	private String groupName;
	private String oldGroup;
	private boolean unixAddLogonId;
	private boolean unixChangeLogonId;
	private boolean unixDeleteLogonId;
	private String unixLogOnId;
	private String unixApplication;
	private String unixAccessGroup;
	private String unixAccountNumber;
	private String billingAccountNumber;
	private boolean securIdVpn;
	private boolean adaptiveAuthenticationVpn;
	private boolean internetApplication;
	private boolean exchangeEmail;
	private boolean emailEncryption;
	private boolean laCountyGovAccess;
	private boolean tokenlessAuthentication;
	private boolean lacMobileWifiAccess;
	private boolean cherwellSms;
	private boolean windowsRightsMgmt;
	private boolean gmailAccess;
	private boolean yahooMailAccess;
	private boolean otherEmailAccess;
	private String otherEmailDomain;
	private String businessJustification;
	private boolean defaultCountyWidePolicy;
	private boolean departmentPolicyRule0;
	private boolean departmentPolicyRule1;
	private boolean departmentPolicyRule2;
	private boolean departmentPolicyRule3;
	private boolean departmentPolicyRule4;
	private boolean socialNetworkingFacebook;
	private boolean socialNetworkingTwitter;
	private boolean socialNetworkingLinkedIn;

	public ServiceRequest() {
		String pattern = "MM/dd/yyyy";
		DateFormat d = new SimpleDateFormat(pattern);
		Date currentDate = Calendar.getInstance().getTime();
		this.createDate = d.format(currentDate);
		this.requestStatus = "Draft";
		
		this.lastName = "";
		this.firstName = "";
		this.middleInitial = "";
		this.employeeNumber = "";
		this.hostedId = "";
		this.departmentName = "";
		this.departmentNumber = "";
		this.companyName = "";
		this.companyEmailAddress = "";
		this.countyEmailAddress = "";
		this.employeeEmailAddress = "";
		this.businessStreetAddress = "";
		this.businessCity = "";
		this.businessState = "";
		this.businessZip = "";
		this.businessPhoneNumber = "";
		this.workMailingAddress = "";
		this.companyStreetAddress = "";
		this.companyCity = "";
		this.companyState = "";
		this.companyZip = "";
		this.companyPhoneNumber = "";
		this.countyPhoneNumber = "";
		this.contractWorkOrderNumber = "";
		this.contractExpirationDate = "";
		this.ibmLogOnId = "";
		this.majorGroupCode = "";
		this.lsoGroupCode = "";
		this.securityAuthorization = "";
		this.tsoGroupCode = "";
		this.binNumber = "";
		this.subGroup1 = "";
		this.subGroup2 = "";
		this.subGroup3 = "";
		this.systemApplication = "";
		this.groupName = "";
		this.oldGroup = "";
		this.unixLogOnId = "";
		this.unixApplication = "";
		this.unixAccessGroup = "";
		this.unixAccountNumber = "";
		this.billingAccountNumber = "";
		this.otherEmailDomain = "";
		this.businessJustification = "";
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public boolean isNewRegistration() {
		return newRegistration;
	}

	public void setNewRegistration(boolean newRegistration) {
		this.newRegistration = newRegistration;
	}

	public boolean isDeletePriorRegistration() {
		return deletePriorRegistration;
	}

	public void setDeletePriorRegistration(boolean deletePriorRegistration) {
		this.deletePriorRegistration = deletePriorRegistration;
	}

	public boolean isUpdatePriorRegistration() {
		return updatePriorRegistration;
	}

	public void setUpdatePriorRegistration(boolean updatePriorRegistration) {
		this.updatePriorRegistration = updatePriorRegistration;
	}

	public boolean isReplaceLostToken() {
		return replaceLostToken;
	}

	public void setReplaceLostToken(boolean replaceLostToken) {
		this.replaceLostToken = replaceLostToken;
	}

	public boolean isAddLogonId() {
		return addLogonId;
	}

	public void setAddLogonId(boolean addLogonId) {
		this.addLogonId = addLogonId;
	}

	public boolean isChangeLogonId() {
		return changeLogonId;
	}

	public void setChangeLogonId(boolean changeLogonId) {
		this.changeLogonId = changeLogonId;
	}

	public boolean isDeleteLogonId() {
		return deleteLogonId;
	}

	public void setDeleteLogonId(boolean deleteLogonId) {
		this.deleteLogonId = deleteLogonId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getHostedId() {
		return hostedId;
	}

	public void setHostedId(String hostedId) {
		this.hostedId = hostedId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(String departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmailAddress() {
		return companyEmailAddress;
	}

	public void setCompanyEmailAddress(String companyEmailAddress) {
		this.companyEmailAddress = companyEmailAddress;
	}

	public String getCountyEmailAddress() {
		return countyEmailAddress;
	}

	public void setCountyEmailAddress(String countyEmailAddress) {
		this.countyEmailAddress = countyEmailAddress;
	}

	public String getEmployeeEmailAddress() {
		return employeeEmailAddress;
	}

	public void setEmployeeEmailAddress(String employeeEmailAddress) {
		this.employeeEmailAddress = employeeEmailAddress;
	}

	public String getBusinessStreetAddress() {
		return businessStreetAddress;
	}

	public void setBusinessStreetAddress(String businessStreetAddress) {
		this.businessStreetAddress = businessStreetAddress;
	}

	public String getBusinessCity() {
		return businessCity;
	}

	public void setBusinessCity(String businessCity) {
		this.businessCity = businessCity;
	}

	public String getBusinessState() {
		return businessState;
	}

	public void setBusinessState(String businessState) {
		this.businessState = businessState;
	}

	public String getBusinessZip() {
		return businessZip;
	}

	public void setBusinessZip(String businessZip) {
		this.businessZip = businessZip;
	}

	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}

	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}

	public String getWorkMailingAddress() {
		return workMailingAddress;
	}

	public void setWorkMailingAddress(String workMailingAddress) {
		this.workMailingAddress = workMailingAddress;
	}

	public String getCompanyStreetAddress() {
		return companyStreetAddress;
	}

	public void setCompanyStreetAddress(String companyStreetAddress) {
		this.companyStreetAddress = companyStreetAddress;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public String getCompanyZip() {
		return companyZip;
	}

	public void setCompanyZip(String companyZip) {
		this.companyZip = companyZip;
	}

	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public String getCountyPhoneNumber() {
		return countyPhoneNumber;
	}

	public void setCountyPhoneNumber(String countyPhoneNumber) {
		this.countyPhoneNumber = countyPhoneNumber;
	}

	public String getContractWorkOrderNumber() {
		return contractWorkOrderNumber;
	}

	public void setContractWorkOrderNumber(String contractWorkOrderNumber) {
		this.contractWorkOrderNumber = contractWorkOrderNumber;
	}

	public String getContractExpirationDate() {
		return contractExpirationDate;
	}

	public void setContractExpirationDate(String contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}

	public String getIbmLogOnId() {
		return ibmLogOnId;
	}

	public void setIbmLogOnId(String ibmLogOnId) {
		this.ibmLogOnId = ibmLogOnId;
	}

	public String getMajorGroupCode() {
		return majorGroupCode;
	}

	public void setMajorGroupCode(String majorGroupCode) {
		this.majorGroupCode = majorGroupCode;
	}

	public String getLsoGroupCode() {
		return lsoGroupCode;
	}

	public void setLsoGroupCode(String lsoGroupCode) {
		this.lsoGroupCode = lsoGroupCode;
	}

	public String getSecurityAuthorization() {
		return securityAuthorization;
	}

	public void setSecurityAuthorization(String securityAuthorization) {
		this.securityAuthorization = securityAuthorization;
	}

	public boolean isTsoAccess() {
		return tsoAccess;
	}

	public void setTsoAccess(boolean tsoAccess) {
		this.tsoAccess = tsoAccess;
	}

	public String getTsoGroupCode() {
		return tsoGroupCode;
	}

	public void setTsoGroupCode(String tsoGroupCode) {
		this.tsoGroupCode = tsoGroupCode;
	}

	public String getBinNumber() {
		return binNumber;
	}

	public void setBinNumber(String binNumber) {
		this.binNumber = binNumber;
	}

	public String getSubGroup1() {
		return subGroup1;
	}

	public void setSubGroup1(String subGroup1) {
		this.subGroup1 = subGroup1;
	}

	public String getSubGroup2() {
		return subGroup2;
	}

	public void setSubGroup2(String subGroup2) {
		this.subGroup2 = subGroup2;
	}

	public String getSubGroup3() {
		return subGroup3;
	}

	public void setSubGroup3(String subGroup3) {
		this.subGroup3 = subGroup3;
	}

	public boolean isOnlineAccess() {
		return onlineAccess;
	}

	public void setOnlineAccess(boolean onlineAccess) {
		this.onlineAccess = onlineAccess;
	}

	public String getSystemApplication() {
		return systemApplication;
	}

	public void setSystemApplication(String systemApplication) {
		this.systemApplication = systemApplication;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getOldGroup() {
		return oldGroup;
	}

	public void setOldGroup(String oldGroup) {
		this.oldGroup = oldGroup;
	}

	public boolean isUnixAddLogonId() {
		return unixAddLogonId;
	}

	public void setUnixAddLogonId(boolean unixAddLogonId) {
		this.unixAddLogonId = unixAddLogonId;
	}

	public boolean isUnixChangeLogonId() {
		return unixChangeLogonId;
	}

	public void setUnixChangeLogonId(boolean unixChangeLogonId) {
		this.unixChangeLogonId = unixChangeLogonId;
	}

	public boolean isUnixDeleteLogonId() {
		return unixDeleteLogonId;
	}

	public void setUnixDeleteLogonId(boolean unixDeleteLogonId) {
		this.unixDeleteLogonId = unixDeleteLogonId;
	}

	public String getUnixLogOnId() {
		return unixLogOnId;
	}

	public void setUnixLogOnId(String unixLogOnId) {
		this.unixLogOnId = unixLogOnId;
	}

	public String getUnixApplication() {
		return unixApplication;
	}

	public void setUnixApplication(String unixApplication) {
		this.unixApplication = unixApplication;
	}

	public String getUnixAccessGroup() {
		return unixAccessGroup;
	}

	public void setUnixAccessGroup(String unixAccessGroup) {
		this.unixAccessGroup = unixAccessGroup;
	}

	public String getUnixAccountNumber() {
		return unixAccountNumber;
	}

	public void setUnixAccountNumber(String unixAccountNumber) {
		this.unixAccountNumber = unixAccountNumber;
	}

	public String getBillingAccountNumber() {
		return billingAccountNumber;
	}

	public void setBillingAccountNumber(String billingAccountNumber) {
		this.billingAccountNumber = billingAccountNumber;
	}

	public boolean isSecurIdVpn() {
		return securIdVpn;
	}

	public void setSecurIdVpn(boolean securIdVpn) {
		this.securIdVpn = securIdVpn;
	}

	public boolean isAdaptiveAuthenticationVpn() {
		return adaptiveAuthenticationVpn;
	}

	public void setAdaptiveAuthenticationVpn(boolean adaptiveAuthenticationVpn) {
		this.adaptiveAuthenticationVpn = adaptiveAuthenticationVpn;
	}

	public boolean isInternetApplication() {
		return internetApplication;
	}

	public void setInternetApplication(boolean internetApplication) {
		this.internetApplication = internetApplication;
	}

	public boolean isExchangeEmail() {
		return exchangeEmail;
	}

	public void setExchangeEmail(boolean exchangeEmail) {
		this.exchangeEmail = exchangeEmail;
	}

	public boolean isEmailEncryption() {
		return emailEncryption;
	}

	public void setEmailEncryption(boolean emailEncryption) {
		this.emailEncryption = emailEncryption;
	}

	public boolean isLaCountyGovAccess() {
		return laCountyGovAccess;
	}

	public void setLaCountyGovAccess(boolean laCountyGovAccess) {
		this.laCountyGovAccess = laCountyGovAccess;
	}

	public boolean isTokenlessAuthentication() {
		return tokenlessAuthentication;
	}

	public void setTokenlessAuthentication(boolean tokenlessAuthentication) {
		this.tokenlessAuthentication = tokenlessAuthentication;
	}

	public boolean isLacMobileWifiAccess() {
		return lacMobileWifiAccess;
	}

	public void setLacMobileWifiAccess(boolean lacMobileWifiAccess) {
		this.lacMobileWifiAccess = lacMobileWifiAccess;
	}

	public boolean isCherwellSms() {
		return cherwellSms;
	}

	public void setCherwellSms(boolean cherwellSms) {
		this.cherwellSms = cherwellSms;
	}

	public boolean isWindowsRightsMgmt() {
		return windowsRightsMgmt;
	}

	public void setWindowsRightsMgmt(boolean windowsRightsMgmt) {
		this.windowsRightsMgmt = windowsRightsMgmt;
	}

	public boolean isGmailAccess() {
		return gmailAccess;
	}

	public void setGmailAccess(boolean gmailAccess) {
		this.gmailAccess = gmailAccess;
	}

	public boolean isYahooMailAccess() {
		return yahooMailAccess;
	}

	public void setYahooMailAccess(boolean yahooMailAccess) {
		this.yahooMailAccess = yahooMailAccess;
	}

	public boolean isOtherEmailAccess() {
		return otherEmailAccess;
	}

	public void setOtherEmailAccess(boolean otherEmailAccess) {
		this.otherEmailAccess = otherEmailAccess;
	}

	public String getOtherEmailDomain() {
		return otherEmailDomain;
	}

	public void setOtherEmailDomain(String otherEmailDomain) {
		this.otherEmailDomain = otherEmailDomain;
	}

	public String getBusinessJustification() {
		return businessJustification;
	}

	public void setBusinessJustification(String businessJustification) {
		this.businessJustification = businessJustification;
	}

	public boolean isDefaultCountyWidePolicy() {
		return defaultCountyWidePolicy;
	}

	public void setDefaultCountyWidePolicy(boolean defaultCountyWidePolicy) {
		this.defaultCountyWidePolicy = defaultCountyWidePolicy;
	}

	public boolean isDepartmentPolicyRule0() {
		return departmentPolicyRule0;
	}

	public void setDepartmentPolicyRule0(boolean departmentPolicyRule0) {
		this.departmentPolicyRule0 = departmentPolicyRule0;
	}

	public boolean isDepartmentPolicyRule1() {
		return departmentPolicyRule1;
	}

	public void setDepartmentPolicyRule1(boolean departmentPolicyRule1) {
		this.departmentPolicyRule1 = departmentPolicyRule1;
	}

	public boolean isDepartmentPolicyRule2() {
		return departmentPolicyRule2;
	}

	public void setDepartmentPolicyRule2(boolean departmentPolicyRule2) {
		this.departmentPolicyRule2 = departmentPolicyRule2;
	}

	public boolean isDepartmentPolicyRule3() {
		return departmentPolicyRule3;
	}

	public void setDepartmentPolicyRule3(boolean departmentPolicyRule3) {
		this.departmentPolicyRule3 = departmentPolicyRule3;
	}

	public boolean isDepartmentPolicyRule4() {
		return departmentPolicyRule4;
	}

	public void setDepartmentPolicyRule4(boolean departmentPolicyRule4) {
		this.departmentPolicyRule4 = departmentPolicyRule4;
	}

	public boolean isSocialNetworkingFacebook() {
		return socialNetworkingFacebook;
	}

	public void setSocialNetworkingFacebook(boolean socialNetworkingFacebook) {
		this.socialNetworkingFacebook = socialNetworkingFacebook;
	}

	public boolean isSocialNetworkingTwitter() {
		return socialNetworkingTwitter;
	}

	public void setSocialNetworkingTwitter(boolean socialNetworkingTwitter) {
		this.socialNetworkingTwitter = socialNetworkingTwitter;
	}

	public boolean isSocialNetworkingLinkedIn() {
		return socialNetworkingLinkedIn;
	}

	public void setSocialNetworkingLinkedIn(boolean socialNetworkingLinkedIn) {
		this.socialNetworkingLinkedIn = socialNetworkingLinkedIn;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) throws Exception {
		this.isComplete = isComplete;
		if (this.isComplete) {
			this.requestStatus = "Submitted";
			String pattern = "MM/dd/yyyy";
			DateFormat d = new SimpleDateFormat(pattern);
			Date currentDate = Calendar.getInstance().getTime();
			this.submitDate = d.format(currentDate);
			
			if (this.isEmployee) {
				Agreements.sendEmployeeAgreement(this);
			}
			else {
				Agreements.sendContractorAgreement(this);
			}
		}
		else {
			this.requestStatus = "Draft";
			this.submitDate = "";
		}
	}

	public Integer getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

}