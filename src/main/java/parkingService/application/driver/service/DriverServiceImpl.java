package parkingService.application.driver.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import parkingService.application.driver.dao.DriverDAO;
import parkingService.application.entity.Driver;
import parkingService.application.parkingmanagment.dao.ParkingManagmentDAO;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDAO driverDAO;
	
	@Autowired
	private ParkingManagmentDAO parkingmanagmentDAO;
	
	@Override
	@Transactional
	public void startParking(Driver driver) {
		driverDAO.startParking(driver);
	}

	@Override
	@Transactional
	public void stopParking(Driver driver) {
		driverDAO.stopParking(driver);
	}

	@Override
	@Transactional
	public void differenceTime(int registrationNumber) {
		driverDAO.differenceTime(registrationNumber);
	}

	@Override
	@Transactional
	public boolean checkDriver(int registgrationNumber) {
		parkingmanagmentDAO.checkDriver(registgrationNumber);
		return true;
	}

	@Override
	@Transactional
	public void payment(Driver driver) {
		parkingmanagmentDAO.payment(driver);
	}

	@Override
	@Transactional
	public void daysEarnings(Date theDate) {
		parkingmanagmentDAO.daysEarnings(theDate);
	}

}
