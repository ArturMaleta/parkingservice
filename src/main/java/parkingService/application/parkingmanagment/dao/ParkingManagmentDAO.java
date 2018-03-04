package parkingService.application.parkingmanagment.dao;

import java.sql.Date;

import parkingService.application.entity.Driver;

public interface ParkingManagmentDAO {

	boolean checkDriver(int registgrationNumber);
	
	void payment(Driver driver);
	
	void daysEarnings (Date theDate);
}
