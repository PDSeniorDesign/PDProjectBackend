package sbrest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import sbrest.model.Mapping;
import sbrest.model.dao.MappingDao;

@RestController
@RequestMapping("/mappings")
public class MappingsController {
	
	@Autowired
    private MappingDao mappingDao;

    @GetMapping
    public List<Mapping> mappings(ModelMap models) {
        return mappingDao.getMappings();
    }
    
    @GetMapping("/{id}")
    public Mapping get( @PathVariable Integer id ) {
    	Mapping m = mappingDao.getMapping(id);
    	if (m == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
    			"Mapping not found" );
    	return m;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mapping add(@RequestBody Mapping m) {
    	return mappingDao.saveMapping(m);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Mapping m) {
    	
    	Mapping originalMapping = mappingDao.getMapping(id);
    	
    	originalMapping.setRequestFieldName(m.getRequestFieldName());
    	originalMapping.setFormId(m.getFormId());
    	originalMapping.setFieldId(m.getFieldId());
    	
    	originalMapping = mappingDao.saveMapping(originalMapping);
    	
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Map<String,Object> patch ) {
    	
    	Mapping m = mappingDao.getMapping(id);
    	
    	for (String key : patch.keySet()) {
    		
    		switch(key) {
    		
	    		case "requestFieldName":
	    			m.setRequestFieldName( (String) patch.get(key));
	    			break;
	    		case "formId":
	    			m.setFormId( (Integer) patch.get(key));
	    			break;  
	    		case "fieldId":
	    			m.setFieldId( (String) patch.get(key));
	    			break; 
    		}
    		
    	}
    	
    	m = mappingDao.saveMapping(m);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
    	mappingDao.deleteMapping(id);
    }
    
}
