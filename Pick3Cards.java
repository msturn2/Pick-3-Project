import java.util.*;

public class Pick3Cards {
  private Randomizer randomizer = new Randomizer();
  // private Pick3Cards p3c = new Pick3Cards();
  private ArrayList<String> cards = new ArrayList<String>();
  private ArrayList<String> selected = new ArrayList<String>();
  private Scanner sc = new Scanner(System.in);
  private String[] numbers = {"2", "3", "4", "5", "6", "7", "8", 
    "9", "10", "Jack", "Queen", "King", "Ace"
  };
  private String[] suits = {
    "Hearts", 
    "Diamonds", 
    "Clubs", 
    "Spades"
  };
  private int counter = 0;
  private int cardNum;
  private int suitNum;
  // private String indexRemover1;
  // private String indexRemover2;
  // private String indexRemover3;

  public void setPick3Cards(
    Randomizer randomizer,
    // Pick3Cards p3c,
    ArrayList<String> cards, 
    ArrayList<String> selected, 
    Scanner sc, 
    String[] numbers, 
    String[] suits, 
    int counter, 
    int cardNum, 
    int suitNum
    // String indexRemover1,
    // String indexRemover2,
    // String indexRemover3
  ) {
    this.randomizer = randomizer;
    // this.p3c = p3c;
    this.cards = cards;
    this.selected = selected;
    this.sc = sc;
    this.numbers = numbers;
    this.suits = suits;
    this.counter = counter;
    this.cardNum = cardNum;
    this.suitNum = suitNum;
    // this.indexRemover1 = indexRemover1;
    // this.indexRemover2 = indexRemover2;
    // this.indexRemover3 = indexRemover3;
  }

  public Pick3Cards getPick3Cards(int counter, int cardNum, int suitNum) {
    return this.getPick3Cards(counter, cardNum, suitNum);
  }

  public void setCardNum(int cardNum) {
    this.cardNum = cardNum;
  }

  public int getCardNum() {
    return this.cardNum;
  }

  // public void setCards(ArrayList<String> cards) {
  //   this.cards = cards;
  // }

  public ArrayList<String> getCards() {
    return cards;
  }

  public void Test() {
    System.out.println(numbers.length);
    System.out.println(suits.length);
    System.out.println(counter);
  }

  public void BuildDeck() {
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < suits.length; j++) {
        cards.add(numbers[i] + " of " + suits[j]);
      }
    }
    
    // System.out.println(cards);
  }

  public void giveFirstTimeInstructions() {
    System.out.println("Welcome to Pick 3 Cards!");  
    System.out.println("Choose any three cards from the deck.");
    System.out.println("Don't worry about remembering them as we'll do that for you.");
    System.out.println("Please enter a number 2 - 14. 11 - 14 will represent Jacks - Aces.");
  }

  public void moveToNextCycle() {
    System.out.println("Please enter another number 2 - 14.");
    System.out.println("As before, 11 - 14 will represent Jacks - Aces.");
  }

  public void giveInstructions() {
    String[] cycles = {"first", "second", "third"};

    if (cardNum < 2 || cardNum > 14) {
      System.out.println("You don't like to read directions...Do you?...LOL, just kidding.");
      System.out.println("Please ONLY enter a number 2 - 14.  All other numbers will make this message repeat.");
      cardNum = sc.nextInt();

    } else if (cardNum >= 2 && cardNum <= 10) {
      System.out.println("You have selected a " + cardNum);
      System.out.println("Please select the suit. 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
      suitNum = sc.nextInt();

      if (suitNum < 0 || suitNum > 4) {
        System.out.println("Please enter a number 1 - 4 to select your suit.");
        System.out.println("Again, 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
        suitNum = sc.nextInt();

      } else if (suitNum > 0 && suitNum <= 4) {

        if (selected.isEmpty()) {
          selected.add(String.valueOf(cardNum) + " of " + suits[suitNum - 1]);
          System.out.println("You've chosen the " + cardNum + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(String.valueOf(cardNum) + " of " + suits[suitNum - 1]);
        
        } else if (!(selected.isEmpty()) && (!selected.contains(String.valueOf(cardNum) + " of " + suits[suitNum - 1]))) {
          selected.add(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println("You've chosen the " + cardNum + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(String.valueOf(cardNum) + " of " + suits[suitNum - 1]);

        } else if (!(selected.isEmpty()) && selected.contains(String.valueOf(cardNum) + " of " + suits[suitNum - 1])) {
          System.out.println("You've already chosen the: " + String.valueOf(cardNum) + " of " + suits[suitNum - 1]);
          System.out.println("Please pick a card that you haven't alredy picked.");
        }

        counter++;
      }
    } else if (cardNum > 10 && cardNum <= 14) {
      System.out.println("You have selected a " + numbers[cardNum - 2]);
      System.out.println("Please select the suit. 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
      suitNum = sc.nextInt();

      if (suitNum < 0 || suitNum > 4) {
        System.out.println("Please enter a number 1 - 4 to select your suit.");
        System.out.println("Again, 1 = 'Hearts', 2 = 'Diamonds', 3 = 'Clubs', and 4 = 'Spades'.");
        suitNum = sc.nextInt();

      } else if (suitNum > 0 && suitNum <= 4) {

        if (selected.isEmpty()) {
          selected.add(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println("You've chosen the " + numbers[cardNum - 2] + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(cards.indexOf(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]));

        } else if (!(selected.isEmpty()) && (!selected.contains(String.valueOf(cardNum) + " of " + suits[suitNum - 1]))) {
          selected.add(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println("You've chosen the " + numbers[cardNum - 2] + " of " + suits[suitNum - 1] + " for your " + cycles[counter] + " card.");
          cards.remove(cards.indexOf(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]));

        } else if (!(selected.isEmpty()) && selected.contains(String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1])) {
          System.out.println("You've already chosen the: " + String.valueOf(numbers[cardNum - 2]) + " of " + suits[suitNum - 1]);
          System.out.println("Please pick a card that you haven't alredy picked.");

        }
        
        counter++;
      }
    }
  }

  public void roundOne() {

    do {
      giveFirstTimeInstructions();
      cardNum = sc.nextInt();

      while (counter < 4) {
        switch(counter) {
          case 0:
            giveInstructions();
          case 1: 
            moveToNextCycle();
            cardNum = sc.nextInt();
            giveInstructions();
          case 2:
            moveToNextCycle();
            cardNum = sc.nextInt();
            giveInstructions();
          case 3:
            System.out.println("Your cards are " + selected);
            System.out.println(cards.size());
            // System.out.println(cards);
            System.out.println("Now, are you ready to see some magic?...Of course you are!");
            counter++;
            break;
          default:
            continue;  
        }
      }
    } while (counter < 4);
  }

  public void roundTwo() {
    do {

      System.out.println("Helllllooooooooooooooooooooo................................" + getCards());

      System.out.println("Now we'll suffle the deck without your three cards");
      System.out.println("Please enter the number 49 and ONLY 49");
      shuffleDeck();

      // System.out.println(cards);

      if (cardNum == 49 && counter == 4) {
        System.out.println("Thank you. The deck is shuffled.");
        System.out.println("Now I will place the deck into 4 piles. A pile of 10, 15, 15 and 9 cards");
        System.out.println("Next, we'll place your first card on top of the pile of 10.");
        System.out.println("Next, please pick a number between 0 - 14, but not 0, or 14");
        cardNum = sc.nextInt();

        // if (cardNum > 0 && cardNum < 14) {

        // }
      }
    } while (true);
  }

  public void shuffleDeck() {
    // randomizer.randomNumber();
    randomizer.test();
    
  }

  // public void getBuildDeck() {
  //   int[] idx = getShuffleDeck();

  //   for (int i = 0; i < idx.length; i++) {
  //     System.out.println((i + 1) + ": " + idx[i]);
  //   }
  // }
}


// * 4 Pillars of OOP
// * Must create and use at least 3 Constructors
// * Must have at least 4 methods
// * Must include a section to get responses from User
// * Must contain a switch statement
// * Must handle at least 1 exception
// * Project must include at least 3 Classes
// * Use one of the Collections structures.
// * Use a loop to traverse through your Collection structure that you chose and modify,// * organize, or return values from the iteration. 
// * ex. Sort my structure, Search, find and return object 