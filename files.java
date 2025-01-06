import java.io.File ;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter ;
import java.io.IOException;

public class files {
  public static void main(String[] args) {
    try {
      FileWriter fw = new FileWriter("hi") ;
      fw.write("hi i am rami"); 
      fw.write("hello", 0, 5);
      fw.close();
      System.out.println("Successfully wrote to the file.");      
      
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
