package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import filter.Filter;
import model.dto.Coordinate;
import service.FilterService;
import service.TrajectoryService;
import service.implementation.FilterServiceImp;
import service.implementation.TrajectoryServiceImp;

public class TrajectoryController {
	private TrajectoryService trajectoryService;
	private FilterService filterService;
	
	public TrajectoryController() {
		trajectoryService = new TrajectoryServiceImp();
		filterService = new FilterServiceImp();
	}
	
	public List<Coordinate> getTrajectory(String dateFrom, String dateTo, String plate){
		Filter filter = filterService.setFilters(dateFrom, dateTo, plate);
		if (filter != null)
			return trajectoryService.getTrajectory(filter);
		else return trajectoryService.getAllTrajectories();
	}
	
	public List<String> getPlates(){
		return trajectoryService.getPlates();
	}
	
	public Map<String,String> getCoincidence(List<Coordinate> trajectory){
		Map<String,String> result = new HashMap<String,String>();
		List<Coordinate> preciseTrajectory = trajectoryService.setPrecision(trajectory, 3);
		SortedSet<Coordinate> trajectorySortedSet = trajectoryService.getSortedSetLocations(preciseTrajectory);
		Integer sizeSet = trajectorySortedSet.size();
		List<String> plates = this.getPlates();
		for(String plate : plates) {
			List<Coordinate> trajToCompare = this.getTrajectory(null, null, plate);
			trajToCompare = trajectoryService.setPrecision(trajToCompare, 3); //sets precision to 101 m
			SortedSet<Coordinate> setToCompare = trajectoryService.getSortedSetLocations(trajToCompare);
			setToCompare.retainAll(trajectorySortedSet); //keeps only the elements contained in both trajectories
			Double coincidence = ((double)setToCompare.size() / (double)sizeSet) * 100;
			result.put(plate, coincidence.toString());
		}
		return result;
	}
}
