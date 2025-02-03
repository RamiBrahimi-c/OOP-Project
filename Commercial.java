public class Commercial extends Property {
    public Commercial( double price , String location , double size , Client owner , double rentPrice) {
        super( price, location, size, owner, rentPrice) ;
    }
    public Commercial() {
        super() ;
        // super.setType("Commercial");

    }
    @Override
    public String toString() {
        return "Commercial ";
    }
    
}
