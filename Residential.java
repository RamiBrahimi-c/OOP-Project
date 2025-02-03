public class Residential extends Property {
    public Residential( double price , String location , double size , Client owner , double rentPrice) {
        super( price, location, size, owner, rentPrice) ;
    }
    public Residential() {
        super() ;
        // super.setType("Residential");

    }
    @Override
    public String toString() {
        return "Residential ";
    }
        
}
