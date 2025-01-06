
public class Transaction {

    private Client client1 ;
    private Client client2 ;
    private double price ;
    private Property property ;

    public Transaction( Client client1 , Client client2 ,double price ,Property property ) {
        this.client1 = client1 ;
        this.client2 = client2 ;
        this.price = price ;
        this.property = property ;
    }
    public Transaction() {
        this.client1 = null ;
        this.client2 = null ;
        this.price = 0 ;
        this.property = null ;
    }

    // setters && getters
    public Client getClient1() {
        return client1;
    }
    public void setClient1(Client client1) {
        this.client1 = client1;
    }
    public Client getClient2() {
        return client2;
    }
    public void setClient2(Client client2) {
        this.client2 = client2;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Property getProperty() {
        return property;
    }
    public void setProperty(Property property) {
        this.property = property;
    }

    // methods 
    @Override
    public String toString() {
        return "Transaction [client1=" + this.client1 + ", client2=" + this.client2 + ", price=" + this.price + ", property="
                + this.property + "]";
    }



    public boolean rentProperty(Client tenant , Client landlord , Property property) {
        if (!landlord.getArr().contains(property)) {
            return false ;
        }
        if (property.getTenant() == null) {
            return false ;
        }
        if (tenant.getBudget() < property.getRentPrice()) {
            return false ;
        }

        property.setTenant(tenant);
        landlord.setBudget(landlord.getBudget()+ property.getRentPrice());
        tenant.setBudget(tenant.getBudget() - property.getRentPrice());

        return true ;
    }

}