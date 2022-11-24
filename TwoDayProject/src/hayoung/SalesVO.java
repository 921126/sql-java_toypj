package hayoung;

public class SalesVO {
	
	private String day;
	private int dayCount;
	private int daySales;
	
	//생성자
	public SalesVO() {}

	public SalesVO(String day, int dayCount, int daySales) {
		super();
		this.day = day;
		this.dayCount = dayCount;
		this.daySales = daySales;
	}

	//게터세터
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getDayCount() {
		return dayCount;
	}

	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	public int getDaySales() {
		return daySales;
	}

	public void setDaySales(int daySales) {
		this.daySales = daySales;
	}

	//toString
	@Override
	public String toString() {
		return "SalesVO [day=" + day + ", dayCount=" + dayCount + ", daySales=" + daySales + "]";
	}
	
	
	
	
}
