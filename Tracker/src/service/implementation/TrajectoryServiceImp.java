package service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import comparator.CoordinateComparator;
import filter.Filter;
import model.Location;
import model.dto.Coordinate;
import repository.LocationRepository;
import service.TrajectoryService;

public class TrajectoryServiceImp implements TrajectoryService{
	private LocationRepository locationRepository;
	
	public TrajectoryServiceImp() {
		locationRepository = new LocationRepository();
	}

	@Override
	public List<String> getPlates() {
		return locationRepository.getPlates();
	}

	@Override
	public List<Coordinate> getTrajectory(Filter filter) {
		List<Location> result = locationRepository.getLocations(filter);
		return this.toCoordinateList(result);
	}

	@Override
	public List<Coordinate> getAllTrajectories() {
		List<Location> result = locationRepository.getAll();
		return this.toCoordinateList(result);
	}
	
	@Override
	public List<Coordinate> toCoordinateList(List<Location> locations){
		List<Coordinate> trajectory = new ArrayList<Coordinate>();
		for(Location location : locations) {
			Double lat = location.getLatitude();
			Double lon = location.getLongitude();
			trajectory.add(new Coordinate(lat,lon));
		}
		return trajectory;
	}
	
	@Override
	public SortedSet<Coordinate> getSortedSetLocations(List<Coordinate> trajectory){
		SortedSet<Coordinate> set = new TreeSet<Coordinate>(new CoordinateComparator());
		set.addAll(trajectory);
		return set;
	}
	
	@Override
	public List<Coordinate> setPrecision(List<Coordinate> trajectory, Integer precision) {
		List<Coordinate> result = new ArrayList<Coordinate>();
		for (Coordinate coordinate : trajectory) {
			double lat = coordinate.getLat();
			double lon = coordinate.getLon();
			lat = Double.parseDouble(String.format("%."+ precision +"f", lat));
			lon = Double.parseDouble(String.format("%."+ precision +"f", lon));
			Coordinate coor = new Coordinate(lat,lon);
			result.add(coor);
		}
		return result;
	}
	
}
