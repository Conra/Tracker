package filter;
import java.sql.Date;

public class FromDateFilter implements Filter{
	
	private Date d;
	
	public FromDateFilter(Date date) {
		this.d = date;
	}

	@Override
	public String getQuery() {
		return "l.date >= '" + this.d + "'";
	}
}
