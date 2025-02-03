public class Industrial extends Property {
    public Industrial( double price , String location , double size , Client owner , double rentPrice) {
        super( price, location, size, owner, rentPrice)  ;
    }
    public Industrial() {
        super() ;
        // super.setType("Industrial");

    }
    @Override
    public String toString() {
        return "Industrial ";
    }
    
}
