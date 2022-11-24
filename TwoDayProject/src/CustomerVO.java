
public class CustomerVO {

   private int cid;
   private String name;
   private String phone;
   
   public CustomerVO() {
      }
   
   @Override
   public String toString() {
   return "[회원번호:"+ cid +"|회원이름:" + name + "|연락처" + phone + "]";
   }
   public CustomerVO(int cid,String name, String phone) {
   super();
   this.cid = cid;
   this.name = name;
   this.phone = phone;
   }
   
   public String getName() {
     return name;
   }
   
   public void setName(String name) {
     this.name = name;
   }
   
   public String getPhone() {
     return phone;
   }
   
   public void setPhone(String phone) {
     this.phone = phone;
   }

   public int getCid() {
      return cid;
   }

   public void setCid(int cid) {
      this.cid = cid;
   }
   
   

}