import java.util.ArrayList;
import java.util.Scanner;

public class Sell extends Transaction {
    public Sell(Client client1, Client client2, double price, Property property) {
        super(client1, client2, price, property);
    }
    public Sell(Client client1, Client client2, double price, Property property , String date) {
        super(client1, client2, price, property , date);
    }
        public Sell() {
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
            
             
              do {
                App.printClients(clients , false);
                System.out.println("Choose the buyer :");
                i = scanner.nextInt() ;

            } while (i < 1 || i > clients.size() );
            Client buyer = clients.get(--i) ;
            if (buyer.getBudget() < property.getPrice()) {
                System.out.println(Colors.RED + buyer.getName() + "'s budget is not enough to buy the chosen property !" + Colors.RESET);
                try {
                    Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ;
                
            }  
             Client seller = property.getOwner() ;




            property.setOwner(buyer);
            buyer.setBudget(buyer.getBudget()-property.getPrice());
            seller.setBudget(seller.getBudget()+property.getPrice());
                
            transactions.add(new Sell(seller ,buyer , property.getPrice() , property )) ;
            
            
            System.out.println(Colors.GREEN+"Operation done succefully" + Colors.RESET );
            try {
                Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return ;
    }
    @Override
    public String toString() {
        return "Sell ";
    }
    
}
