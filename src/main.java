import java.util.Scanner;

public class main 
{
    public static void Cart() {
        // this will list all of the names and prices of each item
        System.out.println("The items are: ");
        // Lists the items
        // end list
        System.out.println("Do you want to go back to the main menu or do you want to go to checkout?");
        //
    }

    // Takes 2 strings, email and password, and returns true if they match the hard coded emails and passwords
    public static boolean validEmailAndPassword(String email, String password){
        // 2D Array of valid emails and passwords
        String[][] emailAndPasswordArray = {{"dmenhall@quinnipiac.edu", "password"}, {"pzegarek@quinnipiac.edu", "password2"}, {"pnora@quinnipiac.edu", "password3"}};

        for(int i = 0; i < emailAndPasswordArray.length; i++){
            if(email.equals(emailAndPasswordArray[i][0]) && password.equals(emailAndPasswordArray[i][1])){
                return true;
            }
        }
        return false;
    }

    // Has user login and if they fail 3 times then the program ends
    public static void login(){

        Scanner scan = new Scanner(System.in);

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

        scan.close();
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

        // Present menu with options

        
    }
}