package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.ApplicationCoordinator;
import sbrest.model.dao.ApplicationCoordinatorDao;

@Repository
public class ApplicationCoordinatorDaoImpl implements ApplicationCoordinatorDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public ApplicationCoordinator getApplicationCoordinator(Integer id) {
		 return entityManager.find(ApplicationCoordinator.class, id);
	}

	@Override
    public List<ApplicationCoordinator> getApplicationCoordinators() {
		return entityManager.createQuery("from ApplicationCoordinator", ApplicationCoordinator.class)
                .getResultList();
    }

    @Override
    @Transactional
    public ApplicationCoordinator saveApplicationCoordinator(ApplicationCoordinator applicationCoordinator) {
    	return entityManager.merge(applicationCoordinator);
    }
    
    @Override
    @Transactional
    public void deleteApplicationCoordinator(Integer id) {
    	String query = "SELECT a FROM ApplicationCoordinator a WHERE a.id = :id";
    	entityManager.remove(entityManager.createQuery(query, ApplicationCoordinator.class).setParameter("id", id)
    	                .getResultList().get(0));
    }
}
