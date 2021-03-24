package sbrest.model.dao;

import java.util.List;

import sbrest.model.DepartmentHead;

public interface DepartmentHeadDao {
	DepartmentHead getDepartmentHead(Integer id);

    List<DepartmentHead> getDepartmentHeads();

    DepartmentHead saveDepartmentHead(DepartmentHead departmentHead);
    
    void deleteDepartmentHead(Integer id);
}
