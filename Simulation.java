public class Simulation {
  public static void main(String[] args) {
    Pick3Cards p3c = new Pick3Cards();

    // p3c.shuffleDeck();
    // p3c.BuildDeck();
    // p3c.Test();

    try {
      p3c.BuildDeck();
      p3c.roundOne();
      p3c.roundTwo();
    } finally {
      System.exit(1);
    }
  }
}
