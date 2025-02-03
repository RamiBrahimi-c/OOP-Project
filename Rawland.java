public class Rawland extends Property {

    public Rawland( double price , String location , double size , Client owner , double rentPrice) {
        super( price, location, size, owner, rentPrice) ;
    }
    public Rawland() {
        super() ;
    }
    @Override
    public String toString() {
        return "Rawland ";
    }
}