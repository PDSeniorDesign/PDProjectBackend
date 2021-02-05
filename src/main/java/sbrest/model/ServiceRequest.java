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

@Entity
@Table(name = "service_requests")
public class ServiceRequest {
	private static final long serialVersionUID = 1L;
	
	@Id
    private Integer requestNumber;

	private String createDate;
	private String submitDate;
	private String requestStatus;
	private boolean isComplete;
	private String registrationType;
	private String requestType;
	private String lastName;
	private String firstName;
	private String middleInitial;
	private Integer employeeNumber;
	private Integer hostedId;
	private String departmentName;
	private Integer departmentNumber;
	private String companyName;
	private String companyEmailAddress;
	private String departmentEmailAddress;
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
	private String workPhoneNumber;
	private Integer contractWorkOrderNumber;
	private String contractExpirationDate;
	private String customerSignature;
	private String customerSignatureDate;
	private Integer ibmLogOnId;
	private Integer majorGroupCode;
	private Integer lsoGroupCode;
	private String securityAuthorization;
	private boolean tsoAccess;
	private Integer tsoGroupCode;
	private Integer binNumber;
	private String subGroup1;
	private String subGroup2;
	private String subGroup3;
	private boolean onlineAccess;
	private String systemApplication;
	private String groupName;
	private String oldGroup;
	private String apsAo;
	private String dmvSystemCode;
	private String jaiSystemLocation;
	private String unixRequestType;
	private Integer unixLogOnId;
	private String unixApplication;
	private String unixAccessGroup;
	private Integer unixAccountNumber;
	private Integer billingAccountNumber;
	private String accessType;
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
		String pattern = "MM/dd/yyyy HH:mm:ss";
		DateFormat d = new SimpleDateFormat(pattern);
		Date currentDate = Calendar.getInstance().getTime();        
		this.createDate = d.format(currentDate);
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
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRegistrationType() {
		return registrationType;
	}
	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
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
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Integer getHostedId() {
		return hostedId;
	}
	public void setHostedId(Integer hostedId) {
		this.hostedId = hostedId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(Integer departmentNumber) {
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
	public String getDepartmentEmailAddress() {
		return departmentEmailAddress;
	}
	public void setDepartmentEmailAddress(String departmentEmailAddress) {
		this.departmentEmailAddress = departmentEmailAddress;
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
	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}
	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}
	public Integer getContractWorkOrderNumber() {
		return contractWorkOrderNumber;
	}
	public void setContractWorkOrderNumber(Integer contractWorkOrderNumber) {
		this.contractWorkOrderNumber = contractWorkOrderNumber;
	}
	public String getContractExpirationDate() {
		return contractExpirationDate;
	}
	public void setContractExpirationDate(String contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}
	public String getCustomerSignature() {
		return customerSignature;
	}
	public void setCustomerSignature(String customerSignature) {
		this.customerSignature = customerSignature;
	}
	public String getCustomerSignatureDate() {
		return customerSignatureDate;
	}
	public void setCustomerSignatureDate(String customerSignatureDate) {
		this.customerSignatureDate = customerSignatureDate;
	}
	public Integer getIbmLogOnId() {
		return ibmLogOnId;
	}
	public void setIbmLogOnId(Integer ibmLogOnId) {
		this.ibmLogOnId = ibmLogOnId;
	}
	public Integer getMajorGroupCode() {
		return majorGroupCode;
	}
	public void setMajorGroupCode(Integer majorGroupCode) {
		this.majorGroupCode = majorGroupCode;
	}
	public Integer getLsoGroupCode() {
		return lsoGroupCode;
	}
	public void setLsoGroupCode(Integer lsoGroupCode) {
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
	public Integer getTsoGroupCode() {
		return tsoGroupCode;
	}
	public void setTsoGroupCode(Integer tsoGroupCode) {
		this.tsoGroupCode = tsoGroupCode;
	}
	public Integer getBinNumber() {
		return binNumber;
	}
	public void setBinNumber(Integer binNumber) {
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
	public String getApsAo() {
		return apsAo;
	}
	public void setApsAo(String apsAo) {
		this.apsAo = apsAo;
	}
	public String getDmvSystemCode() {
		return dmvSystemCode;
	}
	public void setDmvSystemCode(String dmvSystemCode) {
		this.dmvSystemCode = dmvSystemCode;
	}
	public String getJaiSystemLocation() {
		return jaiSystemLocation;
	}
	public void setJaiSystemLocation(String jaiSystemLocation) {
		this.jaiSystemLocation = jaiSystemLocation;
	}
	public String getUnixRequestType() {
		return unixRequestType;
	}
	public void setUnixRequestType(String unixRequestType) {
		this.unixRequestType = unixRequestType;
	}
	public Integer getUnixLogOnId() {
		return unixLogOnId;
	}
	public void setUnixLogOnId(Integer unixLogOnId) {
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
	public Integer getUnixAccountNumber() {
		return unixAccountNumber;
	}
	public void setUnixAccountNumber(Integer unixAccountNumber) {
		this.unixAccountNumber = unixAccountNumber;
	}
	public Integer getBillingAccountNumber() {
		return billingAccountNumber;
	}
	public void setBillingAccountNumber(Integer billingAccountNumber) {
		this.billingAccountNumber = billingAccountNumber;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
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
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	public Integer getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(Integer requestNumber) {
		this.requestNumber = requestNumber;
	}

	
}
