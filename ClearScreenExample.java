public class ClearScreenExample {
        public static void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    
        public static void main(String[] args) {
            System.out.println("This text will be cleared.");
            clearScreen();
            System.out.println("Screen cleared!");
        }
}
