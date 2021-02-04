package sbrest.controller;

import java.util.List;
import java.util.Map;

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

import sbrest.model.RequestStatus;
import sbrest.model.dao.RequestStatusDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/request_statuses")
public class RequestStatusesController {
	
	@Autowired
    private RequestStatusDao requestStatusDao;
	

    @GetMapping
    public List<RequestStatus> serviceRequests(ModelMap models) {
        return requestStatusDao.getRequestStatuses();
    }


    @GetMapping("/{id}")
    public RequestStatus get( @PathVariable String id ) {
    	RequestStatus s = requestStatusDao.getRequestStatus(id);
    	if (s == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
    			"Service Request not found" );
    	return s;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RequestStatus add(@RequestBody RequestStatus s) {
    	return requestStatusDao.saveRequestStatus(s);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody RequestStatus s) {
    	
    	RequestStatus originalRequestStatus = requestStatusDao.getRequestStatus(id);
    	
    	originalRequestStatus.setRequestStatus(s.getRequestStatus());
    	originalRequestStatus.setLastName(s.getLastName());
    	originalRequestStatus.setFirstName(s.getFirstName());
    	
    	originalRequestStatus = requestStatusDao.saveRequestStatus(originalRequestStatus);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody Map<String,Object> patch ) {
    	
    	RequestStatus s = requestStatusDao.getRequestStatus(id);
    	
    	for (String key : patch.keySet()) {
    		
    		switch(key) {

	    		case "requestStatus":
	    			s.setRequestStatus((String) patch.get(key));
	    			break;
	    		case "lastName":
	    			s.setLastName((String) patch.get(key));
	    			break;
	    		case "firstName":
	    			s.setFirstName((String) patch.get(key));
	    			break;
    		}
    	}
    	s = requestStatusDao.saveRequestStatus(s);
    	
    }
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
    	requestStatusDao.deleteRequestStatus(id);
    }
}
