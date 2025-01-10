import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
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
        
        int choice =0;
        boolean condition=true ;

        ArrayList<Client> clients = new ArrayList<>() ;
        ArrayList<Transaction> transactions = new ArrayList<>() ;
        ArrayList<Property> propreties = new ArrayList<>() ;

        clients.add(new Client("Ahmed","Batna zemala" , "0787461513", 20000)) ;
        clients.add(new Client("Mohamed" , "Alger centre" , "0684958798" , 500)) ;
        clients.add(new Client("Zaid", "Batna 5 juillet", "0513248794", 699)) ;
        clients.add(new Client("Kheiro", "Alger bab zouar", "044687951", 134)) ; 
        clients.add(new Client("Riad", "Setif al alia", "047846895", 134)) ;
        
        propreties.add(new Property("Commercial", 600, "Alger", 400, clients.get(1) ,398)) ;
        propreties.add(new Property("Residential", 700, "Setif", 500, clients.get(2), 450)) ;
        propreties.add(new Property("Commercial", 800, "Annaba", 700, clients.get(3), 500)) ;
        propreties.add(new Property("Industriel", 900, "Batna", 789, clients.get(4), 500)) ;
        propreties.add(new Property("Special Use", 664, "Alger", 400, clients.get(4), 299)) ;
         

        clients.get(1).addProperty(propreties.get(0));


        
        while (condition) {
            clearScreen();
            printPrincipalMenu() ;
            
            try {
                System.out.println("enter something :!");
                choice = sc.nextInt() ;
                
            } catch (NoSuchElementException e) {
                System.out.println("here");
                e.printStackTrace();
            }
            switch (choice) {
                case 0:
                    clearScreen();
                    printPrincipalMenu();
                    break;
                case 1:
                    addClient(clients);
                    break;
                case 2 :
                    addProperty(propreties, clients);
                    break ;

                case 3:
         
                    setTransaction(transactions, propreties, clients);
                    break;
                case 4:

                   printClients(clients , true);
                    break;
                case 5:
                    printProperties(propreties  , true );
                    break;
                case 6:
                    printTransactions(transactions);
                    break;
            
                default:
                    condition=false ;
                    break;
            }
        }



        sc.close();
    }

    static void printPrincipalMenu() {

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


    static void printClients(ArrayList <Client> clients , boolean showSmallMenu) {
        clearScreen();
        int  length = clients.size() ;
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("id\t\tName\t\tAddress\t\t\tPhone Number\t\tBudget\t");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (int i = 0; i < length; i++) {
            Client client = clients.get(i) ;
            System.out.println( (i+1) + "\t\t" + client.getName() + "\t\t"+ client.getAddress() + "\t\t"+ client.getPhoneNumber() + "\t\t"+ client.getBudget() + " $" );
        }
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("total number = " + length);
        if (!showSmallMenu)
            return ;
    
        Scanner scanner = new Scanner(System.in) ;

        int choice  ;
        boolean running = true ;
        while (running) {
            System.out.println("\t1 . add new Client\t2 . change an info\t3 . Sort\t4 . exit");
            choice = scanner.nextInt() ;
            switch (choice) {
                case 1:
                addClient(clients);
                printClients(clients, false);
                    break;
                case 2 :
                    System.out.println("Enter client's ID ");
                    int i = scanner.nextInt();
                    if (i>0 && i < clients.size()+1) {
                        --i ;
                        System.out.println("Change : 1.Name\t2 .Address\t3. Phone Number\t4 .Budget");
                        int y = scanner.nextInt() ;
                        switch (y) {
                            case 1:
                                scanner.nextLine() ;
                                System.out.println("Enter new Name :");
                                String name = scanner.nextLine() ;
                                clients.get(i).setName(name);
                                break;
                            case 2:
                                scanner.nextLine() ;
                                System.out.println("Enter new Address :");
                                String address = scanner.nextLine() ;
                                clients.get(i).setAddress(address);
                                break;
                        
                            case 3:
                                scanner.nextLine() ;
                                System.out.println("Enter new Phone Number :");
                                String phoneNumber = scanner.nextLine() ;
                                clients.get(i).setPhoneNumber(phoneNumber);
                                break;
                        
                            case 4:
                                scanner.nextLine() ;
                                System.out.println("Enter new Budget :");
                                double budget = scanner.nextDouble() ;
                                clients.get(i).setBudget(budget);
                                break;
                        
                            default:
                                break;
                        }
                    } else {
                        System.out.println(RED+"Out OF Bound !" + RESET);
                    }
                    printClients(clients, false);
                    break;
                case 3:
                    System.out.println("Sort base on :1.Name\t2.Address\t3.Phone Number\t4.Budget");
                    int j = scanner.nextInt() ;
                    System.out.println("1.Ascending or 2.Descending Order ?");
                    int k = scanner.nextInt() ;
                    switch (j) {
                        case 1:
                            if (k==1) {
                            
                                clients.sort(null);
                            } else {
                                
                                Collections.sort(clients , Comparator.comparing(Client :: getName).reversed()); 
                            }
                            break;
                            case 2 :
                            if (k==1) {
                                
                                Collections.sort(clients , Comparator.comparing(Client :: getAddress)); 
                            } else {
                                Collections.sort(clients , Comparator.comparing(Client :: getAddress).reversed()); 
                                
                            }
                            
                            break ;
                            case 3 :
                            if (k==1) {
                                
                                Collections.sort(clients , Comparator.comparing(Client :: getPhoneNumber)) ;
                            } else {
                                Collections.sort(clients , Comparator.comparing(Client :: getPhoneNumber).reversed()) ;
                                
                            }
                                break ;
                            case 4 :
                            if (k==1) {
                                
                                Collections.sort(clients , Comparator.comparing(Client :: getBudget)) ;
                            } else {
                                Collections.sort(clients , Comparator.comparing(Client :: getBudget).reversed()) ;
                                
                            }
                            break ;
                            default:
                            clients.sort(null);
                            break;
                    }
                    printClients(clients, false);
                    break;
                default:
                    running=false ;
                    break;
            } 
        }
    }

    static void printProperties(ArrayList <Property> properties , boolean showSmallMenu) {
        clearScreen();
        int length = properties.size() ;
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("id\tType\t\tPrice\t\tLocation\tSize\t\tOwner Name\t\tRent Price\t");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < length; i++) {
            Property property  = properties.get(i);
            System.out.println(property.id+"\t" + property.getType() + "\t" + property.getPrice() + "\t\t" + property.getLocation() + "\t\t" + property.getSize() + " m²\t" + property.getOwner().getName() + "\t\t\t" +property.getPrice());
            
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Number = " + length);
       if (!showSmallMenu)
            return ;

        Scanner scanner = new Scanner(System.in) ;
        int choice  ;
        boolean running = true ;
        while (running) {
            System.out.println("\t1 . Delete Property\t2 . change an info\t3 . Sort\t4 . exit");
            choice = scanner.nextInt() ;
            switch (choice) {
                case 1:
                    System.out.println("Enter Property's ID");
                    int p = scanner.nextInt() ;
                    if (p>0 && p < length) {
                        --p ;
                        properties.remove(p) ;
                    } else {
                        System.out.println(RED + "OUT OF BOUND !" + RESET);
                    }
                    break;
                case 2 :
                    System.out.println("Enter Property's ID ");
                    int i = scanner.nextInt();
                    if (i>0 && i < properties.size()+1) {
                        --i ;
                        System.out.println("Change : 1.Type\t2 .Price\t3. Location\t4 .Size\t5 .Rent Price");
                        int y = scanner.nextInt() ;
                        switch (y) {
                            case 1:
                                scanner.nextLine() ;

                                System.out.println("Enter the Property's Type : (1.residential 2.commercial (Standard) 3.industrial 4.raw land 5.special use)");
                                int o = scanner.nextInt() ;
                        
                                String type = scanner.nextLine() ;
                                switch (o) {
                                    case 1:
                                        type = "Residential" ;
                                        break;
                                        case 2:
                                        type = "Commercial" ;
                                        
                                        break;
                                        case 3:
                                        type = "Industrial" ;
                                        
                                        break;
                                        case 4:
                                        type = "Raw Land" ;
                                        
                                        break;
                                        case 5:
                                        type = "Special Use" ;
                                        
                                        break;
                                        
                                        default:
                                        type = "Commercial" ;
                                        break;
                                }
                        
                                properties.get(i).setType(type);
                                break;
                            case 2:
                                scanner.nextLine() ;
                                System.out.println("Enter new Price :");
                                double price = scanner.nextDouble() ;
                                properties.get(i).setPrice(price);
                                break;
                        
                            case 3:
                                scanner.nextLine() ;
                                System.out.println("Enter new Location :");
                                String Location = scanner.nextLine() ;
                                properties.get(i).setLocation(Location);
                                break;
                        
                            case 4:
                                scanner.nextLine() ;
                                System.out.println("Enter new Size :");
                                double Size = scanner.nextDouble() ;
                                properties.get(i).setSize(Size);
                                break;
                            case 5:
                                scanner.nextLine() ;
                                System.out.println("Enter new Rent Price :");
                                double rent = scanner.nextDouble() ;
                                properties.get(i).setRentPrice(rent);
                                break;
                        
                            default:
                                break;
                        }
                    } else {
                        System.out.println(RED+"Out OF Bound !" + RESET);
                    }
                    printProperties(properties, false);
                    break;
                case 3:
                    System.out.println("Sort base on :1.Price\t2.Size\t3.Rent Price");
                    int j = scanner.nextInt() ;
                    System.out.println("1.Ascending or 2.Descending Order ?");
                    int k = scanner.nextInt() ;
                    switch (j) {
                        case 1:
                            if (k==1) {
                            
                                Collections.sort(properties, Comparator.comparing(Property :: getPrice));
                            } else {
                                
                                Collections.sort(properties, Comparator.comparing(Property :: getPrice).reversed());
                            }
                            break;
                            case 2 :
                            if (k==1) {
                                
                                Collections.sort(properties, Comparator.comparing(Property :: getSize));
                            } else {
                                Collections.sort(properties , Comparator.comparing(Property :: getSize).reversed()); 
                                
                            }
                            
                            break ;
                            case 3 :
                            if (k==1) {
                                
                                Collections.sort(properties , Comparator.comparing(Property :: getRentPrice)); 
                            } else {
                                Collections.sort(properties , Comparator.comparing(Property :: getRentPrice).reversed()); 
                                
                            }
                                break ;

                                
                                default:
                                    Collections.sort(properties, Comparator.comparing(Property :: getPrice));

                            break;
                    }
                    printProperties(properties, false);
                    break;
                default:
                    running=false ;
                    break;
            } 
        }
    }

    
   
    static void addClient(ArrayList<Client> clients) {
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in) ;
        clearScreen();

        System.out.println("-------------------- Inserting Client Process ---------------------");

        System.out.println("Enter the Client's Name : ");
        String name = scanner.nextLine() ;
        System.out.println("Enter the Client's Address : ");
        String Address = scanner.nextLine() ;
        System.out.println("Enter the Client's Phone Number : ");
        String phoneNumber = scanner.nextLine() ;
        System.out.println("Enter the Client's Budget : ");
        double budget = scanner.nextDouble() ;

        Client client = new Client(name, Address, phoneNumber, budget) ;
        clients.add(client) ;
        System.out.println("------------------- Insertion Done Successfully ---------------------");
        
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clearScreen();
       

    }
    
    
    
    static void addProperty(ArrayList<Property> properties , ArrayList <Client> clients) {
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in) ;
        clearScreen();

        System.out.println("-------------------- Inserting Property Process ---------------------");

        System.out.println("Enter the Property's Type : (1.residential 2.commercial (Standard) 3.industrial 4.raw land 5.special use)");
        int i = sc.nextInt() ;

        String type = sc.nextLine() ;
        switch (i) {
            case 1:
                type = "Residential" ;
                break;
                case 2:
                type = "Commercial" ;
                
                break;
                case 3:
                type = "Industrial" ;
                
                break;
                case 4:
                type = "Raw Land" ;
                
                break;
                case 5:
                type = "Special Use" ;
                
                break;
                
                default:
                type = "Commercial" ;
                break;
        }

        
        System.out.println("Enter the Property's Price : ");
        double price = sc.nextDouble() ;
        sc.nextLine();
        System.out.println("Enter the Property's Location : ");
        String location = sc.nextLine() ;
        System.out.println("Enter the Property's Size : ");
        double size = sc.nextDouble() ;

        // boolean i=true ;
        int j , k = 0 ;
        
            System.out.println("Here is the list of the registered clients choose one if the owner exists else you will insert a new client :");
            printClientsNames(clients);    
            j = sc.nextInt() ;

            if (j<1 || j > clients.size()) {
                addClient(clients);
                 j = clients.size()-1 ;
                 
            } else {
                --j ;
            }
        

        // System.out.println("Enter the Property's Owner Name : ");
        //String ownerName =  clients.get(k).getName();
        
        System.out.println("Enter the Property's Rent Price : ");
        double rentPrice = sc.nextInt() ;

        properties.add(new Property(type, price, location, size, clients.get(j), rentPrice)) ;

        System.out.println("------------------- Insertion Done Successfully ---------------------");
        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // sc.close();
        clearScreen();

    }

    static void printClientsNames(ArrayList <Client> clients) {
        int i=1 ;
        System.out.println("clients :");
        for (Client c : clients) {
            System.out.println("\t" + i++ + " "+ c.getName());
        }
        System.out.println();
    }



    static void setTransaction(ArrayList <Transaction> transactions , ArrayList <Property> properties  , ArrayList <Client> clients ) {
        int choice ;
        Scanner scanner = new Scanner(System.in) ;
        clearScreen();
        System.out.println("********************* Set New Transaction ********************");
        System.out.println("Enter the type of the transaction : (1. Sale\t2. Rent)");
        choice = scanner.nextInt() ;
        
            int i , j , k;


        if (choice==1) {
            
            do {
                printProperties(properties , false);
                System.out.println("Choose the property :");
                i = scanner.nextInt() ;
                
            } while (i < 1 || i > properties.size() );
            
            Property p = properties.get(--i) ;
            
            
            do {
                printClients(clients , false);
                System.out.println("Choose the buyer :");
                i = scanner.nextInt() ;

            } while (i < 1 || i >= clients.size() );
            Client buyer = clients.get(--i) ;
            if (buyer.getBudget() < p.getPrice()) {
                System.out.println(RED + buyer.getName() + "'s budget is not enough to buy the chosen property !" + RESET);
                try {
                    Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ;
                
            }
            Client owner = p.getOwner() ;
            p.setOwner(buyer);
            buyer.setBudget(buyer.getBudget()-p.getPrice());
            owner.setBudget(owner.getBudget()+p.getPrice());

            Transaction transaction = new Transaction(owner ,buyer , p.getPrice() , p , "Sale");
            transactions.add(transaction) ;
            System.out.println(GREEN+"Operation done succefully" + RESET);
            try {
                Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ;
        } else if (choice==2) {
            
        }
    }

    static void printTransactions(ArrayList <Transaction> transactions) {
        clearScreen();
        System.out.println("************************* List of the Transactions ****************************");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("N° \tPrice\tType\tClient 1\tClient 2\tProperty ID");
        System.out.println("-------------------------------------------------------------------------------");
        
        int j = 0 ;
        for (Transaction i : transactions) {
            System.out.println((++j) +"\t"+i.getPrice()+"\t" + i.getType() +"\t"+ i.getClient1().getName() +"\t\t"+ i.getClient2().getName() +"\t\t"+ i.getProperty().id);
            
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Total number : " + j);

        try {
            Thread.sleep(5000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }    
}
