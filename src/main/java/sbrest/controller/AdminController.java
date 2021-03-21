package sbrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sbrest.model.Admin;
import sbrest.model.ServiceRequest;
import sbrest.model.RequestStatusResponse;
import sbrest.model.dao.AdminDao;
import sbrest.model.dao.ServiceRequestDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
//These functions are for the admin user
	
	@Autowired
    private AdminDao adminDao;
	
	@Autowired
	private ServiceRequestDao serviceRequestDao;
	
	//Gets some details of all specified Service Request if user is admin
	@GetMapping("/service_requests")
	public List<RequestStatusResponse> getRequestStatusByRequestNumber(@RequestHeader("password") String password) {		
		List<ServiceRequest> serviceRequests = serviceRequestDao.getServiceRequests();
		
		List<RequestStatusResponse> requestStatusResponses = new ArrayList<RequestStatusResponse>();

		// get password from user input and database, then compare
		//If password matches one in database return request status, else 403 error forbidden
		String dbPassword = adminDao.getAdmin().getPassword();

		if (dbPassword.equals(password)) {
			if (serviceRequests != null) {				
				// pointer
				for(ServiceRequest s : serviceRequests) {
					RequestStatusResponse r = new RequestStatusResponse(s.getRequestNumber(),
							s.getRequestStatus(), s.getFirstName(), s.getLastName());
					requestStatusResponses.add(r);
				}
				return requestStatusResponses;
			} else
				////TODO: Null pointer exception if no service requests 
				return null;
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
	}	
	
	//Gets all details of a specified Service Request if user is admin
	@GetMapping("/service_requests/{requestNumber}")
	public ServiceRequest get(@RequestHeader("password") String password, @PathVariable Integer requestNumber) {
		ServiceRequest s = serviceRequestDao.getServiceRequest(requestNumber);

		// get password from user input and database, then compare
		//If password matches one in database return request status, else 403 error forbidden
		String dbPassword = adminDao.getAdmin().getPassword();

		if (dbPassword.equals(password)) {
			if (s == null)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Request not found");
			return s;
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		}
	}
	
	//Admin user can change the password
	@PatchMapping("/reset_password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestHeader("password") String oldPassword, @RequestHeader("new-password") String newPassword) {
		
		// get password from database, then compare to user input
		//If password matches one in database return request status, else 403 error forbidden
		String dbPassword = adminDao.getAdmin().getPassword(); //database
		
		if (dbPassword.equals(oldPassword)) {
			Admin originalAdmin = adminDao.getAdmin();
			originalAdmin.setPassword(newPassword);
			originalAdmin = adminDao.saveAdmin(originalAdmin);	
		}else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		}
	}
	
	//Admin user can review a submitted request and edit field values
	@PatchMapping("/service_requests/{requestNumber}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ServiceRequest update(@RequestHeader("password") String password, @PathVariable Integer requestNumber, @RequestBody Map<String, Object> patch) throws Exception {
		
		ServiceRequest s = null;
		if (serviceRequestDao.getServiceRequest(requestNumber) == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Request not found");
		else
			s = serviceRequestDao.getServiceRequest(requestNumber);
		 
		
		// get password from user input and database, then compare
		// If password matches one in the database, the admin user
		//can edit field values, else 403 error forbidden
		String dbPassword = adminDao.getAdmin().getPassword();

		if (dbPassword.equals(password)) {			
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
					
					//not yet implemented in admin backend- checkCompletemness
				case "isComplete":
					s.setComplete((boolean) patch.get(key));
					//checkCompleteness(s);
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
			
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		}
	}
	
	
	
	
	
	
	
// NEEDED?
//		@GetMapping
//	    public List<Admin> Admin(ModelMap models) {
//	        return adminDao.getAdmins();
//	    }
	
}