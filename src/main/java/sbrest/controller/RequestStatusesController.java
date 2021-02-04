package sbrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbrest.model.ServiceRequest;
import sbrest.model.dao.ServiceRequestDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/request_statuses")
public class RequestStatusesController {


    @Autowired
    private ServiceRequestDao serviceRequestDao;

    @GetMapping("/{id}")
    public RequestStatusResponse getRequestStatusById(@PathVariable Integer id) {
        // TODO: Handle null pointers (when getServiceReqeust returns null)
        ServiceRequest serviceRequest = serviceRequestDao.getServiceRequest(id);
        RequestStatusResponse res = new RequestStatusResponse(serviceRequest.getRequestStatus());
        return res;
    }

}

// A representation of what the server will return
class RequestStatusResponse {
    private String requestStatus;

    public RequestStatusResponse(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}