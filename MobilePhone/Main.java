package MobilePhone;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("054 867 632");

    // main method
    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();

        while(!quit){
            System.out.print("Enter 6 to show Available Actions: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Shutting down ...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

    // CASE 1: PRINT CONTACTS DONE IN THE MOBILE PHONE CLASS

    // CASE 2: ADD NEW CONTACT
    private static void addNewContact(){
        System.out.print("Enter Contact Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Phone Number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)){
//            System.out.println("Successfully Added Contact" + name + " phone --> " + phone);
            System.out.println("Successfully Added Contact");
        }else{
            System.out.println("Cannot Add " + name + " phone " + phone);
        }
    }

    // CASE 3: UPDATE A CONTACT
    private static void updateContact(){
        System.out.println("Enter Existing Contact Name: ");
        String name  = scanner.nextLine();
        Contact exitingContactRecord =  mobilePhone.queryContact(name);
        if(exitingContactRecord==null){
            System.out.println("Contact Not Found");
            //return;
        }
        System.out.print("Enter New Contact Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Contact Number: ");
        String newPhone = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newPhone);
        if(mobilePhone.updateContact(exitingContactRecord, newContact)){
            System.out.println("Successfully Updated Records");
        }else{
            System.out.println("Record Not Updated");
        }

    }
    // CASE 4: DELETED A CONTACT
    private static void deleteContact() {
        System.out.print("Enter Existing Contact Name: ");
        String name = scanner.nextLine();
        Contact exitingContactRecord = mobilePhone.queryContact(name);
        if (exitingContactRecord == null) {
            System.out.println("Contact Not Found");
            //return; //not necessary
        }
            if(mobilePhone.removeContact(exitingContactRecord)){
                System.out.println("Contact Successfully Deleted");
            }else{
                System.out.println("Error Deleting Contact");
            }
    }
    // CASE 5: QUERY A CONTACT
    private static void queryContact() {
        System.out.print("Enter Existing Contact Name: ");
        String name = scanner.nextLine();
        Contact exitingContactRecord = mobilePhone.queryContact(name);
        if (exitingContactRecord == null) {
            System.out.println("Contact Not Found");
            //return;
        }
        System.out.println("Name: " + exitingContactRecord.getName() + " --> Phone Number " +
                exitingContactRecord.getPhoneNumber());
    }

    private static void startPhone(){
        System.out.println("Starting mobile phone ... ");
    }
//CASE 6 AVAILABLE ACTIONS
    private static void printActions(){
        System.out.println("\nAvailable Actions\nPress");
        System.out.println(
                            "0 - Shutdown\n" +
                            "1 - View Contacts\n" +
                            "2 - Add a Contact\n" +
                            "3 - Update an Existing Contact\n" +
                            "4 - Delete a Contact\n" +
                            "5 - Search for a Contact\n" +
                            "6 - View Available Actions"
        );
        System.out.println("Select an Action: ");
    }


}
