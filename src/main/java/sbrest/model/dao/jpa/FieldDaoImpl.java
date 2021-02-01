package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.Field;
import sbrest.model.dao.FieldDao;

@Repository
public class FieldDaoImpl implements FieldDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Field getField(Integer id) {
		 return entityManager.find(Field.class, id);
	}

	@Override
    public List<Field> getFields() {
		return entityManager.createQuery("from Field", Field.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Field saveField(Field field) {
    	return entityManager.merge(field);
    }
    
    @Override
    @Transactional
    public void deleteField(Integer id) {
    	String query = "SELECT f FROM Field f WHERE f.id = :id";
    	entityManager.remove(entityManager.createQuery(query, Field.class).setParameter("id", id)
    	                .getResultList().get(0));
    }
    
}