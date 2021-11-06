/**
 * Simulation Class holds main() to run the program
 */
public class Simulation extends MyInfo {

  // Used abstract method to handle showing my info
  public void getMyInfo() {
    System.out.println();
    System.out.println("Thank you for playing.  I hope you enjoyed my program.");
    System.out.println();
    System.out.println("I would really appreciate the opportunity to help your company achieve their, and their customer's goals!");
    System.out.println("Please feel free to contact me at 480.567.4900");
    System.out.println("or email me at matthew.turner.480@gmail.com");
    System.out.println();
    System.out.println("Thank you for your consideration and I look forward to your response.");
    System.out.println("Best, Matthew S. Turner");
    System.out.println();
  }

  public static void main(String[] args) {
    // instantiated class objects
    Pick3Cards p3c = new Pick3Cards();
    Simulation info = new Simulation();

    /**
     * Try block runs class methods and controls error
     * handling.  Finally closes the program.
     */
    try {
      p3c.BuildDeck();
      p3c.roundOne();
      p3c.roundTwo();
      p3c.roundThree();

    } catch (IndexOutOfBoundsException ex) {

      // User friendly message to help with debugging
      System.out.println("This is your problem: " +  ex.getMessage()   
          + "\nHere is where it happened:\n");
       ex.printStackTrace();
    
    // General purpose exception handler. Prints stack trace with user
    // friendly message to console.
    } catch (Exception ex) {
      ex = new Exception();
      ex.printStackTrace();
      String message = "Oh no, something has gone wrong. We'll need to start over.";
      System.out.println();
      System.out.println(message);
    
    // Finally will always run, and I used it to show my contact info and close the 
    // program.
    } finally {
      info.getMyInfo();
      System.exit(1);
    }
  }
}
