package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.RequestStatus;
import sbrest.model.dao.RequestStatusDao;

@Repository
public class RequestStatusDaoImpl implements RequestStatusDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public RequestStatus getRequestStatus(String id) {
		 return entityManager.find(RequestStatus.class, id);
	}

	@Override
    public List<RequestStatus> getRequestStatuses() {
		return entityManager.createQuery("from RequestStatus", RequestStatus.class)
                .getResultList();
    }

    @Override
    @Transactional
    public RequestStatus saveRequestStatus(RequestStatus requestStatus) {
    	return entityManager.merge(requestStatus);
    }
    
    @Override
    @Transactional
    public void deleteRequestStatus(String id) {
    	String query = "SELECT s FROM RequestStatus s WHERE s.id = :id";
    	entityManager.remove(entityManager.createQuery(query, RequestStatus.class).setParameter("id", id)
                .getResultList().get(0));
    }
}
