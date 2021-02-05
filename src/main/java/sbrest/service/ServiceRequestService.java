package sbrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sbrest.model.ServiceRequest;
import sbrest.model.dao.ServiceRequestDao;

@Service
public class ServiceRequestService {

	@Autowired
	ServiceRequestDao serviceRequestDao;

	/**
	 * 
	 * @param requestNumber This is the 6 digit code
	 * @return Will return true if the request number is already used. A Service
	 *         Request using this request number already exists.
	 */
	public boolean existsByRequestNumber(Integer requestNumber) {
		ServiceRequest serviceRequest = serviceRequestDao.getServiceRequest(requestNumber);
		if (serviceRequest != null) {
			return true;
		}
		return false;
	}
}
