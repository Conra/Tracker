package filter;

public class AndFilter implements Filter{

	private Filter f1;
	private Filter f2;
	
	public AndFilter(Filter f1, Filter f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public String getQuery() {
		return f1.getQuery() + " AND " + f2.getQuery();
	}
}
