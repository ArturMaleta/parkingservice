package parkingService.application.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import parkingService.application.driver.service.DriverService;
import parkingService.application.entity.Driver;

@Controller
@RequestMapping("/parking-service")
public class ParkingController {

	@Autowired
	private DriverService driverService;
	
	@PostMapping("/start-parking")
	public void startParking(Driver driver) {
		driverService.startParking(driver);
	}

	@PostMapping("/stop-parking")
	public void stopParking(Driver driver) {
		driverService.stopParking(driver);
	}

	@GetMapping("/drifference-time")
	public void differenceTime(int registrationNumber) {
		driverService.differenceTime(registrationNumber);
	}

	@GetMapping("/check-driver")
	public boolean checkDriver(int registgrationNumber) {
		driverService.checkDriver(registgrationNumber);
		return true;
	}

	@GetMapping("/payment")
	public void payment(Driver driver) {
		driverService.payment(driver);
	}

	@GetMapping("/days-earnings")
	public void daysEarnings(Date theDate) {
		driverService.daysEarnings(theDate);
	}
}
