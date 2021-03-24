package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.DepartmentHead;
import sbrest.model.dao.DepartmentHeadDao;

@Repository
public class DepartmentHeadDaoImpl implements DepartmentHeadDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public DepartmentHead getDepartmentHead(Integer id) {
		 return entityManager.find(DepartmentHead.class, id);
	}

	@Override
    public List<DepartmentHead> getDepartmentHeads() {
		return entityManager.createQuery("from DepartmentHead", DepartmentHead.class)
                .getResultList();
    }

    @Override
    @Transactional
    public DepartmentHead saveDepartmentHead(DepartmentHead departmentHead) {
    	return entityManager.merge(departmentHead);
    }
    
    @Override
    @Transactional
    public void deleteDepartmentHead(Integer id) {
    	String query = "SELECT d FROM DepartmentHead d WHERE d.id = :id";
    	entityManager.remove(entityManager.createQuery(query, DepartmentHead.class).setParameter("id", id)
    	                .getResultList().get(0));
    }
}
