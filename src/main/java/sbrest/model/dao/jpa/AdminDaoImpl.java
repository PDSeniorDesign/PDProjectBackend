package sbrest.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.Admin;
import sbrest.model.dao.AdminDao;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	@Transactional
	public Admin getAdmin() {
		return (Admin) entityManager.createQuery("from Admin").getResultList().get(0);
	}

	//TO SAVE CHANGES TO PASSWORD
	@Override
    @Transactional
    public Admin saveAdmin(Admin admin) {
    	return entityManager.merge(admin);
    }

	
	
	
	
	
//WHICH getAdmin() METHOD TO USE?
//	@Override
//	public Admin getAdmin(String password) {
//		 return entityManager.find(Admin.class, password);
//	}
}
