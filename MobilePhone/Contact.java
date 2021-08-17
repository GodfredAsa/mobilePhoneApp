package MobilePhone;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // getters
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // static method so we can create contact without instantiation
    public static Contact createContact(String name, String phone){
        return new Contact(name , phone);
    }
}
