package parkingService.application.driver.dao;

import parkingService.application.entity.Driver;

public interface DriverDAO {

	void startParking(Driver driver);
	
	void stopParking(Driver driver);
	
	void differenceTime(int registrationNumber);
}
