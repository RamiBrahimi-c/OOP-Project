import java.util.ArrayList;

public class Client implements Comparable<Client>{
    
    private String name ; 
    private String address ; 
    private String phoneNumber ; 
    private double budget ;
    private ArrayList <Property> properties = new ArrayList<>() ;
    private ArrayList <Transaction> transactions = new ArrayList<>();
    static int count = 0  ;
    public int id ;

    public Client( String name ,String address ,String phoneNumber , double budget ) {
        this.name= name ; 
        this.address= address ; 
        this.phoneNumber= phoneNumber ;
        this.budget = budget ;
        ++count ;
        this.id = count ;
    }
    public Client() {
        this.name= null ; 
        this.address= null ; 
        this.phoneNumber= null ;
        this.budget = 0 ;
        ++count ;
        this.id = count ;
    }

    // setters && getters

    public void setName(String name) {
        this.name=name ;
    }
    public void setAddress(String address) {
        this.address=address ;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber ;
    }

    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address ;
    }
    public String getPhoneNumber() {
        return this.phoneNumber ;
    }

    public ArrayList<Property> getArr() {
        return properties;
    }
    public void setArr(ArrayList<Property> properties) {
        this.properties = properties;
    }

    // 

    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public ArrayList<Property> getProperties() {
        return properties;
    }
    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    @Override
    public String toString() {
        return "Client [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", budget=" + budget
                + ", properties=" + properties + ", transactions=" + transactions + "]";
    }


    public void addProperty(Property p) {
        this.properties.add(0 , new Property( p.getPrice(), p.getLocation(), p.getSize(), new Client(p.getOwner().getName(), p.getOwner().getAddress(), p.getOwner().getPhoneNumber(), p.getOwner().getBudget()), p.getRentPrice())) ;
    }

    public boolean sellProperty(Client seller , Client buyer , Property property ) {
        if (! this.properties.contains(property)) {
            return false;
        }
        if (buyer.getBudget() < property.getPrice()) {
            return false ;
        }
/*         this.properties.remove(property) ;
        buyer.getArr().addLast(property);
        buyer.setBudget(buyer.getBudget() - property.getPrice());
        this.budget = this.budget + property.getPrice();
         */
        return true ;
    }
    @Override
    public int compareTo(Client arg0) {
        return name.compareTo(arg0.name) ;
    }
    


}
