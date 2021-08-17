package myArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstruction();
// while true
        while (!quit) {
            System.out.print("Enter an Option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstruction();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;

            }
        }
    }

    public static void printInstruction() {
        System.out.println("\nPress");
        System.out.println("\t 0 - Print Instructions.");
        System.out.println("\t 1 - Print Lists of Groceries.");
        System.out.println("\t 2 - Add Item to Grocery List.");
        System.out.println("\t 3 - Modify or Update a Grocery Item.");
        System.out.println("\t 4 - Remove or Delete a Grocery Item.");
        System.out.println("\t 5 - Query or Search for a Grocery Item.");
        System.out.println("\t 6 - Process Grocery List.");
        System.out.println("\t 7 - Exit or Quit The Program.");
    }

    public static void addItem(){
        System.out.print("Enter Grocery Item: ");
        String itemAdded = scanner.nextLine();
        groceryList.addGrocery(itemAdded);
        System.out.println( "- "+itemAdded +" was successfully added\n**** Lists of Groceries " +
                "****");
        groceryList.printGroceryList();
    }

    public static void modifyItem(){
        System.out.print("Name of Old Item: ");
        String oldItem = scanner.nextLine();
//        scanner.nextLine();
        System.out.print("Enter New Item: ");
        String replaceItem = scanner.nextLine();
//        scanner.nextLine();
        groceryList.modifyGloceryItem(oldItem, replaceItem);

        // Mine own lines of code
        System.out.println("\nUpdated Grocery Lists");
        groceryList.printGroceryList();
    }

    public static void removeItem(){
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        groceryList.deleteItem(itemName);
        System.out.println(itemName +  " Successfully Deleted");
    }

    public static void searchForItem(){
        System.out.print("Enter Name of Search Item: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found " + searchItem + " in Grocery List");
        }else{
            System.out.println(searchItem + " Not in Grocery List");
        }
    }

    public static void processArrayList(){
        // Method 1: two steps process of copying the entire content the grocery list
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        // Method 2: this copies the entire content of the arrayList shorthand
        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        //Method 3: converting an Array list to an Array
//        - creates an array and set the size to the size of the arrayList using  its getter
//        - convert the array list to array and store in the array created and parse the array
//        name in the toArray function.
        String[] myArray  = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}
