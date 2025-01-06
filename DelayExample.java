public class DelayExample {
    public static void main(String[] args) {
        System.out.println("Starting delay...");

        try {
            Thread.sleep(2000); // Pause for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Delay finished.");
    }
}