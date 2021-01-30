package sbrest.model.dao;

import java.util.List;

import sbrest.model.ServiceRequest;

public interface ServiceRequestDao {
	ServiceRequest getServiceRequest(String id);

    List<ServiceRequest> getServiceRequests();

    ServiceRequest saveServiceRequest(ServiceRequest serviceRequest);
    
    void deleteServiceRequest(String id);
}
