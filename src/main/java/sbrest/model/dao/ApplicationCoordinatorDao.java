package sbrest.model.dao;

import java.util.List;

import sbrest.model.ApplicationCoordinator;

public interface ApplicationCoordinatorDao {
	ApplicationCoordinator getApplicationCoordinator(Integer id);

    List<ApplicationCoordinator> getApplicationCoordinators();

    ApplicationCoordinator saveApplicationCoordinator(ApplicationCoordinator applicationCoordinator);
    
    void deleteApplicationCoordinator(Integer id);
}
