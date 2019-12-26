package service.implementation;

import java.sql.Date;

import filter.*;
import service.FilterService;

public class FilterServiceImp implements FilterService{
	@Override
	public Filter setFilters(String dateFrom, String dateTo, String plate) {
		Filter filter = null;
		if (dateFrom != null) {
			filter = new FromDateFilter(Date.valueOf(dateFrom));
			if (dateTo != null)
				filter = new AndFilter(filter, new ToDateFilter(Date.valueOf(dateTo)));
			if (plate != null)
				filter = new AndFilter(filter, new PlateFilter(plate));
			return filter;
		}
		else if (dateTo != null) {
			filter = new ToDateFilter(Date.valueOf(dateTo));
			if (plate != null)
				filter = new AndFilter(filter, new PlateFilter(plate));
			return filter;
		}
		if (plate != null)
			filter = new PlateFilter(plate);
		return filter;
	}
}
