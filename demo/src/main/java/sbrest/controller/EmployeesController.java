package sbrest.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

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

import sbrest.model.Employee;
import sbrest.model.dao.EmployeeDao;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
		@Autowired
	    private EmployeeDao employeeDao;

	    @GetMapping
	    public List<Employee> products(ModelMap models) {
	        return employeeDao.getEmployees();
	    }
	    
	    @GetMapping("/{id}")
	    public Employee get( @PathVariable Integer id ) {
	    	Employee e = employeeDao.getEmployee(id);
	    	if (e == null) throw new ResponseStatusException( HttpStatus.NOT_FOUND, 
	    			"Employee not found" );
	    	return e;
	    }
	    
	    @PostMapping
	    @ResponseStatus(HttpStatus.CREATED)
	    public Employee add(@RequestBody Employee e) {
	    	return employeeDao.saveEmployee(e);
	    }
	    
	    @PutMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void update(@PathVariable Integer id, @RequestBody Employee e) {
	    	Employee originalEmp = employeeDao.getEmployee(id);
	    	
	    	originalEmp.setEmployeeNum(e.getEmployeeNum());
	    	originalEmp.setfName(e.getfName());
	    	originalEmp.setlName(e.getlName());
	    	originalEmp.setMi(e.getMi());
	    	originalEmp.setHostedId(e.getHostedId());
	    	originalEmp.setRegistrationType(e.getRegistrationType());
	    	originalEmp.setDeptNum(e.getDeptNum());
	    	
	    	originalEmp = employeeDao.saveEmployee(originalEmp);
	    }
	    
	    @PatchMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void update(@PathVariable Integer id, @RequestBody Map<String,Object> patch ) {
	    	Employee e = employeeDao.getEmployee(id);
	    	for (String key : patch.keySet()) {
	    		
	    		switch(key) {
		    		case "employeeNum":
		    			e.setEmployeeNum( (Integer) patch.get(key));
		    			break;
		    		case "fName":
		    			e.setfName( (String) patch.get(key) );
		    			break;
		    		case "lName":
		    			e.setlName( (String) patch.get(key));
		    			break;    
		    		case "mi":
		    			e.setMi( (Character) patch.get(key));
		    			break;
		    		case "hostedId":
		    			e.setHostedId( (Integer) patch.get(key) );
		    			break;
		    		case "registrationType":
		    			e.setRegistrationType( (String) patch.get(key));
		    			break; 
		    		case "deptNum":
		    			e.setDeptNum( (Integer) patch.get(key));
		    			break; 
	    		}
	    		
	    	}
	    	e = employeeDao.saveEmployee(e);
	    }
	    
	    @DeleteMapping("/{id}")
	    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void delete(@PathVariable Integer id) {
	        employeeDao.deleteEmployee(id);
	    }
}
