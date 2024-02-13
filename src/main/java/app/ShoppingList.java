package app;

import utils.DynamicArrayList;

import java.util.Scanner;

/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DynamicArrayList shoppingList = new DynamicArrayList();

        //Asks the user how many entries they’d like to add to their shopping list
        System.out.print("How many entries would you like to add to your shopping list? ");
        int userNum = scanner.nextInt();

        //Prompts the user to enter the specified number of entries for their shopping list and adds each to the list (each
        //line can contain one or more words each, or may be null)
        System.out.println("Enter your shopping list entries");
        String entry;
        //Set i to -1 becease i had an issue of the first instance being skipped
        for (int i = -1; i < userNum; i++) {
            entry = scanner.nextLine();
            shoppingList.add(entry);
        }
        //. Loops through the shopping list and displays the content.
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + ". " + shoppingList.get(i));
        }
        //Repeatedly offers a menu of actions that can be done by the shopping list (based on the functionality you have
        //been tasked with) and provides the logic for each.

    }
}
