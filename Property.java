

public class Property {
    // private String type ;
    private double price ;
    private String location ;
    private double size  ;
    private Client owner ;
    private double rentPrice ;
    private Client tenant ;
    private boolean availableForRent ;
    static int count = 0  ;
    public int id ;

    // condstructors 
    public Property() {
        this.price = 0 ;
        this.location = null ;
        this.size = 0 ;
        this.owner = null ;
        this.rentPrice= 0 ;
        this.availableForRent=true ;
        ++count ;
        this.id = count ;
    }

    public Property ( double price , String location , double size , Client owner , double rentPrice) {
        // this.type = type ;
        this.price = price ;
        this.location = location ;
        this.size = size ;
        this.owner = owner ;
        this.rentPrice = rentPrice ;
        this.availableForRent=true ;
        ++count ;
        this.id = count ;
    }

    // setters && getters
    
/*     public String getType() {
        return this.type ;
    }  */
    public double getPrice() {
        return this.price ;
    } 
    public String getLocation() {
        return this.location ;
    } 
    public double getSize() {
        return this.size ;
    } 
    public Client getOwner() {
        return this.owner ;
    }

    /* 
    public void setType(String type) {
        this.type = type ;
    } */
    public void setPrice(double price) {
        this.price = price ;
    }
    public void setLocation(String location) {
        this.location = location ;
    }
    public void setSize(double size) {
        this.size = size ;
    }
    public void setOwner(Client owner) {
        this.owner=owner ;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Client getTenant() {
        return tenant;
    }
    public void setTenant(Client tenant) {
        this.tenant = tenant;
    }

    

 

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAvailableForRent() {
        return availableForRent;
    }

    public void setAvailableForRent(boolean availableForRent) {
        this.availableForRent = availableForRent;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Property [price=" + price + ", location=" + location + ", size=" + size + ", owner=" + owner
                + ", rentPrice=" + rentPrice + ", tenant=" + tenant + ", availableForRent=" + availableForRent + ", id="
                + id + "]";
    }

    /* @Override
    public String toString() {
        return "Property [type=" + type + ", price=" + price + ", location=" + location + ", size=" + size + ", owner="
                + owner + ", rentPrice=" + rentPrice + ", tenant=" + tenant + "]";
    }
 */
    



    // methods 


}






