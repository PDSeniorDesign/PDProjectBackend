package sbrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sbrest.model.Admin;
import sbrest.model.ApplicationCoordinator;
import sbrest.model.DepartmentHead;
import sbrest.model.DeptInfoSecurityOfficer;
import sbrest.model.DivChiefManager;
import sbrest.model.Field;
import sbrest.model.Form;
import sbrest.model.ServiceRequest;
import sbrest.model.RequestStatusResponse;
import sbrest.model.dao.AdminDao;
import sbrest.model.dao.ApplicationCoordinatorDao;
import sbrest.model.dao.DepartmentHeadDao;
import sbrest.model.dao.DeptInfoSecurityOfficerDao;
import sbrest.model.dao.DivChiefManagerDao;
import sbrest.model.dao.FormDao;
import sbrest.model.dao.ServiceRequestDao;
import sbrest.signapi.AgreementEvents;
import sbrest.signapi.Agreements;

@RestController
@RequestMapping("/admin")
public class AdminController {
//These functions are for the admin user
		
	@Autowired
    private AdminDao adminDao;
	
	@Autowired
	private ServiceRequestDao serviceRequestDao;
	
	//Gets some details of all specified Service Request if user is admin
	@CrossOrigin(origins= "*")
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
	@CrossOrigin(origins= "*")
	@GetMapping("/service_requests/{requestNumber}")
	public ServiceRequest get(@RequestHeader("password") String password, @PathVariable Integer requestNumber) throws Exception {
		ServiceRequest s = serviceRequestDao.getServiceRequest(requestNumber);

		// get password from user input and database, then compare
		//If password matches one in database return request status, else 403 error forbidden
		String dbPassword = adminDao.getAdmin().getPassword();

		if (dbPassword.equals(password)) {
			if (s == null)
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Request not found");
			
			s = AgreementEvents.updateRequestStatus(s);
			serviceRequestDao.saveServiceRequest(s);
			
			return s;
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		}
	}
	
	//Admin user can change the password
	@CrossOrigin(origins= "*")
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
	@CrossOrigin(origins= "*")
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
				case "complete":
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
				case "isSubmitted":
					s.setSubmitted((boolean) patch.get(key));
					break;
				case "managerFirstName":
					s.setManagerFirstName((String) patch.get(key));
					break;
				case "managerLastName":
					s.setManagerLastName((String) patch.get(key));
					break;
				case "managerPhone":
					s.setManagerPhone((String) patch.get(key));
					break;
				case "managerTitle":
					s.setManagerTitle((String) patch.get(key));
					break;
				case "managerEmail":
					s.setManagerEmail((String) patch.get(key));
					break;
				case "divChiefManagerName":
					s.setDivChiefManagerName((String) patch.get(key));
					break;
				case "divChiefManagerPhone":
					s.setDivChiefManagerPhone((String) patch.get(key));
					break;
				case "divChiefManagerEmail":
					s.setDivChiefManagerEmail((String) patch.get(key));
					break;
				case "departmentHeadName":
					s.setDepartmentHeadName((String) patch.get(key));
					break;
				case "departmentHeadPhone":
					s.setDepartmentHeadPhone((String) patch.get(key));
					break;
				case "departmentHeadEmail":
					s.setDepartmentHeadEmail((String) patch.get(key));
					break;
				case "deptInfoSecurityOfficerName":
					s.setDeptInfoSecurityOfficerName((String) patch.get(key));
					break;
				case "deptInfoSecurityOfficerPhone":
					s.setDeptInfoSecurityOfficerPhone((String) patch.get(key));
					break;
				case "deptInfoSecurityOfficerEmail":
					s.setDeptInfoSecurityOfficerEmail((String) patch.get(key));
					break;
				case "applicationCoordinatorName":
					s.setApplicationCoordinatorName((String) patch.get(key));
					break;
				case "applicationCoordinatorPhone":
					s.setApplicationCoordinatorPhone((String) patch.get(key));
					break;
				case "applicationCoordinatorEmail":
					s.setApplicationCoordinatorEmail((String) patch.get(key));
					break;
				default:
					break;

				}
			}

			if (patch.keySet().contains("isComplete") || patch.keySet().contains("complete")) {
				checkCompleteness(s);	
			}
			
			s = serviceRequestDao.saveServiceRequest(s);
			return s;
			
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		}
	}
	
	
	
	public void checkCompleteness(ServiceRequest s) throws Exception {
		if (s.isComplete()) {
			s.setAgreementId(Agreements.sendAgreement(s));
			// 5 second timeout - account for time for Adobe to send first email
			TimeUnit.SECONDS.sleep(5);
			s = AgreementEvents.updateRequestStatus(s);
		}
	}

	// New Admin Endpoints for participant info.
	// Password-protected endpoints.
	@Autowired
    private DivChiefManagerDao divChiefManagerDao;
	
	@CrossOrigin(origins= "*")
    @GetMapping("/div_chief_managers")
    public List<DivChiefManager> divChiefManagers(@RequestHeader("password") String password, ModelMap models) throws Exception {
    	
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return divChiefManagerDao.getDivChiefManagers();
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
    }
    
	@CrossOrigin(origins= "*")
    @GetMapping("/div_chief_managers/{id}")
    public DivChiefManager divChiefManager(@RequestHeader("password") String password, @PathVariable Integer id ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			DivChiefManager d = divChiefManagerDao.getDivChiefManager(id);
	    	if (d == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
	    			"Division Chief / Manager not found" );
	    	return d;
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
    
	@CrossOrigin(origins= "*")
    @PostMapping("/div_chief_managers")
    @ResponseStatus(HttpStatus.CREATED)
    public DivChiefManager addDivChiefManager(@RequestHeader("password") String password, @RequestBody DivChiefManager d) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return divChiefManagerDao.saveDivChiefManager(d);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    }
    
	@CrossOrigin(origins= "*")
    @PatchMapping("/div_chief_managers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public DivChiefManager updateDivChiefManager(@RequestHeader("password") String password, @PathVariable Integer id, @RequestBody Map<String,Object> patch ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	

			DivChiefManager d = divChiefManagerDao.getDivChiefManager(id);
	    	
	    	for (String key : patch.keySet()) {
	    		
	    		switch(key) {
	    		
		    		case "name":
		    			d.setName( (String) patch.get(key));
		    			break;
		    		case "phone":
		    			d.setPhone( (String) patch.get(key));
		    			break;    
		    		case "email":
		    			d.setEmail( (String) patch.get(key));
		    		default:
		    			break;
	    		}
	    		
	    	}
	    	
	    	d = divChiefManagerDao.saveDivChiefManager(d);
	    	return d;

		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
   
    }
    
	@CrossOrigin(origins= "*")
    @DeleteMapping("/div_chief_managers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDivChiefManager(@RequestHeader("password") String password, @PathVariable Integer id) {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			divChiefManagerDao.deleteDivChiefManager(id);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
    
    @Autowired
    private DepartmentHeadDao departmentHeadDao;

    @CrossOrigin(origins= "*")
    @GetMapping("/department_heads")
    public List<DepartmentHead> departmentHeads(@RequestHeader("password") String password, ModelMap models) throws Exception {
    	
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return departmentHeadDao.getDepartmentHeads();
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
    }
    
    @CrossOrigin(origins= "*")
    @GetMapping("/department_heads/{id}")
    public DepartmentHead departmentHead(@RequestHeader("password") String password, @PathVariable Integer id ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			DepartmentHead d = departmentHeadDao.getDepartmentHead(id);
	    	if (d == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
	    			"Department Head not found" );
	    	return d;
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
    
    @CrossOrigin(origins= "*")
    @PostMapping("/department_heads")
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentHead addDepartmentHead(@RequestHeader("password") String password, @RequestBody DepartmentHead d) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return departmentHeadDao.saveDepartmentHead(d);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    }
    
    @CrossOrigin(origins= "*")
    @PatchMapping("/department_heads/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public DepartmentHead updateDepartmentHead(@RequestHeader("password") String password, @PathVariable Integer id, @RequestBody Map<String,Object> patch ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	

			DepartmentHead d = departmentHeadDao.getDepartmentHead(id);
	    	
	    	for (String key : patch.keySet()) {
	    		
	    		switch(key) {
	    		
		    		case "name":
		    			d.setName( (String) patch.get(key));
		    			break;
		    		case "phone":
		    			d.setPhone( (String) patch.get(key));
		    			break;    
		    		case "email":
		    			d.setEmail( (String) patch.get(key));
		    		default:
		    			break;
	    		}
	    		
	    	}
	    	
	    	d = departmentHeadDao.saveDepartmentHead(d);
	    	return d;

		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
   
    }
    
    @CrossOrigin(origins= "*")
    @DeleteMapping("/department_heads/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartmentHead(@RequestHeader("password") String password, @PathVariable Integer id) {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			departmentHeadDao.deleteDepartmentHead(id);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
    
    @Autowired
    private ApplicationCoordinatorDao applicationCoordinatorDao;

    @GetMapping("/application_coordinators")
    public List<ApplicationCoordinator> applicationCoordinators(@RequestHeader("password") String password, ModelMap models) throws Exception {
    	
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return applicationCoordinatorDao.getApplicationCoordinators();
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
    }
    
    @GetMapping("/application_coordinators/{id}")
    public ApplicationCoordinator applicationCoordinator(@RequestHeader("password") String password, @PathVariable Integer id ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			ApplicationCoordinator a = applicationCoordinatorDao.getApplicationCoordinator(id);
	    	if (a == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
	    			"Application Coordinator not found" );
	    	return a;
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
    
    @PostMapping("/application_coordinators")
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationCoordinator addApplicationCoordinator(@RequestHeader("password") String password, @RequestBody ApplicationCoordinator a) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return applicationCoordinatorDao.saveApplicationCoordinator(a);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    }
    
    @PatchMapping("/application_coordinators/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ApplicationCoordinator updateApplicationCoordinator(@RequestHeader("password") String password, @PathVariable Integer id, @RequestBody Map<String,Object> patch ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	

			ApplicationCoordinator a = applicationCoordinatorDao.getApplicationCoordinator(id);
	    	
	    	for (String key : patch.keySet()) {
	    		
	    		switch(key) {
	    		
		    		case "name":
		    			a.setName( (String) patch.get(key));
		    			break;
		    		case "phone":
		    			a.setPhone( (String) patch.get(key));
		    			break;    
		    		case "email":
		    			a.setEmail( (String) patch.get(key));
		    		default:
		    			break;
	    		}
	    		
	    	}
	    	
	    	a = applicationCoordinatorDao.saveApplicationCoordinator(a);
	    	return a;

		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
   
    }
    
    @DeleteMapping("/application_coordinators/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApplicationCoordinator(@RequestHeader("password") String password, @PathVariable Integer id) {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			applicationCoordinatorDao.deleteApplicationCoordinator(id);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
    
    @Autowired
    private DeptInfoSecurityOfficerDao deptInfoSecurityOfficerDao;

    @GetMapping("/dept_info_security_officers")
    public List<DeptInfoSecurityOfficer> deptInfoSecurityOfficers(@RequestHeader("password") String password, ModelMap models) throws Exception {
    	
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return deptInfoSecurityOfficerDao.getDeptInfoSecurityOfficers();
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
    }
    
    @GetMapping("/dept_info_security_officers/{id}")
    public DeptInfoSecurityOfficer deptInfoSecurityOfficer(@RequestHeader("password") String password, @PathVariable Integer id ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			DeptInfoSecurityOfficer d = deptInfoSecurityOfficerDao.getDeptInfoSecurityOfficer(id);
	    	if (d == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
	    			"Department Info Security Officer not found" );
	    	return d;
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
    
    @PostMapping("/dept_info_security_officers")
    @ResponseStatus(HttpStatus.CREATED)
    public DeptInfoSecurityOfficer addDeptInfoSecurityOfficer(@RequestHeader("password") String password, @RequestBody DeptInfoSecurityOfficer d) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			return deptInfoSecurityOfficerDao.saveDeptInfoSecurityOfficer(d);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    }
    
    @PatchMapping("/dept_info_security_officers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public DeptInfoSecurityOfficer updateDeptInfoSecurityOfficer(@RequestHeader("password") String password, @PathVariable Integer id, @RequestBody Map<String,Object> patch ) throws Exception {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	

			DeptInfoSecurityOfficer d = deptInfoSecurityOfficerDao.getDeptInfoSecurityOfficer(id);
	    	
	    	for (String key : patch.keySet()) {
	    		
	    		switch(key) {
	    		
		    		case "name":
		    			d.setName( (String) patch.get(key));
		    			break;
		    		case "phone":
		    			d.setPhone( (String) patch.get(key));
		    			break;    
		    		case "email":
		    			d.setEmail( (String) patch.get(key));
		    		default:
		    			break;
	    		}
	    		
	    	}
	    	
	    	d = deptInfoSecurityOfficerDao.saveDeptInfoSecurityOfficer(d);
	    	return d;

		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
		
   
    }
    
    @DeleteMapping("/dept_info_security_officers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeptInfoSecurityOfficer(@RequestHeader("password") String password, @PathVariable Integer id) {
    	String dbPassword = adminDao.getAdmin().getPassword();
		if (dbPassword.equals(password)) {	
			deptInfoSecurityOfficerDao.deleteDeptInfoSecurityOfficer(id);
		} else
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"User does not have authorization to view this page");
    
    }
	
}