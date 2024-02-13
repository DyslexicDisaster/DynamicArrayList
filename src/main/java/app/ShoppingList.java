package app;

import utils.DynamicArrayList;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DynamicArrayList shoppingList = new DynamicArrayList();

        //Asks the user how many entries they’d like to add to their shopping list
        System.out.print("How many entries would you like to add to your shopping list? ");
        int userNum = sc.nextInt();

        //Prompts the user to enter the specified number of entries for their shopping list and adds each to the list (each
        //line can contain one or more words each, or may be null)
        System.out.println("Enter your shopping list entries");
        String entry;
        //Set i to -1 becease i had an issue of the first instance being skipped
        for (int i = -1; i < userNum; i++) {
            entry = sc.nextLine();
            shoppingList.add(entry);
        }
        //. Loops through the shopping list and displays the content.
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + ". " + shoppingList.get(i));
        }
        //Repeatedly offers a menu of actions that can be done by the shopping list (based on the functionality you have
        //been tasked with) and provides the logic for each.
        System.out.println("What would you like to do");
        System.out.println("1. Add item");
        System.out.println("2. Remove an item");
        System.out.println("3. Clone the list");
        System.out.println("4. Get the size of the list");
        System.out.println("5. Find index of");
        System.out.println("6. Exit");

        boolean exit = false;

        //You could use switch case for this step but i don't know how that works 100% so i went with the method i know better although it's not as good
        while (!exit){
            System.out.print("Enter your choice: ");
            int userChoice = sc.nextInt();
            sc.next();

            if (userChoice == 1) {
                System.out.print("Enter the item to add: ");
                String newItem = sc.nextLine();
                shoppingList.add(newItem);
                System.out.println("Item added successfully.");
                exit = true;
                //////// to make it more readable
            } else if (userChoice == 2) {
                System.out.print("Enter the item to remove: ");
                String remove = sc.nextLine();
                if (shoppingList.remove(remove)) {
                    System.out.println("Item removed successfully.");
                    exit = true;
                } else {
                    System.out.println("Item not found in the shopping list.");
                    exit = true;
                }
                /////
            } else if (userChoice == 3) {
                DynamicArrayList clonedList = shoppingList.clone();
                System.out.println("List cloned successfully.");
                exit = true;
                ////////
            } else if (userChoice == 4) {
                System.out.println("Size of the list: " + shoppingList.size());
                exit = true;
                ///////
            } else if (userChoice == 5) {
                System.out.print("Enter the item to find index of: ");
                String userItem = sc.nextLine();
                int index = shoppingList.indexOf(userItem);
                if (index != -1) {
                    System.out.println("Index of " + userItem + " in the list: " + index);
                    exit = true;
                } else {
                    System.out.println(userItem + " not found in the shopping list.");
                    exit = true;
                }
                //////////
            } else if (userChoice == 6) {
                System.out.println("Exiting...");
                exit = true;
                ///////////
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}