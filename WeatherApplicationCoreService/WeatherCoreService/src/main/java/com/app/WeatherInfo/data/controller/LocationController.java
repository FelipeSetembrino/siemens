package com.app.WeatherInfo.data.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.WeatherInfo.data.dto.LocationDto;
import com.app.WeatherInfo.data.model.Location;
import com.app.WeatherInfo.data.repository.LocationRepository;

@RestController
@RequestMapping("/api/location")
public class LocationController {
	
	@Autowired 
	LocationRepository locationRepo;
	
	@GetMapping("/getLocationInfoByName")
	public LocationDto getLocation(@Param("name") String locationName) {
		Location loc;
		loc = locationRepo.findFirstByLocationName(locationName);
		loc = (loc == null) ? loc = new Location() : loc;
		return new LocationDto(loc.getId(), loc.getLocationName(), loc.getLat(), loc.getLon());
		
	}
	
	@GetMapping("/getLocationInfo")
	public LocationDto getLocation(@Param("id") Long id) {
		Location loc;
		loc = locationRepo.findById(id).get();
		loc = (loc == null) ? loc = new Location() : loc;
		return new LocationDto(loc.getId(), loc.getLocationName(), loc.getLat(), loc.getLon());
	}
	
	@GetMapping("/getAllLocations")
	public List<LocationDto> getAllLocations() {
		ModelMapper mapper = new ModelMapper();
		List<Location> locs = new ArrayList<>();
		List<LocationDto> locDtos = new ArrayList<>();
		locs = (List<Location>) locationRepo.findAll();
		for(Location loc : locs) {
			locDtos.add(mapper.map(loc, LocationDto.class));
		}
		if(locDtos.size() == 0) {
			locDtos.add(new LocationDto());
			return locDtos;
		}
		return locDtos;
		
		
	}
	
	@PostMapping(value = "/createLocation", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locDto) {
		
		if(locDto.getLat() == 0 || locDto.getLon() == 0 || locDto.getLocationName() == "")
			return new ResponseEntity<LocationDto>(locDto, HttpStatus.BAD_REQUEST);
		
		Location loc = new Location();
		loc.setLat(locDto.getLat());
		loc.setLon(locDto.getLon());
		loc.setLocationName(locDto.getLocationName());
		loc = locationRepo.save(loc);
		
		locDto.setId(loc.getId());
		return new ResponseEntity<LocationDto>(locDto, HttpStatus.OK);
	}
	
}
