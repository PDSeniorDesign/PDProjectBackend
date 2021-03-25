package sbrest.model.dao;

import java.util.List;

import sbrest.model.DivChiefManager;

public interface DivChiefManagerDao {
	DivChiefManager getDivChiefManager(Integer id);

    List<DivChiefManager> getDivChiefManagers();

    DivChiefManager saveDivChiefManager(DivChiefManager divChiefManager);
    
    void deleteDivChiefManager(Integer id);
}
