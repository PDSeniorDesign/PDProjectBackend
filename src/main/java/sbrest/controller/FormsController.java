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
import sbrest.model.dao.FormDao;

@RestController
@RequestMapping("/forms")
public class FormsController {

	@Autowired
    private FormDao formDao;

    @GetMapping
    public List<Form> forms(ModelMap models) {
        return formDao.getForms();
    }
    
    @GetMapping("/{id}")
    public Form get( @PathVariable Integer id ) {
    	Form f = formDao.getForm(id);
    	if (f == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
    			"Form not found" );
    	return f;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Form add(@RequestBody Form f) {
    	return formDao.saveForm(f);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Form f) {
    	
    	Form originalForm = formDao.getForm(id);
    	
    	originalForm.setName(f.getName());
    	originalForm.setFields(f.getFields());
    	
    	originalForm = formDao.saveForm(originalForm);
    	
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Map<String,Object> patch ) {
    	
    	Form f = formDao.getForm(id);
    	
    	for (String key : patch.keySet()) {
    		
    		switch(key) {
    		
	    		case "name":
	    			f.setName( (String) patch.get(key));
	    			break;
	    		case "fields":
	    			f.setFields( (List<Field>) patch.get(key));
	    			break;    
    		}
    		
    	}
    	
    	f = formDao.saveForm(f);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
    	formDao.deleteForm(id);
    }
    
	
}
