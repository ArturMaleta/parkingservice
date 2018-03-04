package parkingService.application.driver.service;

import java.sql.Date;

import parkingService.application.entity.Driver;

public interface DriverService {

	void startParking(Driver driver);
	
	void stopParking(Driver driver);
	
	void differenceTime(int registrationNumber);
	
	boolean checkDriver(int registgrationNumber);
	
	void payment(Driver driver);
	
	void daysEarnings (Date theDate);
}
