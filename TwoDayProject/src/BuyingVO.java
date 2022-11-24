
public class BuyingVO {

	private int b_no;
	private String b_date;
	private int mno;
	private int count;
	private int cid;
	
	
	public BuyingVO() {
		// 기본 생성자
	}


	public BuyingVO(int b_no, String b_date, int mno, int count, int cid) {
		super();
		this.b_no = b_no;
		this.b_date = b_date;
		this.mno = mno;
		this.count = count;
		this.cid = cid;
	}


	@Override
	public String toString() {
		return "BuyingVO [b_no=" + b_no + ", b_date=" + b_date + ", mno=" + mno + ", count=" + count + ", cid=" + cid
				+ "]";
	}


	public int getB_no() {
		return b_no;
	}


	public void setB_no(int b_no) {
		this.b_no = b_no;
	}


	public String getB_date() {
		return b_date;
	}


	public void setB_date(String b_date) {
		this.b_date = b_date;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
	
	
}

