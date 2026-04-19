public class BusinessContact extends Contact {

    private String company;

    public BusinessContact(String name, String phone, String company) {
        super(name, phone);
        this.company = company;
    }

    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company = company;
    }

    @Override
    public void displayInfo() {
        System.out.println("Business Contact");
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Company: " + company);
    }
    
}
