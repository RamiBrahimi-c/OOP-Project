import java.time.LocalDate;

public class Date {
    public static LocalDate currentDate = LocalDate.now() ;
    public static int year = currentDate.getYear() ;
    public static int month = currentDate.getMonthValue() ;
    public static int day = currentDate.getDayOfMonth();
    
}
