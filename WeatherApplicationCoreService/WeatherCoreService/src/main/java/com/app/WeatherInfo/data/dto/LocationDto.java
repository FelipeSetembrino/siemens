package com.app.WeatherInfo.data.dto;

public class LocationDto {

	private Long id;
	private String locationName;
	private Float lat;
	private Float lon;
	
	public LocationDto() {
	}
	
	public LocationDto(Long id, String locationName, Float lat, Float lon) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.lat = lat;
		this.lon = lon;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Float getLat() {
		return lat;
	}
	public void setLat(Float lat) {
		this.lat = lat;
	}
	public Float getLon() {
		return lon;
	}
	public void setLon(Float lon) {
		this.lon = lon;
	}
	
}
