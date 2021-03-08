package sbrest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
// NEEDED?
//		@GetMapping
//	    public List<Admin> Admin(ModelMap models) {
//	        return adminDao.getAdmins();
//	    }
	
}