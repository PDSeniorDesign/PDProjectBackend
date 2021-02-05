package sbrest.model.dao;

import java.util.List;

import sbrest.model.ServiceRequest;

public interface ServiceRequestDao {
	ServiceRequest getServiceRequest(Integer requestNumber);

    List<ServiceRequest> getServiceRequests();

    ServiceRequest saveServiceRequest(ServiceRequest serviceRequest);
    
    void deleteServiceRequest(Integer requestNumber);
}
