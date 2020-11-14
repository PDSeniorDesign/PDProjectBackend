package sbrest.model.dao;

import java.util.List;

import sbrest.model.Department;

public interface DepartmentDao {

	Department getDepartment(Integer id);

    List<Department> getDepartments();

    Department saveDepartment(Department department);
    
    void deleteDepartment(Integer id);
}