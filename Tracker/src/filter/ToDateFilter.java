package filter;
import java.sql.Date;

public class ToDateFilter implements Filter {
	
	private Date d;
	
	public ToDateFilter(Date date) {
		this.d = date;
	}

	@Override
	public String getQuery() {
		return "l.date <= '" + this.d + "'";
	}
	
}
