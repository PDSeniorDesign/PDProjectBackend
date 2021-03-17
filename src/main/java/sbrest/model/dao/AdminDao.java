package sbrest.model.dao;

import sbrest.model.Admin;

public interface AdminDao {
	Admin getAdmin();

    Admin saveAdmin(Admin admin);
    
//	Admin getAdmin(String password);
}
