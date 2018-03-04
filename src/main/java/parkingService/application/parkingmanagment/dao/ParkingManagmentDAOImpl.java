package parkingService.application.parkingmanagment.dao;

import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import parkingService.application.entity.Driver;

@Repository
public class ParkingManagmentDAOImpl implements ParkingManagmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean checkDriver(int registrationNumber) {
		Session currentSession = sessionFactory.getCurrentSession();
		Driver theDriver = currentSession.get(Driver.class, registrationNumber);
					
		return true;
	}

	@Override
	public void payment(Driver driver) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		int timeToPay = driver.getTimeDifference();
		
		long finalPayment = 0;
		
		if (driver.getImportance() == 0) {
			long lastNotDoubledHourCost = 2;
			long hourCost = 0;
			for(int i = 1; i <= timeToPay; i++) {
				if(i == 1) {
					hourCost = 1;
				} else if (i == 2) {
					hourCost = 3; 
				} else if(i >= 3) {
					lastNotDoubledHourCost *= 2;
					hourCost = lastNotDoubledHourCost;
				}
			}
			finalPayment = hourCost;
		} else if (driver.getImportance() == 1) {
			long lastNotDoubledHourCost = 2;
			long hourCost = 0;
			for(int i = 1; i <= timeToPay; i++) {
				if(i == 1) {
					hourCost = 0;
				} else if(i == 2) { 
					hourCost = 2;
				} else if(i >= 3) {
					lastNotDoubledHourCost *= 1.5;
					hourCost = lastNotDoubledHourCost;
				}
			}
			finalPayment = hourCost;
		}
		driver.setPayment((int)finalPayment);
	}

	@Override
	public void daysEarnings(Date theDate) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("SELECT SUM(payment) as payment FROM parkingdb WHERE date = CURDATE()");
		System.out.println(theQuery.list());
	}

}
