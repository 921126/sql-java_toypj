package hayoung;

public class CustomerVO {
	
	private int cid;
	private String c_name;
	private String phone;

	//생성자
	public CustomerVO() {}

	public CustomerVO(int cid, String c_name, String phone) {
		super();
		this.cid = cid;
		this.c_name = c_name;
		this.phone = phone;
	}

	//getter, setter
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//toString
	@Override
	public String toString() {
		return "CustomerVO [cid=" + cid + ", c_name=" + c_name + ", phone=" + phone + "]";
	}
	
	
	
	
	
}
