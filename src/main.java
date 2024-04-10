import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
    static ArrayList<Item> itemsForSale = new ArrayList<>();
    static ArrayList<Item> cart = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    static String[][] currentItemsForSale = new String[0][3];

    static class Item {
        String name;
        String category;
        String sellerFirstName;
        String sellerLastName;
        String sellerEmail;
        double price;

        public Item(String name, String category, String sellerFirstName, String sellerLastName, String sellerEmail, double price) {
            this.name = name;
            this.category = category;
            this.sellerFirstName = sellerFirstName;
            this.sellerLastName = sellerLastName;
            this.sellerEmail = sellerEmail;
            this.price = price;
        }

        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("Category: " + category);
            System.out.println("Seller: " + sellerFirstName + " " + sellerLastName + " (" + sellerEmail + ")");
            System.out.println("Price: $" + price);
        }
    }

    public static void checkout() {
        double totalCost = 0;
        for (Item item : cart) {
            totalCost += item.price;
        }
        System.out.println("Your total is: $"+totalCost);
    }
    
    public static void Cart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Item item : cart) {
                System.out.println("- " + item.name + " - $" + item.price);
            }
        }
        System.out.println("What do you want to do now?");
        System.out.println("1. Main Menu");
        System.out.println("2. Checkout");
        System.out.println("Select an option: ");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                showMainMenu();
                break;
            case 2:
                // Implement checkout functionality if required
                checkout();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                Cart();
                break;
        }
        // Implement checkout functionality if required
        showMainMenu();
    }

    // Takes 2 strings, email and password, and returns true if they match the hard coded emails and passwords
    public static boolean validEmailAndPassword(String email, String password){
        // 2D Array of valid emails and passwords
        String[][] emailAndPasswordArray = {{"dmenhall@quinnipiac.edu", "password"}, {"pzegarek1@quinnipiac.edu", "password2"}, {"pnora@quinnipiac.edu", "password3"}};

        for(int i = 0; i < emailAndPasswordArray.length; i++){
            if(email.equals(emailAndPasswordArray[i][0]) && password.equals(emailAndPasswordArray[i][1])){
                return true;
            }
        }
        return false;
    }

    // Has user login and if they fail 3 times then the program ends
    public static void login(){

        String email;
        String password;
        int numAttempts = 0;
        boolean incorrectEmailAndPassword = true, notLockout = true;

        do{

            // Input email
            System.out.print("Login \nQuinnipiac Email: ");
            email = scan.nextLine();

            // Input password
            System.out.print("Password: ");
            password = scan.nextLine();

            if(validEmailAndPassword(email, password)){

                incorrectEmailAndPassword = false;

            }else{

                // Increase number of attempts
                numAttempts++;

                // Once you take 3 attempts, it will end the while and make it locked out
                if(numAttempts == 3){
                    notLockout = false;
                }

            }

        // While the email and password are incorrect and not locked out
        }while(incorrectEmailAndPassword && notLockout);

        if(!notLockout){
            // If failed 3 times prints locked out and quits program
            System.out.println("YOU ARE LOCKED OUT DUE TO SUSPICIOUS ACTIVITY");
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {   
        // Welcome output
        System.out.println(" __       __            __                                                      __                                _______                      \n" + //
                           "/  |  _  /  |          /  |                                                    /  |                              /       \\                     \n" + //
                           "$$ | / \\ $$ |  ______  $$ |  _______   ______   _____  ____    ______         _$$ |_     ______          ______  $$$$$$$  |  ______   __    __ \n" + //
                           "$$ |/$  \\$$ | /      \\ $$ | /       | /      \\ /     \\/    \\  /      \\       / $$   |   /      \\        /      \\ $$ |__$$ | /      \\ /  |  /  |\n" + //
                           "$$ /$$$  $$ |/$$$$$$  |$$ |/$$$$$$$/ /$$$$$$  |$$$$$$ $$$$  |/$$$$$$  |      $$$$$$/   /$$$$$$  |      /$$$$$$  |$$    $$<  $$$$$$  |$$ |  $$ |\n" + //
                           "$$ $$/$$ $$ |$$    $$ |$$ |$$ |      $$ |  $$ |$$ | $$ | $$ |$$    $$ |        $$ | __ $$ |  $$ |      $$ |  $$ |$$$$$$$  | /    $$ |$$ |  $$ |\n" + //
                           "$$$$/  $$$$ |$$$$$$$$/ $$ |$$ \\_____ $$ \\__$$ |$$ | $$ | $$ |$$$$$$$$/         $$ |/  |$$ \\__$$ |      $$ \\__$$ |$$ |__$$ |/$$$$$$$ |$$ \\__$$ |\n" + //
                           "$$$/    $$$ |$$       |$$ |$$       |$$    $$/ $$ | $$ | $$ |$$       |        $$  $$/ $$    $$/       $$    $$ |$$    $$/ $$    $$ |$$    $$ |\n" + //
                           "$$/      $$/  $$$$$$$/ $$/  $$$$$$$/  $$$$$$/  $$/  $$/  $$/  $$$$$$$/          $$$$/   $$$$$$/         $$$$$$$ |$$$$$$$/   $$$$$$$/  $$$$$$$ |\n" + //
                           "                                                                                                             $$ |                    /  \\__$$ |\n" + //
                           "                                                                                                             $$ |                    $$    $$/ \n" + //
                           "                                                                                                             $$/                      $$$$$$/  ");

        // User login
        login();
        initializeItemsForSale();
        showMainMenu();

        // Present menu with options

        
    }

    public static void initializeItemsForSale() {
        itemsForSale.add(new Item("Used Textbook", "Books", "John", "Doe", "jdoe@quinnipiac.edu", 50.00));
        itemsForSale.add(new Item("Dorm Chair", "Furniture", "Jane", "Smith", "jsmith@quinnipiac.edu", 25.00));
        itemsForSale.add(new Item("Graphic Calculator", "Electronics", "Mike", "Brown", "mbrown@quinnipiac.edu", 75.00));
        itemsForSale.add(new Item("Hoodie", "Clothing", "Emily", "Jones", "ejones@quinnipiac.edu", 20.00));
        itemsForSale.add(new Item("Laptop Stand", "Accessories", "Chris", "White", "cwhite@quinnipiac.edu", 15.00));
    }

    public static void showMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Buy");
        System.out.println("2. Sell");
        System.out.println("3. Cart");
        System.out.println("4. Logout");
        System.out.print("Select an option: ");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                buy();
                break;
            case 2:
                sell();
                break;
            case 3:
                Cart();
                break;
            case 4:
                System.out.println("Logging out...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                showMainMenu();
                break;
        }
    }

    public static void buy() {
        System.out.println("\nItems for sale:");
        for (int i = 0; i < itemsForSale.size(); i++) {
            System.out.println((i + 1) + ". " + itemsForSale.get(i).name + " - $" + itemsForSale.get(i).price);
        }
        System.out.println((itemsForSale.size() + 1) + ". Go back to main menu");
        System.out.print("Select an item to view details or add to cart: ");
        int choice = scan.nextInt();
        if (choice == itemsForSale.size() + 1) {
            showMainMenu();
        } else if (choice > 0 && choice <= itemsForSale.size()) {
            Item selectedItem = itemsForSale.get(choice - 1);
            selectedItem.displayDetails();
            System.out.println("1. Add to cart");
            System.out.println("2. Go back");
            System.out.print("Select an option: ");
            int itemChoice = scan.nextInt();
            if (itemChoice == 1) {
                cart.add(selectedItem);
                System.out.println(selectedItem.name + " added to cart.");
                showMainMenu();
            } else {
                buy();
            }
        } else {
            System.out.println("Invalid option. Please try again.");
            buy();
        }
    }

    public static void sell(){
        System.out.println("\nSeller Options: \n1. Current Items \n2. Add New Item \n3. Back");
        System.out.print("Select an option: ");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                System.out.println();
                if(currentItemsForSale.length == 0){
                    System.out.println("You have no items for sale");
                }else{
                    for(int i = 0; i < currentItemsForSale.length; i++){
                        System.out.println("---Item " + (i+1) + "---");
                        System.out.println("Name: " + currentItemsForSale[i][0] + " \nCategory: " + currentItemsForSale[i][1] + " \nPrice: $" + currentItemsForSale[i][2]);
                    }
                }
                sell();
                break;
            case 2:
                String[][] tempCurrentItemsForSale = new String[(currentItemsForSale.length + 1)][3];
                for(int x = 0; x < currentItemsForSale.length; x++){
                    for(int y = 0; y < 3; y++){
                        tempCurrentItemsForSale[x][y] = currentItemsForSale[x][y];
                    }
                }
                System.out.print("Enter name: ");
                tempCurrentItemsForSale[tempCurrentItemsForSale.length-1][0] = scan.nextLine();
            
                System.out.print("Enter category: ");
                tempCurrentItemsForSale[tempCurrentItemsForSale.length-1][1] = scan.nextLine();
               
                System.out.print("Enter price: ");
                tempCurrentItemsForSale[tempCurrentItemsForSale.length-1][2] = scan.nextLine();

                currentItemsForSale = tempCurrentItemsForSale;

                sell();
                break;
            case 3:
                showMainMenu();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                sell();
                break;
        }
    }
}