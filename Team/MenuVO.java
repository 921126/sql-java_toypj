package Team;




public class MenuVO {

   
   
   private int MNO;
   private String M_NAME;
   private int PRICE;
   private int STOCK;

   @Override
public String toString() {
	return "MenuVO [MNO=" + MNO + ", M_NAME=" + M_NAME + ", PRICE=" + PRICE + ", STOCK=" + STOCK + "]";
}  public MenuVO() {
   
 }


public MenuVO(int mNO, String m_NAME, int pRICE, int sTOCK) {
	super();
	this.MNO = mNO;
	this.M_NAME = m_NAME;
	this.PRICE = pRICE;
	this.STOCK = sTOCK;
}

public int getMNO() {
	return MNO;
}

public void setMNO(int mNO) {
	MNO = mNO;
}

public String getM_NAME() {
	return M_NAME;
}

public void setM_NAME(String m_NAME) {
	M_NAME = m_NAME;
}

public int getPRICE() {
	return PRICE;
}

public void setPRICE(int pRICE) {
	PRICE = pRICE;
}

public int getSTOCK() {
	return STOCK;
}

public void setSTOCK(int sTOCK) {
	STOCK = sTOCK;
}

}