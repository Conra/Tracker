package filter;

public class PlateFilter implements Filter {

	private String p;
	
	public PlateFilter(String plate) {
		this.p = plate;
	}

	@Override
	public String getQuery() {
		return "l.plate = '" + this.p + "'"; 
	}
	
}
