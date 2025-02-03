import java.util.ArrayList;
import java.util.Scanner;

public class Rent extends Transaction {
    public Rent(Client client1, Client client2, double price, Property property) {
        super(client1, client2, price, property);
    }
    public Rent(Client client1, Client client2, double price, Property property , String date) {
        super(client1, client2, price, property , date);
    }
    public Rent() {
        super() ;
    }
    @Override

        public void setOperation(ArrayList<Transaction> transactions, ArrayList<Property> properties,
                ArrayList<Client> clients  ) { //, Property property ,Client seller , Client buyer
                     Scanner scanner = new Scanner(System.in) ;
                    int i ;
                 do {
                    
                    App.printProperties(properties , false);
                    System.out.println("Choose the property :");
                    i = scanner.nextInt() ;
                    
                } while (i < 1 || i > properties.size() );
                
                Property property = properties.get(--i) ;  
                if (!property.isAvailableForRent()) {
                    System.out.println(Colors.RED + "Property is not available for Rent !" + Colors.RESET);
                    try {
                        Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
        
                    return ;
                } 
                 
                  do {
                    App.printClients(clients , false);
                    System.out.println("Choose the Renter :");
                    i = scanner.nextInt() ;
    
                } while (i < 1 || i > clients.size() );
                Client renter = clients.get(--i) ;
                if (renter.getBudget() < property.getRentPrice()) {
                    System.out.println(Colors.RED + renter.getName() + "'s budget is not enough to rent the chosen property !" + Colors.RESET);
                    try {
                        Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return ;
                    
                }  
                
                Client owner = property.getOwner() ;
    
                property.setTenant(renter);
                property.setAvailableForRent(false);
                transactions.add(new Rent(owner,renter , property.getRentPrice(), property)) ;
    /* 
                property.setOwner(buyer);
                buyer.setBudget(buyer.getBudget()-property.getPrice());
                owner.setBudget(owner.getBudget()+property.getPrice());
                    
                transactions.add(new Sell(owner ,buyer , property.getPrice() , property )) ;
    */
                
                System.out.println(Colors.GREEN+"Operation done succefully" + Colors.RESET );
                try {
                    Thread.sleep(3000); // Pause for 3000 milliseconds (3 seconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                return ;
        }
        // without sql
/*         public static void setChangesOnRentedProperties(ArrayList<Property> properties ,ArrayList<Transaction> transactions ) {
            System.out.println("here 1");
            for (Property property : properties) {
                if (!property.isAvailableForRent()) {
                    Client renter = property.getTenant() ;
                    for (Transaction transaction : transactions) {
                        if (transaction.getClient2().id == renter.id) {
                            int day = transaction.getDate().lastIndexOf("/") ;
                            System.out.println(transaction.getDate().charAt(day));
                            // System.out.println("hiiiiiiiiiiiiiiiii");
                            try {
                                Thread.sleep(3000); // Pause for 3000 milliseconds (3 seconds)
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            
                        }
                    }
                }
            }
            System.out.println("here 2");
            try {
                Thread.sleep(3000); // Pause for 3000 milliseconds (3 seconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
 */

        @Override
        public String toString() {
            return "Rent ";
        }        
    }

