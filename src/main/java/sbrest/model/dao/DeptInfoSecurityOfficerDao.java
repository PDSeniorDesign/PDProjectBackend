package sbrest.model.dao;

import java.util.List;

import sbrest.model.DeptInfoSecurityOfficer;

public interface DeptInfoSecurityOfficerDao {
	DeptInfoSecurityOfficer getDeptInfoSecurityOfficer(Integer id);

    List<DeptInfoSecurityOfficer> getDeptInfoSecurityOfficers();

    DeptInfoSecurityOfficer saveDeptInfoSecurityOfficer(DeptInfoSecurityOfficer deptInfoSecurityOfficer);
    
    void deleteDeptInfoSecurityOfficer(Integer id);
}
