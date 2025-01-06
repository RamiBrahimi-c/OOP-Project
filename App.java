import java.util.ArrayList;
import java.util.Scanner;

public class App {
    //ArrayList<Property> arr ;
    public static final String RESET = "\033[0m";     // Reset (default color)
    public static final String BLACK = "\033[0;30m";  // Black
    public static final String RED = "\033[0;31m";    // Red
    public static final String GREEN = "\033[0;32m";  // Green
    public static final String YELLOW = "\033[0;33m"; // Yellow
    public static final String BLUE = "\033[0;34m";   // Blue
    public static final String PURPLE = "\033[0;35m"; // Purple
    public static final String CYAN = "\033[0;36m";   // Cyan
    public static final String WHITE = "\033[0;37m";  // White

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in) ;
        
        int choice ;
        boolean condition=true ;

        ArrayList<Client> clients = new ArrayList<>() ;
        ArrayList<Transaction> transactions = new ArrayList<>() ;
        ArrayList<Property> propreties = new ArrayList<>() ;

        clients.add(new Client("Ahmed","Batna zemala" , "0787461513", 200)) ;
        clients.add(new Client("Mohamed" , "Alger centre" , "0684958798" , 500)) ;
        clients.add(new Client("Zaid", "Batna 5 juillet", "0513248794", 699)) ;
        clients.add(new Client("Kheiro", "Alger bab zouar", "044687951", 134)) ; 
        clients.add(new Client("Riad", "Setif al alia", "047846895", 134)) ;
        
        propreties.add(new Property("Commercial", 600, "Alger", 400, clients.get(1) ,398)) ;
         propreties.add(new Property("Commercial", 700, "Setif", 500, clients.get(2), 450)) ;
        propreties.add(new Property("Commercial", 800, "Annaba", 700, clients.get(3), 500)) ;
        propreties.add(new Property("Commercial", 900, "Batna", 789, clients.get(4), 500)) ;
        propreties.add(new Property("Commercial", 664, "Alger", 400, clients.get(4), 299)) ;
         

        clients.get(1).addProperty(propreties.get(0));

/*         System.out.println(clients.get(1)) ;
         */
        
        printSomething() ;
        while (condition) {
            
            System.out.println("enter something :!");
            choice = sc.nextInt() ;
            clearScreen();
            switch (choice) {
                case 0:
                clearScreen();
                    printSomething();
                break;
                case 1:
                    addClient(clients);
                break;
                case 4:
                /*                     for (int i = 0; i < clients.size(); i++) {

                        System.out.println("client number " + i + " : " + clients.get(i).toString() );
                    } */
                   printClients(clients);
                //    clearScreen();
                    break;
                case 5:
                    printProperties(propreties);
                    break;
                case 6:
                    
                    break;
            
                default:
                    condition=false ;
                    break;
            }
        }



        sc.close();
    }

    static void printSomething() {

        String tab = "\t" ;
        System.out.println(RED + "******************************************************");
        System.out.println("***** Welcome to the real state Agency App ! *********");
        System.out.println("******************************************************"+ RESET);
        System.out.println( BLUE+tab + tab + "Options : " + RESET);
        System.out.println(GREEN + tab + "0.Display this list");
        System.out.println(tab +"1.add Client");
        System.out.println(tab +"2.add Property");
        System.out.println(tab +"3.add Transaction");
        System.out.println(tab +"4.See List of Clients");
        System.out.println(tab +"5.See List of Properties");
        System.out.println(tab +"6.See List of the Last Transactions");
        System.out.println(tab +"7.Quit the program\n" + RESET);
        System.out.println(RED + "******************************************************");
        System.out.println("******************************************************");
        System.out.println("******************************************************" + RESET);

    }


    static void printClients(ArrayList <Client> clients) {
        int  length = clients.size() ;
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("id\t\tName\t\tAddress\t\t\tPhone Number\t\tBudget\t");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (int i = 0; i < length; i++) {
            Client client = clients.get(i) ;
            System.out.println( client.id + "\t\t" + client.getName() + "\t\t"+ client.getAddress() + "\t\t"+ client.getPhoneNumber() + "\t\t"+ client.getBudget() + " $" );
        }
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("total number = " + length);
    }
    static void printProperties(ArrayList <Property> properties) {
        int length = properties.size() ;
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("id\tType\t\tPrice\t\tLocation\tSize\t\tOwner Name\t\tRent Price\t");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < length; i++) {
            Property property  = properties.get(i);
            System.out.println(property.id+"\t" + property.getType() + "\t" + property.getPrice() + "\t\t" + property.getLocation() + "\t\t" + property.getSize() + " m²\t" + property.getOwner().getName() + "\t\t\t" +property.getPrice());
            
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("total number = " + length);
        
    }
   
   
    static void addClient(ArrayList<Client> clients) {
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in) ;
        clearScreen();

        System.out.println("-------------------- Inserting Client Process ---------------------");

        System.out.println("Enter the Client's Name : ");
        String name = sc.nextLine() ;
        System.out.println("Enter the Client's Address : ");
        String Address = sc.nextLine() ;
        System.out.println("Enter the Client's Phone Number : ");
        String phoneNumber = sc.nextLine() ;
        System.out.println("Enter the Client's Budget : ");
        int budget = sc.nextInt() ;

        Client client = new Client(name, Address, phoneNumber, budget) ;
        clients.add(client) ;
        System.out.println("------------------- Insertion Done Successfully ---------------------");
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sc.close();
        clearScreen();

    }
    static void addProperty(ArrayList<Property> properties) {
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in) ;
        clearScreen();

        System.out.println("-------------------- Inserting Property Process ---------------------");

        System.out.println("Enter the Property's Type : (1.residential 2.commercial 3.industrial 4.raw land 5.special use)");
        String type = sc.nextLine() ;
        System.out.println("Enter the Property's Price : ");
        double price = sc.nextDouble() ;
        System.out.println("Enter the Property's Location : ");
        String location = sc.nextLine() ;
        System.out.println("Enter the Property's Size : ");
        double size = sc.nextDouble() ;
        System.out.println("Enter the Property's Owner Name : ");
        String ownerName = sc.nextLine() ;
        System.out.println("Enter the Property's Rent Price : ");
        double rentPrice = sc.nextInt() ;

        properties.add(new Property(type, price, location, size, null, rentPrice)) ;

        System.out.println("------------------- Insertion Done Successfully ---------------------");
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sc.close();
        clearScreen();

    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }    
}
