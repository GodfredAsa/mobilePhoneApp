package MobilePhone;

import org.w3c.dom.css.CSSUnknownRule;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private  ArrayList<Contact> myContacts;

    // constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    // add Contact method
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName())>=0){
            System.out.println("Contact already exist");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    // upDate Contact method
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition<0){
            System.out.println(oldContact.getName() + " was does not exits");
            return false;

            /*
             * this else if checks if the new contact name already exist then denies update
             * without it the program will still run, multiple contacts with the same name will
             * exist in the program
             */
        }else if(findContact(newContact.getName()) !=-1){
            System.out.println("Contact with " + newContact.getName() + " already Exists, Update " +
                    "not Successful");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " updated to " + newContact.getName());
        return  true;
    }

    // removeContact or deleteContact
    public boolean removeContact(Contact contact){
        int foundPosition  = findContact(contact);
        if(foundPosition<0){
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was successfully removed");
        return true;
    }

    // findContact method --> finds the index of a contact
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }
    // findContact method overwritten
    private int findContact(String contactName){
        for(int i=0; i<this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){ // checking if name in object is same as
                // name as parameter
                return i;
            }
        }
        return -1; // if does not exists
    }

    // QUERYING A CONTACT  OVERWRITTEN
    public String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.myContacts.get(position);
        }else{
            return null;
        }

    }

    // CASE 2: VIEW CONTACTS
    public void printContacts(){
        System.out.println("Contact Lists");
        for(int i=0; i<this.myContacts.size(); i++){
            System.out.println(i+1 + ". " + this.myContacts.get(i).getName() + " -->" +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }



}
