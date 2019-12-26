package service;

import java.util.List;
import java.util.SortedSet;

import filter.Filter;
import model.Location;
import model.dto.Coordinate;

public interface TrajectoryService {
	public abstract List<Coordinate> getTrajectory(Filter filter);
	public abstract List<Coordinate> getAllTrajectories();
	public abstract List<String> getPlates();
	public abstract SortedSet<Coordinate> getSortedSetLocations(List<Coordinate> trajectory);
	public abstract List<Coordinate> toCoordinateList(List<Location> locations);
	public abstract List<Coordinate> setPrecision(List<Coordinate> trajectory, Integer precision);
}
