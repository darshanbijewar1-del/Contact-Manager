public class PersonalContact extends Contact {
    private String relation;

    public personalContact(String name , String phone , string relation){
        super(name , phone);
        this.relation = relation;
    }

    public String displayInfo(){
        System.out.println("Personal Contact");
        System.out.println("name" + getName());
        System.out.println("phone" + getPhone());
        System.out.println("relation" + relation);
    }
}
