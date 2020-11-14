package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.ServiceRequest;
import sbrest.model.dao.ServiceRequestDao;

@Repository
public class ServiceRequestDaoImpl implements ServiceRequestDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public ServiceRequest getServiceRequest(Integer id) {
		 return entityManager.find(ServiceRequest.class, id);
	}

	@Override
    public List<ServiceRequest> getServiceRequests() {
		return entityManager.createQuery("from ServiceRequest", ServiceRequest.class)
                .getResultList();
    }

    @Override
    @Transactional
    public ServiceRequest saveServiceRequest(ServiceRequest serviceRequest) {
    	return entityManager.merge(serviceRequest);
    }
    
    @Override
    @Transactional
    public void deleteServiceRequest(Integer id) {
    	entityManager.remove(entityManager.createQuery("SELECT s FROM ServiceRequest s WHERE s.id = " + id, ServiceRequest.class)
                .getResultList().get(0));
    }
}
