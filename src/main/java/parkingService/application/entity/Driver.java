package parkingService.application.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="parkingdb")
public class Driver {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="registration_number")
	private int registrationNumber;
	
	// 0 - regular driver; 1 - VIP driver 
	@Column(name="importance")
	private int importance;
	
	// 0 - start parking; 1 - stop parking
	@Column(name="parkings_status")
	private int parkingStatus;
	
	@Column(name="start_parking_date")
	@CreationTimestamp
	private LocalDateTime startParkingDate;
	
	@Column(name="stop_parking_date")
	@UpdateTimestamp
	private LocalDateTime stopParkingDate;
	
	@Column(name="time_difference")
	private int timeDifference;
	
	@Column(name="payment")
	private int payment;
	
	public Driver() {
		
	}

	public Driver(int registrationNumber, int importance, int parkingStatus, int timeDifference) {
		this.registrationNumber = registrationNumber;
		this.importance = importance;
		this.parkingStatus = parkingStatus;
		this.timeDifference = timeDifference;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public int getParkingStatus() {
		return parkingStatus;
	}

	public void setParkingStatus(int parkingStatus) {
		this.parkingStatus = parkingStatus;
	}

	public LocalDateTime getStartParkingDate() {
		return startParkingDate;
	}

	public void setStartParkingDate(LocalDateTime startParkingDate) {
		this.startParkingDate = startParkingDate;
	}

	public LocalDateTime getStopParkingDate() {
		return stopParkingDate;
	}

	public void setStopParkingDate(LocalDateTime stopParkingDate) {
		this.stopParkingDate = stopParkingDate;
	}
	
	public int getTimeDifference() {
		return timeDifference;
	}

	public void setTimeDifference(int timeDifference) {
		this.timeDifference = timeDifference;
	}
	
	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", registrationNumber=" + registrationNumber + ", importance=" + importance
				+ ", parkingStatus=" + parkingStatus + ", startParkingDate=" + startParkingDate + ", stopParkingDate="
				+ stopParkingDate + "]";
	}

}
