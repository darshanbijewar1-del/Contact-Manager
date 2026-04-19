public class PersonalContact extends Contact {
    private String relation;

    public PersonalContact(String name, String phone, String relation) {
        super(name, phone);
        this.relation = relation;
    }

        public String getRelation(){
            return relation;
        }
        public void setRelation(String relation){
            this.relation = relation;
        }

    @Override
    public void displayInfo() {
        System.out.println("Personal Contact");
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Relation: " + relation);
    }
}