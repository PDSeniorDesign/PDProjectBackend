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

import sbrest.model.Department;
import sbrest.model.dao.DepartmentDao;


@RestController
@RequestMapping("/departments")
public class DepartmentsControllers {
	@Autowired
    private DepartmentDao departmentDao;

    @GetMapping
    public List<Department> departments(ModelMap models) {
        return departmentDao.getDepartments();
    }
    
    @GetMapping("/{id}")
    public Department get( @PathVariable Integer id ) {
    	Department d = departmentDao.getDepartment(id);
    	if (d == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
    			"Department not found" );
    	return d;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department add(@RequestBody Department d) {
    	return departmentDao.saveDepartment(d);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Department d) {
    	Department originalDept = departmentDao.getDepartment(id);
    	
    	originalDept.setDeptNum(d.getDeptNum());
    	originalDept.setDeptName(d.getDeptName());
    	originalDept.setDeptEmail(d.getDeptEmail());
    	originalDept.setBusinessStreetAddress(d.getBusinessStreetAddress());
    	originalDept.setCity(d.getCity());
    	originalDept.setZip(d.getZip());
    	originalDept.setPhoneNum(d.getPhoneNum());
    	
    	originalDept = departmentDao.saveDepartment(originalDept);
    }
    
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Map<String,Object> patch ) {
    	Department d = departmentDao.getDepartment(id);
    	for (String key : patch.keySet()) {
    		
    		switch(key) {
	    		case "deptNum":
	    			d.setDeptNum( (Integer) patch.get(key));
	    			break;
	    		case "deptName":
	    			d.setDeptName( (String) patch.get(key) );
	    			break;
	    		case "deptEmail":
	    			d.setDeptEmail( (String) patch.get(key));
	    			break;    
	    		case "businessStreetAddress":
	    			d.setBusinessStreetAddress( (String) patch.get(key));
	    			break;
	    		case "city":
	    			d.setCity( (String) patch.get(key) );
	    			break;
	    		case "zip":
	    			d.setZip((String) patch.get(key));
	    			break; 
	    		case "phoneNum":
	    			d.setPhoneNum((String) patch.get(key));
	    			break; 
    		}
    		
    	}
    	d = departmentDao.saveDepartment(d);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
    	departmentDao.deleteDepartment(id);
    }
}
