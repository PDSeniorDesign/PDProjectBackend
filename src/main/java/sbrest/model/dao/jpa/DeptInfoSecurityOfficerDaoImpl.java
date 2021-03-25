package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.DeptInfoSecurityOfficer;
import sbrest.model.dao.DeptInfoSecurityOfficerDao;

@Repository
public class DeptInfoSecurityOfficerDaoImpl implements DeptInfoSecurityOfficerDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public DeptInfoSecurityOfficer getDeptInfoSecurityOfficer(Integer id) {
		 return entityManager.find(DeptInfoSecurityOfficer.class, id);
	}

	@Override
    public List<DeptInfoSecurityOfficer> getDeptInfoSecurityOfficers() {
		return entityManager.createQuery("from DeptInfoSecurityOfficer", DeptInfoSecurityOfficer.class)
                .getResultList();
    }

    @Override
    @Transactional
    public DeptInfoSecurityOfficer saveDeptInfoSecurityOfficer(DeptInfoSecurityOfficer deptInfoSecurityOfficer) {
    	return entityManager.merge(deptInfoSecurityOfficer);
    }
    
    @Override
    @Transactional
    public void deleteDeptInfoSecurityOfficer(Integer id) {
    	String query = "SELECT d FROM DeptInfoSecurityOfficer d WHERE d.id = :id";
    	entityManager.remove(entityManager.createQuery(query, DeptInfoSecurityOfficer.class).setParameter("id", id)
    	                .getResultList().get(0));
    }
}
