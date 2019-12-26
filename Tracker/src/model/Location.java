package model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue
	@Column(name = "location_id", updatable = false, nullable = false)
	private Long locationId;
	
	@Column(name = "plate")
	private String plate;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "altitude")
	private Double altitude;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private Time time;

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public void setDate(LocalDate date) {
		Date d = java.sql.Date.valueOf(date);
		this.date = d;
	}

	public void setTime(LocalTime time) {
		Time t = java.sql.Time.valueOf(time);
		this.time = t;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Double getLatitude() {
		return this.latitude;
	}
	
	public Double getLongitude() {
		return this.longitude;
	}
	
	public Double getAltitude() {
		return this.altitude;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public Time getTime() {
		return this.time;
	}
	
	public Long getLocationId() {
		return this.locationId;
	}
	
	public String getPlate() {
		return this.plate;
	}
}
