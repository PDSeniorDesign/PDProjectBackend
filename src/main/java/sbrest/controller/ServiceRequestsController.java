package sbrest.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sbrest.model.ServiceRequest;
import sbrest.model.dao.ServiceRequestDao;
import sbrest.service.ServiceRequestService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service_requests")
public class ServiceRequestsController {

	@Autowired
	private ServiceRequestDao serviceRequestDao;

	@Autowired
	private ServiceRequestService serviceRequestService;

	@GetMapping
	public List<ServiceRequest> serviceRequests(ModelMap models) {
		return serviceRequestDao.getServiceRequests();
	}

	@GetMapping("/{requestNumber}")
	public ServiceRequest get(@PathVariable Integer requestNumber) {
		ServiceRequest s = serviceRequestDao.getServiceRequest(requestNumber);
		if (s == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Request not found");
		return s;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceRequest add(@RequestBody ServiceRequest s) {
		// Generate a six digit code
		Random rnd = new Random();
		int randomRequestNumber = 100000 + rnd.nextInt(900000);

		// Check if it exists in database
		// If it does exists, regenerate the number (Do this until six digit code is
		// unique)
		while (serviceRequestService.existsByRequestNumber(randomRequestNumber)) {
			randomRequestNumber = 100000 + rnd.nextInt(900000);
		}

		// Set requestNumber
		s.setRequestNumber(randomRequestNumber);
		return serviceRequestDao.saveServiceRequest(s);
	}

	@PutMapping("/{requestNumber}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ServiceRequest update(@PathVariable Integer requestNumber, @RequestBody ServiceRequest s) throws Exception {

		ServiceRequest originalServiceRequest = serviceRequestDao.getServiceRequest(requestNumber);

		originalServiceRequest.setCreateDate(s.getCreateDate());
		originalServiceRequest.setSubmitDate(s.getSubmitDate());
		originalServiceRequest.setEmployee(s.isEmployee());
		originalServiceRequest.setComplete(s.isComplete());
		originalServiceRequest.setRequestStatus(s.getRequestStatus());
		originalServiceRequest.setNewRegistration(s.isNewRegistration());
		originalServiceRequest.setDeletePriorRegistration(s.isDeletePriorRegistration());
		originalServiceRequest.setUpdatePriorRegistration(s.isUpdatePriorRegistration());
		originalServiceRequest.setReplaceLostToken(s.isReplaceLostToken());
		originalServiceRequest.setAddLogonId(s.isAddLogonId());
		originalServiceRequest.setChangeLogonId(s.isChangeLogonId());
		originalServiceRequest.setDeleteLogonId(s.isDeleteLogonId());
		originalServiceRequest.setLastName(s.getLastName());
		originalServiceRequest.setFirstName(s.getFirstName());
		originalServiceRequest.setMiddleInitial(s.getMiddleInitial());
		originalServiceRequest.setEmployeeNumber(s.getEmployeeNumber());
		originalServiceRequest.setHostedId(s.getHostedId());
		originalServiceRequest.setDepartmentName(s.getDepartmentName());
		originalServiceRequest.setDepartmentNumber(s.getDepartmentNumber());
		originalServiceRequest.setCompanyName(s.getCompanyName());
		originalServiceRequest.setCompanyEmailAddress(s.getCompanyEmailAddress());
		originalServiceRequest.setCountyEmailAddress(s.getCountyEmailAddress());
		originalServiceRequest.setEmployeeEmailAddress(s.getEmployeeEmailAddress());
		originalServiceRequest.setBusinessStreetAddress(s.getBusinessStreetAddress());
		originalServiceRequest.setBusinessCity(s.getBusinessCity());
		originalServiceRequest.setBusinessState(s.getBusinessState());
		originalServiceRequest.setBusinessZip(s.getBusinessZip());
		originalServiceRequest.setBusinessPhoneNumber(s.getBusinessPhoneNumber());
		originalServiceRequest.setWorkMailingAddress(s.getWorkMailingAddress());
		originalServiceRequest.setCompanyStreetAddress(s.getCompanyStreetAddress());
		originalServiceRequest.setCompanyCity(s.getCompanyCity());
		originalServiceRequest.setCompanyState(s.getCompanyState());
		originalServiceRequest.setCompanyZip(s.getCompanyZip());
		originalServiceRequest.setCompanyPhoneNumber(s.getCompanyPhoneNumber());
		originalServiceRequest.setCountyPhoneNumber(s.getCountyPhoneNumber());
		originalServiceRequest.setContractWorkOrderNumber(s.getContractWorkOrderNumber());
		originalServiceRequest.setContractExpirationDate(s.getContractExpirationDate());
		originalServiceRequest.setIbmLogOnId(s.getIbmLogOnId());
		originalServiceRequest.setMajorGroupCode(s.getMajorGroupCode());
		originalServiceRequest.setLsoGroupCode(s.getLsoGroupCode());
		originalServiceRequest.setSecurityAuthorization(s.getSecurityAuthorization());
		originalServiceRequest.setTsoAccess(s.isTsoAccess());
		originalServiceRequest.setTsoGroupCode(s.getTsoGroupCode());
		originalServiceRequest.setBinNumber(s.getBinNumber());
		originalServiceRequest.setSubGroup1(s.getSubGroup1());
		originalServiceRequest.setSubGroup2(s.getSubGroup2());
		originalServiceRequest.setSubGroup3(s.getSubGroup3());
		originalServiceRequest.setOnlineAccess(s.isOnlineAccess());
		originalServiceRequest.setSystemApplication(s.getSystemApplication());
		originalServiceRequest.setGroupName(s.getGroupName());
		originalServiceRequest.setOldGroup(s.getOldGroup());
		originalServiceRequest.setUnixAddLogonId(s.isUnixAddLogonId());
		originalServiceRequest.setUnixChangeLogonId(s.isUnixChangeLogonId());
		originalServiceRequest.setUnixDeleteLogonId(s.isUnixDeleteLogonId());
		originalServiceRequest.setUnixLogOnId(s.getUnixLogOnId());
		originalServiceRequest.setUnixApplication(s.getUnixApplication());
		originalServiceRequest.setUnixAccessGroup(s.getUnixAccessGroup());
		originalServiceRequest.setUnixAccountNumber(s.getUnixAccountNumber());
		originalServiceRequest.setBillingAccountNumber(s.getBillingAccountNumber());
		originalServiceRequest.setSecurIdVpn(s.isSecurIdVpn());
		originalServiceRequest.setAdaptiveAuthenticationVpn(s.isAdaptiveAuthenticationVpn());
		originalServiceRequest.setInternetApplication(s.isInternetApplication());
		originalServiceRequest.setExchangeEmail(s.isExchangeEmail());
		originalServiceRequest.setEmailEncryption(s.isEmailEncryption());
		originalServiceRequest.setLaCountyGovAccess(s.isLaCountyGovAccess());
		originalServiceRequest.setTokenlessAuthentication(s.isTokenlessAuthentication());
		originalServiceRequest.setLacMobileWifiAccess(s.isLacMobileWifiAccess());
		originalServiceRequest.setCherwellSms(s.isCherwellSms());
		originalServiceRequest.setWindowsRightsMgmt(s.isWindowsRightsMgmt());
		originalServiceRequest.setGmailAccess(s.isGmailAccess());
		originalServiceRequest.setYahooMailAccess(s.isYahooMailAccess());
		originalServiceRequest.setOtherEmailDomain(s.getOtherEmailDomain());
		originalServiceRequest.setBusinessJustification(s.getBusinessJustification());
		originalServiceRequest.setDefaultCountyWidePolicy(s.isDefaultCountyWidePolicy());
		originalServiceRequest.setDepartmentPolicyRule0(s.isDepartmentPolicyRule0());
		originalServiceRequest.setDepartmentPolicyRule1(s.isDepartmentPolicyRule1());
		originalServiceRequest.setDepartmentPolicyRule2(s.isDepartmentPolicyRule2());
		originalServiceRequest.setDepartmentPolicyRule3(s.isDepartmentPolicyRule3());
		originalServiceRequest.setDepartmentPolicyRule4(s.isDepartmentPolicyRule4());
		originalServiceRequest.setSocialNetworkingFacebook(s.isSocialNetworkingFacebook());
		originalServiceRequest.setSocialNetworkingTwitter(s.isSocialNetworkingTwitter());
		originalServiceRequest.setSocialNetworkingLinkedIn(s.isSocialNetworkingLinkedIn());

		originalServiceRequest = serviceRequestDao.saveServiceRequest(originalServiceRequest);
		return originalServiceRequest;

	}

	@PatchMapping("/{requestNumber}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ServiceRequest update(@PathVariable Integer requestNumber, @RequestBody Map<String, Object> patch) throws Exception {

		ServiceRequest s = serviceRequestDao.getServiceRequest(requestNumber);

		for (String key : patch.keySet()) {

			switch (key) {
			case "createDate":
				s.setCreateDate((String) patch.get(key));
				break;
			case "submitDate":
				s.setSubmitDate((String) patch.get(key));
				break;
			case "newRegistration":
				s.setNewRegistration((boolean) patch.get(key));
				break;
			case "deletePriorRegistration":
				s.setDeletePriorRegistration((boolean) patch.get(key));
				break;
			case "updatePriorRegistration":
				s.setUpdatePriorRegistration((boolean) patch.get(key));
				break;
			case "isEmployee":
				s.setEmployee((boolean) patch.get(key));
				break;
			case "isComplete":
				s.setComplete((boolean) patch.get(key));
				break;
				// A.V.
			case "replaceLostToken":
				s.setReplaceLostToken((boolean) patch.get(key));
				break;
			case "addLogonId":
				s.setAddLogonId((boolean) patch.get(key));
				break;
			case "changeLogonId":
				s.setChangeLogonId((boolean) patch.get(key));
				break;
			case "deleteLogonId":
				s.setDeleteLogonId((boolean) patch.get(key));
				break;
			case "requestStatus":
				s.setRequestStatus((String) patch.get(key));
				break;
			case "lastName":
				s.setLastName((String) patch.get(key));
				break;
			case "firstName":
				s.setFirstName((String) patch.get(key));
				break;
			case "middleInitial":
				s.setMiddleInitial((String) patch.get(key));
				break;
			case "employeeNumber":
				s.setEmployeeNumber((String) patch.get(key));
				break;
			case "hostedId":
				s.setHostedId((String) patch.get(key));
				break;
			case "departmentName":
				s.setDepartmentName((String) patch.get(key));
				break;
			case "departmentNumber":
				s.setDepartmentNumber((String) patch.get(key));
				break;
			case "companyName":
				s.setCompanyName((String) patch.get(key));
				break;
			case "companyEmailAddress":
				s.setCompanyEmailAddress((String) patch.get(key));
				break;
			case "countyEmailAddress":
				s.setCountyEmailAddress((String) patch.get(key));
				break;
			case "employeeEmailAddress":
				s.setEmployeeEmailAddress((String) patch.get(key));
				break;
			case "businessStreetAddress":
				s.setBusinessStreetAddress((String) patch.get(key));
				break;
			case "businessCity":
				s.setBusinessCity((String) patch.get(key));
				break;
			case "businessState":
				s.setBusinessState((String) patch.get(key));
				break;
			case "businessZip":
				s.setBusinessZip((String) patch.get(key));
				break;
			case "businessPhoneNumber":
				s.setBusinessPhoneNumber((String) patch.get(key));
				break;
			case "workMailingAddress":
				s.setWorkMailingAddress((String) patch.get(key));
				break;
			case "companyStreetAddress":
				s.setCompanyStreetAddress((String) patch.get(key));
				break;
			case "companyCity":
				s.setCompanyCity((String) patch.get(key));
				break;
			case "companyState":
				s.setCompanyState((String) patch.get(key));
				break;
			case "companyZip":
				s.setCompanyZip((String) patch.get(key));
				break;
			case "companyPhoneNumber":
				s.setCompanyPhoneNumber((String) patch.get(key));
				break;
			case "countyPhoneNumber":
				s.setCountyPhoneNumber((String) patch.get(key));
				break;
			case "contractWorkOrderNumber":
				s.setContractWorkOrderNumber((String) patch.get(key));
				break;
			case "contractExpirationDate":
				s.setContractExpirationDate((String) patch.get(key));
				break;
			case "ibmLogOnId":
				s.setIbmLogOnId((String) patch.get(key));
				break;
			case "majorGroupCode":
				s.setMajorGroupCode((String) patch.get(key));
				break;
			case "lsoGroupCode":
				s.setLsoGroupCode((String) patch.get(key));
				break;
			case "securityAuthorization":
				s.setSecurityAuthorization((String) patch.get(key));
				break;
			case "tsoAccess":
				s.setTsoAccess((boolean) patch.get(key));
				break;
			case "tsoGroupCode":
				s.setTsoGroupCode((String) patch.get(key));
				break;
			case "binNumber":
				s.setBinNumber((String) patch.get(key));
				break;
			case "subGroup1":
				s.setSubGroup1((String) patch.get(key));
				break;
			case "subGroup2":
				s.setSubGroup2((String) patch.get(key));
				break;
			case "subGroup3":
				s.setSubGroup3((String) patch.get(key));
				break;
			case "onlineAccess":
				s.setOnlineAccess((boolean) patch.get(key));
				break;
			case "systemApplication":
				s.setSystemApplication((String) patch.get(key));
				break;
			case "groupName":
				s.setGroupName((String) patch.get(key));
				break;
			case "oldGroup":
				s.setOldGroup((String) patch.get(key));
				break;
			case "unixAddLogonId":
				s.setUnixAddLogonId((boolean) patch.get(key));
				break;
			case "unixChangeLogonId":
				s.setUnixChangeLogonId((boolean) patch.get(key));
				break;
			case "unixDeleteLogonId":
				s.setUnixDeleteLogonId((boolean) patch.get(key));
				break;
			case "unixLogOnId":
				s.setUnixLogOnId((String) patch.get(key));
				break;
			case "unixApplication":
				s.setUnixApplication((String) patch.get(key));
				break;
			case "unixAccessGroup":
				s.setUnixAccessGroup((String) patch.get(key));
				break;
			case "unixAccountNumber":
				s.setUnixAccountNumber((String) patch.get(key));
				break;
			case "billingAccountNumber":
				s.setBillingAccountNumber((String) patch.get(key));
				break;
			case "securIdVpn":
				s.setSecurIdVpn((boolean) patch.get(key));
				break;
			case "adaptiveAuthenticationVpn":
				s.setAdaptiveAuthenticationVpn((boolean) patch.get(key));
				break;
			case "internetApplication":
				s.setInternetApplication((boolean) patch.get(key));
				break;
			case "exchangeEmail":
				s.setExchangeEmail((boolean) patch.get(key));
				break;
			case "emailEncryption":
				s.setEmailEncryption((boolean) patch.get(key));
				break;
			case "laCountyGovAccess":
				s.setLaCountyGovAccess((boolean) patch.get(key));
				break;
			case "tokenlessAuthentication":
				s.setTokenlessAuthentication((boolean) patch.get(key));
				break;
			case "lacMobileWifiAccess":
				s.setLacMobileWifiAccess((boolean) patch.get(key));
				break;
			case "cherwellSms":
				s.setCherwellSms((boolean) patch.get(key));
				break;
			case "windowsRightsMgmt":
				s.setWindowsRightsMgmt((boolean) patch.get(key));
				break;
			case "gmailAccess":
				s.setGmailAccess((boolean) patch.get(key));
				break;
			case "yahooMailAccess":
				s.setYahooMailAccess((boolean) patch.get(key));
				break;
			case "otherEmailDomain":
				s.setOtherEmailDomain((String) patch.get(key));
				break;
			case "businessJustification":
				s.setBusinessJustification((String) patch.get(key));
				break;
			case "defaultCountyWidePolicy":
				s.setDefaultCountyWidePolicy((boolean) patch.get(key));
				break;
			case "departmentPolicyRule0":
				s.setDepartmentPolicyRule0((boolean) patch.get(key));
				break;
			case "departmentPolicyRule1":
				s.setDepartmentPolicyRule1((boolean) patch.get(key));
				break;
			case "departmentPolicyRule2":
				s.setDepartmentPolicyRule2((boolean) patch.get(key));
				break;
			case "departmentPolicyRule3":
				s.setDepartmentPolicyRule3((boolean) patch.get(key));
				break;
			case "departmentPolicyRule4":
				s.setDepartmentPolicyRule4((boolean) patch.get(key));
				break;
			case "socialNetworkingFacebook":
				s.setSocialNetworkingFacebook((boolean) patch.get(key));
				break;
			case "socialNetworkingTwitter":
				s.setSocialNetworkingTwitter((boolean) patch.get(key));
				break;
			case "socialNetworkingLinkedIn":
				s.setSocialNetworkingLinkedIn((boolean) patch.get(key));
				break;
			default:
				break;

			}

		}

		s = serviceRequestDao.saveServiceRequest(s);
		return s;
	}

	@DeleteMapping("/{requestNumber}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer requestNumber) {
		serviceRequestDao.deleteServiceRequest(requestNumber);
	}
}
