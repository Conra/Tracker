package service;

import filter.Filter;

public interface FilterService {
	public abstract Filter setFilters(String dateFrom, String dateTo, String plate);
}
