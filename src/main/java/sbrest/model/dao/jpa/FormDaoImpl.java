package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.Form;
import sbrest.model.dao.FormDao;

@Repository
public class FormDaoImpl implements FormDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Form getForm(Integer id) {
		 return entityManager.find(Form.class, id);
	}

	@Override
    public List<Form> getForms() {
		return entityManager.createQuery("from Form", Form.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Form saveForm(Form form) {
    	return entityManager.merge(form);
    }
    
    @Override
    @Transactional
    public void deleteForm(Integer id) {
    	String query = "SELECT f FROM Form f WHERE f.id = :id";
    	entityManager.remove(entityManager.createQuery(query, Form.class).setParameter("id", id)
                .getResultList().get(0));
    }
    
}
