package sbrest.model.dao;

import sbrest.model.Mapping;
import java.util.List;

public interface MappingDao {
	Mapping getMapping(Integer id);

    List<Mapping> getMappings();

    Mapping saveMapping(Mapping mapping);
    
    void deleteMapping(Integer id);
}
