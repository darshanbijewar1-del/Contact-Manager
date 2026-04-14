abstract class Contact {
    private String name;
    private String phone;

   public contact (String name , String phone){
    this.name= name;
    this.phone = phone;
   }

   public String getName(){return name;}
   public String getPhone(){return phone;}

   public abstract void displayInfo();
}
