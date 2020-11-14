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

import sbrest.model.Field;
import sbrest.model.Form;
import sbrest.model.dao.FieldDao;

@RestController
@RequestMapping("/fields")
public class FieldsController {

	@Autowired
    private FieldDao fieldDao;

    @GetMapping
    public List<Field> fields(ModelMap models) {
        return fieldDao.getFields();
    }
    
    @GetMapping("/{id}")
    public Field get( @PathVariable Integer id ) {
    	Field f = fieldDao.getField(id);
    	if (f == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
    			"Field not found" );
    	return f;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Field add(@RequestBody Field f) {
    	return fieldDao.saveField(f);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Field f) {
    	
    	Field originalField = fieldDao.getField(id);
    	
    	originalField.setName(f.getName());
    	originalField.setType(f.getType());
    	
    	originalField = fieldDao.saveField(originalField);
    	
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Map<String,Object> patch ) {
    	
    	Field f = fieldDao.getField(id);
    	
    	for (String key : patch.keySet()) {
    		
    		switch(key) {
    		
	    		case "name":
	    			f.setName( (String) patch.get(key));
	    			break;
	    		case "type":
	    			f.setType( (String) patch.get(key));
	    			break; 
    		}
    		
    	}
    	
    	f = fieldDao.saveField(f);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
    	fieldDao.deleteField(id);
    }
    
    
    
}
