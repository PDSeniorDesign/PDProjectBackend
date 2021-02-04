package sbrest.model.dao;

import java.util.List;

import sbrest.model.RequestStatus;

public interface RequestStatusDao {
	RequestStatus getRequestStatus(String id);

    List<RequestStatus> getRequestStatuses();

    RequestStatus saveRequestStatus(RequestStatus requestStatus);
    
    void deleteRequestStatus(String id);
}
