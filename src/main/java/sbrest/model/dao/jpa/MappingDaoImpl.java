package sbrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sbrest.model.Mapping;
import sbrest.model.dao.MappingDao;

@Repository
public class MappingDaoImpl implements MappingDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public Mapping getMapping(Integer id) {
		 return entityManager.find(Mapping.class, id);
	}

	@Override
    public List<Mapping> getMappings() {
		return entityManager.createQuery("from Mapping", Mapping.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Mapping saveMapping(Mapping mapping) {
    	return entityManager.merge(mapping);
    }
    
    @Override
    @Transactional
    public void deleteMapping(Integer id) {
    	String query = "SELECT m FROM Mapping m WHERE m.id = :id";
    	entityManager.remove(entityManager.createQuery(query, Mapping.class).setParameter("id", id)
                .getResultList().get(0));
    }
    
}
