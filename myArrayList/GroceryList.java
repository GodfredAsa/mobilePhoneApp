package myArrayList;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<>();


    // getter NB: not part of the main program
    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    // adding an item
    public void addGrocery(String item){
        groceryList.add(item);
    }

    //printing items
    public void printGroceryList(){
        for( int i =0 ; i< groceryList.size(); i++){
            System.out.println((i+1) + " "+ groceryList.get(i));
        }
    }

    //updating an item
    public void modifyGloceryItem(String currentItem, String newItem){
        int position = findItem(currentItem);
        if(position>=0){
            modifyGroceryItem(position, newItem);
        }

    }
    private void modifyGroceryItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Item at " + (position + 1) + " updated to " + newItem);
    }

// finding an item in the grocery list
    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position>=0){
            return true;
        }
        return false;
    }

    //deleting an item
    public void deleteItem(String item){
        int position = findItem(item);
        if(position>=0){
            deleteItem(position);
        }
    }

    private void deleteItem(int position){
        groceryList.remove(position);
    }
}



