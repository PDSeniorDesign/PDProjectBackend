package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.DivChiefManager;
import sbrest.model.dao.DivChiefManagerDao;

@Repository
public class DivChiefManagerDaoImpl implements DivChiefManagerDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public DivChiefManager getDivChiefManager(Integer id) {
		 return entityManager.find(DivChiefManager.class, id);
	}

	@Override
    public List<DivChiefManager> getDivChiefManagers() {
		return entityManager.createQuery("from DivChiefManager", DivChiefManager.class)
                .getResultList();
    }

    @Override
    @Transactional
    public DivChiefManager saveDivChiefManager(DivChiefManager divChiefManager) {
    	return entityManager.merge(divChiefManager);
    }
    
    @Override
    @Transactional
    public void deleteDivChiefManager(Integer id) {
    	String query = "SELECT d FROM DivChiefManager d WHERE d.id = :id";
    	entityManager.remove(entityManager.createQuery(query, DivChiefManager.class).setParameter("id", id)
    	                .getResultList().get(0));
    }
}
