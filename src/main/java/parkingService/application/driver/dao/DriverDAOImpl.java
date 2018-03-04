package parkingService.application.driver.dao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import parkingService.application.entity.Driver;

@Repository
public class DriverDAOImpl implements DriverDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void startParking(Driver driver) {
		Session currentSession = sessionFactory.getCurrentSession();
		driver.setParkingStatus(0);
		driver.setStartParkingDate(LocalDateTime.now());
		currentSession.saveOrUpdate(driver);
	}

	@Override
	public void stopParking(Driver driver) {
		Session currentSession = sessionFactory.getCurrentSession();
		driver.setParkingStatus(1);
		driver.setStopParkingDate(LocalDateTime.now());
		currentSession.saveOrUpdate(driver);
	}

	@Override
	public void differenceTime(int registrationNumber) {
		Session currentSession = sessionFactory.getCurrentSession();
		Driver theDriver = currentSession.get(Driver.class, registrationNumber);
		LocalDateTime tempStartTime = theDriver.getStartParkingDate();
		LocalDateTime tempStopTime = theDriver.getStopParkingDate();
		int timeDifference = (int) tempStartTime.until(tempStopTime, ChronoUnit.HOURS);
		theDriver.setTimeDifference(timeDifference);
	}

}
