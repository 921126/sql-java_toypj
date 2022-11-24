
public class MenuVO {

	
	
	private int m_no;
	private String m_name;
	private int price;
	private int stock;
	
	
	
	
	public MenuVO(int m_no, String m_name, int price, int stock) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.price = price;
		this.stock = stock;
	}
	
	public MenuVO() {
		// 기본 생성자
	}

	
	
	
	@Override
	public String toString() {
		return "MenuVO [m_no=" + m_no + ", m_name=" + m_name + ", price=" + price + ", stock=" + stock + "]";
	}

	
	
	
	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
}
